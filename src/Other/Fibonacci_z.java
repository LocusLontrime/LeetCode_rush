package Other;

import java.math.BigInteger;

public class Fibonacci_z {

    static long[] memo_table;

    public static void main(String[] args) {

        // long finish1 = System.nanoTime();

        // System.out.println(fibonacci_recursive(43));

        // long finish2 = System.nanoTime();

        // System.out.println(fib_memo(92));

        long finish3 = System.nanoTime();

        System.out.println(fib_bot_up(6)); // 366

        long finish4 = System.nanoTime();

        // System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");
        // System.out.println("t2 = " + (finish3 - finish2) / 1000 + " microsec");
        System.out.println("t3 = " + (finish4 - finish3) / 1000 + " microsec");

    }

    public static long fibonacci_recursive (int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);

    }

    public static long fib_memo (int n) {

        memo_table = new long[n + 1];

        return fibonacci_rec_memo(n);

    }


    public static long fibonacci_rec_memo (int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo_table[n] == 0) memo_table[n] = fibonacci_rec_memo(n - 1) + fibonacci_rec_memo(n - 2);

        return memo_table[n];

    }

    public static BigInteger fib_bot_up (int n) {

        BigInteger fib_1before = BigInteger.ONE, fib_2before = BigInteger.ZERO;

        for (int i = 1; i < n; i ++) {

            fib_1before = fib_1before.add(fib_2before);
            fib_2before = fib_1before.subtract(fib_2before);

        }

        return fib_1before;
    }
}
