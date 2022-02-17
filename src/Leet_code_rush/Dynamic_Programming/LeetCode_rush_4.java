package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_4 { /** top-down accepted **/

    static int recursive_counter = 0, max_square_size = 0;
    static char[][] matrix;
    static short[][] memo_max_lengths; // 2D - array of maximal (1 - filled) squares whose right bottom angle is situated in (i,j) - coordinates of the matrix given
    public static short k = 1;

    public static void main(String[] args) {

        char [][] matrix = {{'0', '1'}, {'1', '0'}}; //{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}; //{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        matrix = random_bin_matrix(3000, 3000);

        //print_2D_array(matrix);

        long start = System.nanoTime();
        System.out.println("Max square area = " + maximalSquare(matrix));
        System.out.println("Recursive counter = " + recursive_counter);
        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);

        //print_2D_array(matrix);
    }

    /**
     *
     * @param matrix - given an m x n binary matrix filled with 0's and 1's
     * @return the largest square containing only 1's and return its area
     */

    public static int maximalSquare(char[][] matrix) {

        LeetCode_rush_4.matrix = matrix;
        memo_max_lengths = new short[matrix.length][matrix[0].length];

        long start = System.nanoTime();

        memo_minus_fulfilling();

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах (заполнение мемо-матрицы) : " + (finish - start) / 1000);

        max_square_in_the_point(matrix.length - 1, matrix[0].length - 1);

        return max_square_size * max_square_size;
    }

    public static int max_square_in_the_point (int i, int j) { // recursive max square seeker, top-down realization

        //System.out.println("Now locating i = " + i + " j = " + j + " point");

        recursive_counter++;
        int flag = 0;

        if (memo_max_lengths[i][j] == -1)  {

            if (i == 0 || j == 0) memo_max_lengths[i][j] = (short) (matrix[i][j] == 1 ? 1 : 0);
            else {
                if (matrix[i][j] == '1') flag = 1; // bottleneck point - comparison char value with one
                //System.out.println("Flag = " + flag);
                memo_max_lengths[i][j] = (short) (flag * (Math.min(Math.min(max_square_in_the_point(i, j - 1), max_square_in_the_point(i - 1, j)), max_square_in_the_point(i - 1, j - 1)) + 1));
                if (memo_max_lengths[i][j] > max_square_size) max_square_size = memo_max_lengths[i][j];
            }

            //System.out.println("Memo_max_lengths[i][j] = " + memo_max_lengths[i][j]);

        }

        return memo_max_lengths[i][j];
    }

    public static void print_2D_array (char[][] array) { // auxiliary method for 2D array printing

        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static char[][] random_bin_matrix (int i_length, int j_length) { // auxiliary method for fulfilling a matrix randomly with 1 and 0

        char[][] matrix = new char[i_length][j_length];

        for (int i = 0; i < i_length; i ++) {
            for (int j = 0; j < j_length; j ++) {
                matrix[i][j] = (int) (9 * Math.random()) != 0 ? '1' : '0';
            }

        }
        return matrix;

    }

    public static void memo_minus_fulfilling () { // memo-matrix fulfilling with -1
        int i_length = memo_max_lengths.length;
        int j_length = memo_max_lengths[0].length;

        for (int i = 0; i < i_length; i ++) {
            for (int j = 0; j < j_length; j ++) {
                memo_max_lengths[i][j] = -1;
            }
        }

    }


}
