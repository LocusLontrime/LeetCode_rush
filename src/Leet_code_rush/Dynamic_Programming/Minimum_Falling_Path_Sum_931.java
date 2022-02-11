package Leet_code_rush.Dynamic_Programming;

public class Minimum_Falling_Path_Sum_931 { /** accepted (speed: fast) **/

    static int[][] memo_table;
    static int[][] grid;
    static int i_max, j_max;

    public static void main(String[] args) {

        //System.out.println(minFallingPathSum(new int[][] {{1, 4, 3, 6, 7}, {8, 9, 7, 6, 5}, {4, 3, 6, 6, 6}, {9, 1, 11, 2, 1}, {3, 2, 2, 7, 9}}));

        System.out.println(minFallingPathSum(new int[][] {{82,81},{69,33}}));

    }

    public static int minFallingPathSum(int[][] matrix) {

        grid = matrix;

        i_max = grid[0].length;
        j_max = grid.length;

        System.out.println("i_max = " + i_max + " j_max = " + j_max);

        memo_table = new int[j_max][i_max];

        int min_sum_of_falling_path = Integer.MAX_VALUE;

        for (int i = 0; i < i_max; i ++) {

            min_sum_of_falling_path = Math.min(min_sum_of_falling_path, recursive_seeker(0, i));
            System.out.println("Current min sum = " + min_sum_of_falling_path);
        }

        return min_sum_of_falling_path; //366

    }

    public static int recursive_seeker(int j, int i) {

        if (j == j_max - 1) {memo_table[j][i] = grid[j][i]; return memo_table[j][i];}

        if (memo_table[j][i] == 0) {

            if (i == i_max - 1) memo_table[j][i] = Math.min(recursive_seeker(j + 1, i), recursive_seeker(j + 1, i - 1)) + grid[j][i];

            else if (i == 0) memo_table[j][i] = Math.min(recursive_seeker(j + 1, i + 1), recursive_seeker(j + 1, i)) + grid[j][i];

            else memo_table[j][i] = Math.min(Math.min(recursive_seeker(j + 1, i - 1), recursive_seeker(j + 1, i)), recursive_seeker(j + 1, i + 1)) + grid[j][i];
        }

        return memo_table[j][i];

    }
}
