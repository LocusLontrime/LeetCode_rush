package Leet_code_rush.Dynamic_Programming;

public class Cherry_Pickup_741 {

    public static int[][][] memo_table;
    public static int[][] matrix;

    public static int i_max, j_max;

    public static void main(String[] args) {



    }

    public static int cherryPickup(int[][] grid) {

        matrix = grid;

        j_max = matrix.length;
        i_max = matrix[0].length;

        memo_table = new int[j_max][i_max][j_max];

        return recursive_seeker(0, 0, 0);

    }

    public static int recursive_seeker (int init_j, int init_i, int back_j) {

        return 989;

    }
}
