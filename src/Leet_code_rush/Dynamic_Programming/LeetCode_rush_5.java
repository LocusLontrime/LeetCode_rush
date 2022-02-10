package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_5 { /** bottom-up accepted **/

    static int cycling_counter = 0, max_square_size = 0;
    static char[][] matrix;
    static short[][] memo_max_lengths; // 2D - array of maximal (1 - filled) squares whose right bottom angle is situated in (i,j) - coordinates of the matrix given

    public static void main(String[] args) {

        char [][] matrix = {{'0', '1'}, {'1', '0'}}; //{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}; //{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        matrix = LeetCode_rush_4.random_bin_matrix(3000, 3000);

        //print_2D_array(matrix);

        long start = System.nanoTime();

        System.out.println("Max square area = " + maximalSquare(matrix));
        System.out.println("Cycling counter = " + cycling_counter);

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);

    }

    public static int maximalSquare(char[][] matrix) { // bottom-up realization of LeetCode_rush_4 task

        memo_max_lengths = new short[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                cycling_counter++;

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) memo_max_lengths[i][j] = 1;
                    else memo_max_lengths[i][j] = (short) (Math.min(Math.min(memo_max_lengths[i][j - 1], memo_max_lengths[i - 1][j]), memo_max_lengths[i - 1][j - 1]) + 1);
                }

                if (memo_max_lengths[i][j] > max_square_size) max_square_size = memo_max_lengths[i][j];

            }
        }

        return max_square_size * max_square_size;

    }

}
