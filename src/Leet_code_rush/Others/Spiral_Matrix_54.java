package Leet_code_rush.Others;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {

    public static void main(String[] args) { /** accepted (speed: fast) **/

        int[][] array = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        array = new int[][] {{1, 2}, {3, 4}};
        array = new int[][] {{1}, {2}, {3}};
        //array = new int[][] {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};

        print_2D_array(array);

        System.out.println(spiralOrder(array));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        int height = matrix.length;
        int width = matrix[0].length;

        int i = 0, j = 0;

        int right_steps = 0, down_steps = 0, left_steps = 0, up_steps = 0;

        while (true) {

            while (i < width - 1 - down_steps) {
                list.add(matrix[j][i]);
                i++;
            }

            if (i + 1 == width - down_steps && right_steps + left_steps + 1 == height) {
                list.add(matrix[j][i]);
                break;
            }

            right_steps++;

            while (j < height - 1 - left_steps) {
                list.add(matrix[j][i]);
                j++;
            }

            if (j + 1 == height - left_steps && up_steps + down_steps + 1 == width) {
                list.add(matrix[j][i]);
                break;
            }

            down_steps++;

            while (i > up_steps) {
                list.add(matrix[j][i]);
                i--;
            }

            if (i == up_steps && right_steps + left_steps + 1 == height) {
                list.add(matrix[j][i]);
                break;
            }

            left_steps++;

            while (j > right_steps) {
                list.add(matrix[j][i]);
                j--;
            }

            if (j == right_steps && up_steps + down_steps + 1 == width) {
                list.add(matrix[j][i]);
                break;
            }
            up_steps++;

        }

        return list;

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
