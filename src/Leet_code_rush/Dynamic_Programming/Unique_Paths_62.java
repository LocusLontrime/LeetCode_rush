package Leet_code_rush.Dynamic_Programming;

import java.math.BigInteger;

public class Unique_Paths_62 {



    public static void main(String[] args) {

        long finish1 = System.nanoTime();

        System.out.println("Unique ways' quantity: " + uniquePaths_Big_Int( 3000, 3000));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

    }

    public static int uniquePaths(int m, int n) { /** accepted (speed: fast) **/

        int[][] ways = new int[m][n];

        for (int j = m - 1; j >= 0; j --) {
            ways[j][n-1] = 1;
        }

        for (int i = n - 1; i >= 0; i --) {
            ways[m-1][i] = 1;
        }

        for (int i = n - 2; i >= 0; i --) {
            for (int j = m - 2; j >= 0; j --) {
                ways[j][i] = ways[j + 1][i] + ways[j][i + 1];
            }
        }

        return ways[0][0];
    }

    public static BigInteger uniquePaths_Big_Int(int m, int n) { // BigInteger Version

        BigInteger[][] ways = new BigInteger[m][n];

        for (int j = m - 1; j >= 0; j --) {
            ways[j][n-1] = BigInteger.ONE;
        }

        for (int i = n - 1; i >= 0; i --) {
            ways[m-1][i] = BigInteger.ONE;
        }

        for (int i = n - 2; i >= 0; i --) {
            for (int j = m - 2; j >= 0; j --) {
                ways[j][i] = ways[j + 1][i].add(ways[j][i + 1]);
            }
        }

        return ways[0][0];
    }

}
