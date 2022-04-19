package Leet_code_rush.Others;

public class Spiral_Matrix_2_59 {

    public static void main(String[] args) { /** accepted **/

        int[][] array = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        print_2D_array(array);

        System.out.println(array[1][2]);

        array = generateMatrix(9);

        //System.out.println(array[1][3]);

        print_2D_array(array);

    }

    public static int[][] generateMatrix(int n) {

        int[][] m = new int[n][n];

        if (n == 1) {
            m[0][0] = 1;
            return m;
        }

        if (n == 2) {
            m = new int[][] {{1, 2}, {4, 3}};
            return m;
        }

        int i = 0, j = 0, k = 1;

        boolean flag = false;

        int right_steps = 0, down_steps = 0, left_steps = 0, up_steps = 0;

        while (true) {

            if (i + 1 == n - 1 - down_steps) flag = true;

            while (i < n - 1 - down_steps) {
                m[j][i] = k;
                i++;
                k++;
            }

            if (flag) {
                m[j][i] = k;
                break;
            }

            right_steps++;

            while (j < n - 1 - left_steps) {
                m[j][i] = k;
                j++;
                k++;
            }

            down_steps++;

            if (i - 1 == up_steps) flag = true;

            while (i > up_steps) {
                m[j][i] = k;
                i--;
                k++;
            }

            if (flag) {
                m[j][i] = k;
                break;
            }

            left_steps++;

            while (j > right_steps) {
                m[j][i] = k;
                j--;
                k++;
            }

            up_steps++;

        }

        return m;

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
