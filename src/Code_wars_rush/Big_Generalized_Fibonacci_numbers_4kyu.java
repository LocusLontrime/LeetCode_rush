package Code_wars_rush;
import java.math.BigInteger;

public class Big_Generalized_Fibonacci_numbers_4kyu {

    public static void main(String[] args) {

        byte[] a = {1, 1};
        byte[] b = {1, 1};

        a = new byte[] {-1, 3, -2};
        b = new byte[] {2, 2, -2};

        System.out.println(get(a, b, 17));
    }

    public static BigInteger get (byte[] a, byte[] b, long power)
    {
        return getTheNum(matrix_pow_recursive(getBaseMatrix(b), power - b.length + 1, b.length), a);
    }

    public static BigInteger[][] matrix_pow_recursive (BigInteger[][] matrix, long N, int n) {

        if (N == 0) return getE(n);
        if (N == 1) return matrix;

        if (N % 2 == 0) return matrix_pow_recursive(multiply_two_rows_matrices(matrix, matrix), N / 2, n);
        else return multiply_two_rows_matrices(matrix, matrix_pow_recursive(multiply_two_rows_matrices(matrix, matrix), (N - 1) / 2, n));
    }

    public static BigInteger[][] multiply_two_rows_matrices (BigInteger[][] left, BigInteger[][] right) {

        if (left[0].length != right.length) {
            System.out.println("Multiplication is not allowed!");
        }

        BigInteger[][] multipliedMatrix = new BigInteger[left.length][right[0].length];

        for (int i = 0; i < multipliedMatrix.length; i++) {
            for (int j = 0; j < multipliedMatrix[0].length; j ++) {
                multipliedMatrix[i][j] = BigInteger.ZERO;

                for (int n = 0; n < left[0].length; n ++) {
                    multipliedMatrix[i][j] = multipliedMatrix[i][j].add(left[i][n].multiply(right[n][j]));
                }
            }
        }

        return multipliedMatrix;
    }

    public static BigInteger[][] getBaseMatrix(byte[] b) {

        int l = b.length;

        BigInteger[][] base = new BigInteger[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                base[i][j] = BigInteger.ZERO;
            }
        }

        for (int i = 0; i < l - 1; i++) {
            base[i + 1][i] = BigInteger.ONE;
        }

        for (int i = 0; i < l; i++) {
            base[i][l - 1] = BigInteger.valueOf(b[l - i - 1]);
        }

        return  base;
    }

    public static BigInteger[][] getE(int dim) {
        BigInteger[][] E = new BigInteger[dim][dim];

        for(int i = 0; i < dim; i++) {
            E[i][i] = BigInteger.ONE;
        }

        return E;
    }

    public static BigInteger getTheNum(BigInteger[][] matrix, byte[] a) {

        BigInteger res = BigInteger.ZERO;

        for (int i = 0; i < matrix.length; i++) {
            res = res.add(matrix[i][matrix[0].length - 1].multiply(BigInteger.valueOf(a[i])));
        }

        return res;
    }
}
