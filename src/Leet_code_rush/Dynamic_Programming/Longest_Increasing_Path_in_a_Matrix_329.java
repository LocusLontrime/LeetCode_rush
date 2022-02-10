package Leet_code_rush.Dynamic_Programming;

public class Longest_Increasing_Path_in_a_Matrix_329 { /** accepted (speed: 7ms, ultra-fast, beats 94<7 java submissions) **/

    static int[][] memo_table;
    static int[][] matrix_given;
    static int height;
    static int width;
    static final int[][] directions = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // an array of four possible directions of path-building in matrix given

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{3, 12, 14, 15, 98}, {6, 11, 10, 8, 8}, {7, 2, 1, 6, 7}, {6, 3, 4, 5, 9}, {4, 3, 6, 6, 1}}; // matrix

        matrix = get_random_matrix(30000, 30000);

        //print_2D_Matrix(matrix);

        long finish1 = System.nanoTime();

        System.out.println("Matrix height = " + matrix.length + " Matrix width = " + matrix[0].length);
        System.out.println(longestIncreasingPath(matrix));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

    }

    public static int longestIncreasingPath(int[][] matrix) {

        matrix_given = matrix;
        height = matrix.length;
        width = matrix[0].length;

        if (height == 1 && width == 1) return 1;

        memo_table = new int [height][width]; // memo

        int longest_path_length = 0;

        for (int i = 0; i < width; i ++) { // i - cycle

            for (int j = 0; j < height; j ++) { // j - cycle

                longest_path_length = Math.max(longest_path_length, recursive_seeker(i, j)); // all matrix elements

            }

        }

        return longest_path_length;

    }

    public static int recursive_seeker (int i, int j) {

        if (memo_table[j][i] > 0) return memo_table[j][i];

        int longest_way_length = 0;

        for (int[] directions_arr : directions) {

            if(i + directions_arr[0] >= 0 && i + directions_arr[0] < width && j + directions_arr[1] >= 0 && j + directions_arr[1] < height &&
                    matrix_given[j + directions_arr[1]][i + directions_arr[0]] > matrix_given[j][i]) longest_way_length =
                    Math.max(longest_way_length, recursive_seeker(i + directions_arr[0], j + directions_arr[1]));
        }

        memo_table[j][i] = ++longest_way_length;

        return memo_table[j][i];

    }

    public static int[][] get_random_matrix (int height, int width) {

        int[][] matrix = new int[height][width];

        for (int i = 0; i < width; i ++) {

            for (int j = 0; j < height; j ++) {

                matrix[j][i] = (int) (Integer.MAX_VALUE * Math.random());
                //System.out.println("lala");

            }

        }

        return matrix;

    }

    public static void print_2D_Matrix (int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i ++) {

            for (int j = 0; j < matrix.length; j ++) {

                if (matrix[j][i] / 10 < 1) System.out.print(matrix[j][i] + "  ");
                else System.out.print(matrix[j][i] + " ");
            }

            System.out.println();

        }

    }

}
