package Leet_code_rush.Dynamic_Programming;

public class Minimum_Falling_Path_Sum_II_1289 { /** accepted (speed: 2ms, ultra-fast, beats 99,63% java submissions) **/

    static int[][] dp;
    static int[][] matrix;
    static int i_max, j_max;

    public static void main(String[] args) {

        System.out.println(minFallingPathSum(new int[][] {{4, 17, 7, 6, 5}, {3, 66, 6, 5, 1}, {33, 12, 55, 98, 4}, {36, 2, 3, 56, 43}, {1, 17, 4, 5, 98}}));

        print_2D_array(dp);

    }

    public static int minFallingPathSum(int[][] grid) {

        matrix = grid;
        i_max = matrix[0].length; // width
        j_max = matrix.length; // height
        dp = new int[j_max][i_max];

        int[] min_and_min_before = new int[2];

        // now we start evaluating the min_falling_path_sum

        int min_current_dp;

        int min_counter;

        for (int i = 0; i < i_max; i ++) dp[j_max - 1][i] = matrix[j_max - 1][i]; // initial fulfilling - bottom row of dp[][]

        for (int j = j_max - 2; j >= 0; j --) {

            min_counter = 0;

            min_current_dp = Integer.MAX_VALUE;

            for (int i = 0; i < i_max; i++) if (dp[j + 1][i] < min_current_dp)  min_current_dp = dp[j + 1][i];

            for (int i = 0; i < i_max; i++) if (dp[j + 1][i] == min_current_dp) min_counter++;

            min_and_min_before[0] = min_current_dp;

            min_current_dp = Integer.MAX_VALUE;

            for (int i = 0; i < i_max; i++) if (dp[j + 1][i] < min_current_dp && dp[j + 1][i] != min_and_min_before[0]) min_current_dp = dp[j + 1][i];

            if (min_current_dp != Integer.MAX_VALUE) min_and_min_before[1] = min_current_dp;
            else min_and_min_before[1] = min_and_min_before[0];

            System.out.println("Min = " + min_and_min_before[0] + " min_before = " + min_and_min_before[1]);

            for (int i = 0; i < i_max; i++) {
                if (dp[j + 1][i] != min_and_min_before[0]) dp[j][i] = min_and_min_before[0] + matrix[j][i];
                else dp[j][i] = min_counter == 1 ? min_and_min_before[1] + matrix[j][i] : min_and_min_before[0] + matrix[j][i];
            }
        }

        min_current_dp = Integer.MAX_VALUE;

        for (int i = 0; i < i_max; i ++) {
            min_current_dp = Math.min(min_current_dp, dp[0][i]);
        }

        return min_current_dp;
    }

    public static void print_2D_array (int[][] array) { // auxiliary method for 2D array printing

        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

}
