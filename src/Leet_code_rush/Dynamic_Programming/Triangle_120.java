package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle_120 {

    static List<List<Integer>> numbers;

    static int[][] memoTable;

    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = Collections.singletonList(2);
        List<Integer> list2 = Arrays.asList(3,4);
        List<Integer> list3 = Arrays.asList(6,5,7);
        List<Integer> list4 = Arrays.asList(4,1,8,3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(minimumTotal(lists));
    }

    public static int minimumTotal(List<List<Integer>> triangle) { /** accepted (speed: 1ms, very fast) but requires O(rows^2) time **/

        numbers = triangle;
        int triangleRows = triangle.size();
        memoTable = new int[triangleRows][triangleRows];

        for (int i = 0; i < triangleRows; i++) Arrays.fill(memoTable[i], Integer.MAX_VALUE);

        int minPathSum = Integer.MAX_VALUE;

        for (int i = 0; i < triangleRows; i++) {

            minPathSum = Math.min(minPathSum, recursiveSeeker(triangleRows - 1, i));

        }

        return minPathSum;
    }

    public static int recursiveSeeker (int row, int elementIndex) {

        if (row == 0) return numbers.get(0).get(0);

        if (memoTable[row][elementIndex] == Integer.MAX_VALUE) {

            int minPathSum = Integer.MAX_VALUE;

            if (elementIndex != row && elementIndex != 0) minPathSum = Math.min(minPathSum,
                    Math.min(recursiveSeeker(row - 1, elementIndex),
                            recursiveSeeker(row - 1, elementIndex - 1)) +
                            numbers.get(row).get(elementIndex));

            else if (elementIndex == 0) minPathSum = Math.min(minPathSum,
                    recursiveSeeker(row - 1, elementIndex) + numbers.get(row).get(elementIndex));
            else minPathSum = Math.min(minPathSum, recursiveSeeker(row - 1, elementIndex - 1) +
                        numbers.get(row).get(elementIndex));

            memoTable[row][elementIndex] = minPathSum;

        }

        return memoTable[row][elementIndex];

    }

}
