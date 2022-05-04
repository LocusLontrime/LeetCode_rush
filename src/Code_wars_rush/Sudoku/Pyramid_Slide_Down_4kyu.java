package Code_wars_rush.Sudoku;

import java.util.Arrays;
import java.util.List;

public class Pyramid_Slide_Down_4kyu {

    static int[][] numbers;
    static int[][] memoTable;

    public static void main(String[] args) {

        int[][] test = new int[][]{{75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };

        System.out.println(longestSlideDown(test));
    }

    public static int longestSlideDown(int[][] pyramid) { /** accepted (speed: 1ms, very fast) but requires O(rows^2) time **/

        numbers = pyramid;
        int triangleRows = pyramid.length;
        memoTable = new int[triangleRows][triangleRows];

        for (int i = 0; i < triangleRows; i++) Arrays.fill(memoTable[i], Integer.MIN_VALUE);

        int minPathSum = Integer.MIN_VALUE;

        for (int i = 0; i < triangleRows; i++) {
            minPathSum = Math.max(minPathSum, recursiveSeeker(triangleRows - 1, i));
        }

        return minPathSum;
    }

    public static int recursiveSeeker (int row, int elementIndex) {

        if (row == 0) return numbers[0][0];

        if (memoTable[row][elementIndex] == Integer.MIN_VALUE) {

            int maxPathSum = Integer.MIN_VALUE;

            if (elementIndex != row && elementIndex != 0) maxPathSum = Math.max(maxPathSum,
                    Math.max(recursiveSeeker(row - 1, elementIndex),
                            recursiveSeeker(row - 1, elementIndex - 1)) +
                            numbers[row][elementIndex]);

            else if (elementIndex == 0) maxPathSum = Math.max(maxPathSum,
                    recursiveSeeker(row - 1, elementIndex) + numbers[row][elementIndex]);
            else maxPathSum = Math.max(maxPathSum, recursiveSeeker(row - 1, elementIndex - 1) +
                        numbers[row][elementIndex]);

            memoTable[row][elementIndex] = maxPathSum;
        }

        return memoTable[row][elementIndex];
    }
}
