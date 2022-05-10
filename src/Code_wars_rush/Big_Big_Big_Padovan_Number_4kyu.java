package Code_wars_rush;

import java.math.BigInteger;

public class Big_Big_Big_Padovan_Number_4kyu {

    public static BigInteger[][] E_matrix = {
            {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE}
    };

    public static BigInteger[][] Padovan_Matrix = {
            {BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE},
            {BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE},
            {BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO}
    };

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println(get(1000000));

        long finish1 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start) / 1000 + " microsec");
    }

    public static BigInteger get (long power)
    {
        return matrix_pow_recursive(Padovan_Matrix, (int) power + 1)[1][2];
    }

    public static BigInteger[][] matrix_pow_recursive (BigInteger[][] matrix, long N) {

        if (N == 0) return E_matrix;
        if (N == 1) return matrix;

        if (N % 2 == 0) return matrix_pow_recursive(multiply_two_rows_matrices(matrix, matrix), N / 2);
        else return multiply_two_rows_matrices(matrix, matrix_pow_recursive(multiply_two_rows_matrices(matrix, matrix), (N - 1) / 2));
    }

    public static BigInteger[][] multiply_two_rows_matrices (BigInteger[][] a, BigInteger[][] b) {

        BigInteger [][] multiplication = new BigInteger[3][3];

        multiplication[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])).add(a[0][2].multiply(b[2][0]));
        multiplication[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1])).add(a[0][2].multiply(b[2][1]));
        multiplication[0][2] = a[0][0].multiply(b[0][2]).add(a[0][1].multiply(b[1][2])).add(a[0][2].multiply(b[2][2]));
        multiplication[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])).add(a[1][2].multiply(b[2][0]));
        multiplication[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1])).add(a[1][2].multiply(b[2][1]));
        multiplication[1][2] = a[1][0].multiply(b[0][2]).add(a[1][1].multiply(b[1][2])).add(a[1][2].multiply(b[2][2]));
        multiplication[2][0] = a[2][0].multiply(b[0][0]).add(a[2][1].multiply(b[1][0])).add(a[2][2].multiply(b[2][0]));
        multiplication[2][1] = a[2][0].multiply(b[0][1]).add(a[2][1].multiply(b[1][1])).add(a[2][2].multiply(b[2][1]));
        multiplication[2][2] = a[2][0].multiply(b[0][2]).add(a[2][1].multiply(b[1][2])).add(a[2][2].multiply(b[2][2]));

        return multiplication;
    }

    public static void printMatrix (BigInteger[][] matrix) {

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(matrix[j][i] + " ");
            }

            System.out.println();
        }
    }
}
