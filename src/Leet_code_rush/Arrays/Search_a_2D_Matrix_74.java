package Leet_code_rush.Arrays;

public class Search_a_2D_Matrix_74 {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,7,8,9},{10,11,16,17,19,20},{23,26,30,34,60,98},{100, 101, 234, 675, 786, 989}};

        matrix = new int[][] {{1, 11, 111}};

        matrix = new int[][]{{1, 1}};

        System.out.println(searchMatrix(matrix, 1));

    }

    public static boolean searchMatrix(int[][] matrix, int target) { /** accepted (speed: 10ms, average) **/

        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;

        int[] arrayForBinSearch = new int[matrix.length];

        for(int i = 0; i < matrix.length; i ++) {
            arrayForBinSearch[i] = matrix[i][0];
        }

//System.out.println(java.util.Arrays.toString(arrayForBinSearch));

        int rowNumber = java.util.Arrays.binarySearch(arrayForBinSearch, 0, matrix.length, target);

        if(rowNumber >= 0) return true;
        else rowNumber = rowNumber == -1 ? 0 : -rowNumber - 2;

        System.out.println("RowNumber = " + rowNumber);

        int columnNumber = java.util.Arrays.binarySearch(matrix[rowNumber], 0, matrix[0].length, target);

        System.out.println("ColumnNumber = " + columnNumber);

        return columnNumber >= 0;
    }

}
