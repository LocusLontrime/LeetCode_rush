package Leet_code_rush.Math;

public class Sqrt_x_69 {

    static int n;
    static int bin_counter;

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println("Square root (binary search) = " + mySqrt(36666*36666));

        long finish1 = System.nanoTime();

        System.out.println("Square root (Newton int) = " + mySqrt_Newton_int(36666*36666));

        long finish2 = System.nanoTime();

        System.out.println("Square root (Newton) = " + mySqrt_Newton(36666*36666, 10));

        long finish3 = System.nanoTime();

        System.out.println("t1 (bin, int) = " + (finish1 - start) / 1000 + " microsec");
        System.out.println("t2 (Newton, int) = " + (finish2 - finish1) / 1000 + " microsec");
        System.out.println("t3 (Newton, double) = " + (finish3 - finish2) / 1000 + " microsec");
    }

    public static long mySqrt(int x) { /** accepted (speed: 1ms, ultra-fast, beats 99,77% submissions **/

        if (x == 1) return 1;

        n = x;
        bin_counter = 0;

        return binarySearch(0, x);
    }

    public static long binarySearch (long left_border, long right_border) { // we are computing an integer square root of x using recursive binary search
        // in array of elements starting from zero to x itself

        bin_counter++;

        long temp_median = (left_border + right_border) / 2; // finding of pivot element

        if (temp_median * temp_median <= n && (temp_median + 1) * (temp_median + 1) > n) {
            System.out.println("Number of bin steps = " + bin_counter);
            return temp_median; // if pivot^2 == x ( or n) then we return pivot as
        } // result

        else if ((temp_median * temp_median) < n) return binarySearch(temp_median, right_border); // if x (or n) > pivot^2 then we start a new search
            // in the right part of the current interval
        else return binarySearch(left_border, temp_median); // if not -> we start seeking in the left part
    }

    /**
     * double version of LeetCode task
     * @param x - a number to evaluate a square root of
     * @param precision - the better precision the closer the result to the real value of square root
     * @return square root of x with the precision given
     */

    public static double mySqrt_Newton(int x, int precision) { // widening method to double values of sqrt

        if (precision < 0) {
            System.out.println("Precision cannot be less than zero");
            return 0;
        }

        if (x == 0) return 0; // dangerous case

        int step_counter = 0;

        double prec =  Math.pow(10, -precision);

        System.out.println("Newton double Precision = " + prec);

        double sqrt_prev;
        double sqrt_n = x;

        do {
            step_counter++;
            sqrt_prev = sqrt_n; // memoization
            sqrt_n = (sqrt_n + x / sqrt_n) / 2; // recursive scheme of Newton for evaluating square roots
        } while (sqrt_prev - sqrt_n > prec); // break condition for precision given

        System.out.println("Number of Newton double steps = " + step_counter);

        return sqrt_n;
    }

    public static int mySqrt_Newton_int(int x) { /** int version accepted (speed: 1ms, ultra-fast, beats 99,77% submissions **/

        if (x == 0) return 0;

        double sqrt_n = x;
        double sqrt_prev;

        int step_counter = 0;

        do { //if (sqrt(n) - sqrt(n-1) == 1 - end of while cycle
            step_counter++;
            sqrt_prev = sqrt_n;
            sqrt_n = (sqrt_n + x / sqrt_n) / 2;
        } while (!(sqrt_prev - sqrt_n < 1));

        System.out.println("Number of Newton int steps = " + step_counter);

        return (int) sqrt_n;
    }

}
