package Code_wars_rush;

import java.math.BigInteger;


public class Faberge_Easter_Eggs_3kyu {

    public static void main(String[] args   ) {

        long start = System.nanoTime();

        System.out.println(height(BigInteger.valueOf(10000), BigInteger.valueOf(20000)));

        long finish = System.nanoTime();

        // BigInteger n = new BigInteger("123456789");
        // System.out.println(n.intValue());

        System.out.println("\nПрошло времени в милисекундах : " + (finish - start) / 1000000);
    }

    public static BigInteger height(BigInteger n, BigInteger m) {

        BigInteger delta;

        if (n.compareTo(m) >= 0) return baseSummand(m); // power of two case

        if (n.multiply(BigInteger.valueOf(2)).compareTo(m) <= 0) {
            delta = combsSum(n.intValue(), m);
            return delta.subtract(BigInteger.ONE);
        }
        else {
            delta = combsSum(m.intValue() - n.intValue() - 1, m);
            return baseSummand(m).subtract(delta);
        }
    }

    public static BigInteger combsSum(int count, BigInteger m) { // a crucial optimization

        BigInteger delta = BigInteger.ONE;
        BigInteger factorial = BigInteger.ONE;
        BigInteger consecutiveMultiplication = BigInteger.ONE;

        for (int i = 1; i <= count; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            consecutiveMultiplication = consecutiveMultiplication.multiply(m.subtract(BigInteger.valueOf(i - 1)));
            delta = delta.add(consecutiveMultiplication.divide(factorial));
        }

        return delta;
    }

    public static BigInteger baseSummand(BigInteger m) {
        return BigInteger.valueOf(2).pow(m.intValue()).subtract(BigInteger.ONE);
    }

    // old auxiliary methods
    public static BigInteger combinations(BigInteger k, BigInteger m) { // TODO -> C of k elements from m

        if (k.multiply(BigInteger.valueOf(2)).compareTo(m) > 0) return combinations(m.subtract(k), m);

        BigInteger combinations = BigInteger.ONE;

        int i = 0;

        while (i < k.intValue()) {
            // System.out.println(m.subtract(BigInteger.valueOf(i)));
            combinations = combinations.multiply(m.subtract(BigInteger.valueOf(i++)));
        }

        return combinations.divide(factorial(k));
    }

    public static BigInteger factorial(BigInteger k) {
        if (k.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;

        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= k.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
