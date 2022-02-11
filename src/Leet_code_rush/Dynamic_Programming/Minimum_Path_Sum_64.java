package Leet_code_rush.Dynamic_Programming;

public class Minimum_Path_Sum_64 { /** accepted (speed: fast) **/

    static int[][] memo_table;
    static int[][] matrix;
    static int i_max, j_max;

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        matrix = new int[][] {{1, 4, 3, 6, 7}, {5, 2, 9, 8, 9}, {6, 3, 6, 2, 1}, {2, 4, 3, 5, 7}, {8, 7, 2, 8, 9}};
        System.out.println(minPathSum(matrix));
    }

    public static int minPathSum(int[][] grid) {
        i_max = grid[0].length;
        j_max = grid.length;
        matrix = grid;
        memo_table = new int[j_max][i_max];

        return recursive_seeker(0, 0);
    }

    public static int recursive_seeker(int j, int i) {
        if (j == j_max - 1 && i == i_max - 1) return matrix[j][i];
        if (memo_table[j][i] == 0) {
            if (j == j_max - 1) return recursive_seeker(j, i + 1) + matrix[j][i];
            if (i == i_max - 1) return recursive_seeker(j + 1, i) + matrix[j][i];
            memo_table[j][i] = Math.min(recursive_seeker(j + 1, i), recursive_seeker(j, i + 1)) + matrix[j][i];
        }
        return memo_table[j][i];
    }
}
