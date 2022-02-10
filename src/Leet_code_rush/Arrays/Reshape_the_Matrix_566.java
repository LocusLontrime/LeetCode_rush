package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Reshape_the_Matrix_566 {

    public static void main(String[] args) { /** accepted (speed: 0ms, ultra-fast, beats 100% java submissions) **/

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20}};

        //matrix = new int[][] {{1}};

        matrix = matrixReshape(matrix, 2, 10);

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int[][] new_mat_reshaped = new int[r][c];
        int n = mat[0].length;

        if (mat.length * mat[0].length != r * c) return mat;

        for (int i = 0; i < r * c; i ++) new_mat_reshaped[i / c][i % c] = mat[i / n][i % n];

        return new_mat_reshaped;
    }
}
