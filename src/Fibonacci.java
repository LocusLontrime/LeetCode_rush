import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

    public static BigInteger [][] fibonacci_matrix = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

    public static BigInteger[][] E_matrix = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};

    public static void main(String[] args) {

        System.out.println(fibonacci_matrix[0][0] + " " + fibonacci_matrix[0][1]);
        System.out.println(fibonacci_matrix[1][0] + " " + fibonacci_matrix[1][1]);

        long start = System.nanoTime();

        //BigInteger[][] fib = fib_matrix_pow(15000000);

        long finish1 = System.nanoTime();

        //System.out.println(fib[0][0] + " " + fib[0][1]);
        //System.out.println(fib[1][0] + " " + fib[1][1]);

        //System.out.println(fibonacci_simple(15000000));

        long finish2 = System.nanoTime();

        BigInteger[][] fib_recursive = matrix_pow_recursive(fibonacci_matrix, 1000000);

        System.out.println(fib_recursive[0][1]);

        // fib_recursive[0][1].toString();

        //System.out.println(fib_recursive[0][0] + " " + fib_recursive[0][1]);
        //System.out.println(fib_recursive[1][0] + " " + fib_recursive[1][1]);

        long finish3 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start) / 1000 + " microsec");

        System.out.println("t2 = " + (finish2 - finish1) / 1000 + " microsec");

        System.out.println("t3 = " + (finish3 - finish2) / 1000 + " microsec");

    }

    public static BigInteger fibonacci_simple (int N) {

        BigInteger f2 = BigInteger.ZERO, f1 = BigInteger.ONE;
        BigInteger temp;

        for (int i = 1; i < N; i ++) {

            f2 = f2.add(f1);

            temp = f1;
            f1 = f2;
            f2 = temp;

        }

        return f2;
    }

    public static BigInteger[][] matrix_pow_recursive (BigInteger[][] matrix, long N) {

        if (N == 0) return E_matrix;
        if (N == 1) return matrix;

        if (N % 2 == 0) return matrix_pow_recursive(multiply_two_rows_matrices(matrix, matrix), N / 2);
        else return multiply_two_rows_matrices(matrix, matrix_pow_recursive(multiply_two_rows_matrices(matrix, matrix), (N - 1) / 2));
    }

    public static BigInteger[][] multiply_two_rows_matrices (BigInteger[][] a, BigInteger[][] b) {

        BigInteger [][] multiplication = new BigInteger[2][2];

        multiplication[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        multiplication[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        multiplication[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        multiplication[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));

        return multiplication;

    }
}
