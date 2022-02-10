package Leet_code_rush.Dynamic_Programming;

import java.util.HashMap;

public class LeetCode_rush_10 { /** accepted **/

    static HashMap<Integer, Integer>[] least_operations;

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println("Least operations number " + leastOpsExpressTarget(2,10125026));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //System.out.println(5*5*5*5*5*5*5*5*5*5*5);

    }

    /**
     *
     * @param x - given a single positive integer x, we will write an expression of the form x (op1) x (op2) x (op3) x ...
     * where each operator op1, op2, etc. is either addition, subtraction, multiplication, or division (+, -, *, or /).
     * For example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.
     *
     * When writing such an expression, we adhere to the following conventions:
     *
     * 1. The division operator (/) returns rational numbers.
     * 2. There are no parentheses placed anywhere.
     * 3. We use the usual order of operations: multiplication and division happen before addition and subtraction.
     * 4. It is not allowed to use the unary negation operator (-). For example, "x - x" is a valid expression as it only uses subtraction, but "-x + x" is not because it uses negation.
     *
     * @param target - we would like to write an expression with the least number of operators such that the expression equals the given target
     * @return the least number of operators used
     */

    public static int leastOpsExpressTarget(int x, int target) {

        int iterations_quantity = (int) (Math.log10(target)/Math.log10(x));

        least_operations = new HashMap[iterations_quantity + 2];

        for (int i = 0; i < least_operations.length; i++) {
            least_operations[i] = new HashMap<Integer, Integer>();
        }

        System.out.println(iterations_quantity);

        return leastOpsExpress(x, iterations_quantity + 1, target) - 1; // minus one because the first left operation does not begin with plus

    }

    /**
     *
     * @param x - base
     * @param iteration - current iteration, it means the power of base at the current recursive step
     * @param reminder - remainder after previous (i + 1) recursive step
     * @return the least operations number
     */

    public static int leastOpsExpress (int x, int iteration, int reminder) {

        if (iteration == 0) return 2 * reminder; // this is the last recursive step until comparison in return fields has begun

        int k_positive = 0, k_negative;

        while (reminder - (k_positive + 1) * Math.pow(x, iteration) > 0) k_positive++;
        k_negative = k_positive + 1;

        //System.out.println("iteration = " + iteration + " reminder = " + reminder + " k positive = " + k_positive + " k negative = " + k_negative);

        if (!least_operations[iteration].containsKey(reminder)) least_operations[iteration].put(reminder, Math.min(leastOpsExpress(x, iteration - 1, (int) (reminder - k_positive * Math.pow(x, iteration))) + k_positive * iteration, leastOpsExpress(x, iteration - 1,(int) (k_negative * Math.pow(x, iteration) - reminder)) + k_negative * iteration));

        return least_operations[iteration].get(reminder);
    }

}
