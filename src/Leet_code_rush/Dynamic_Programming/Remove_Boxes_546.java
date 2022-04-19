package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Remove_Boxes_546 {

    static int[][][] memoTable;

    public static void main(String[] args) {

        int[] array = new int[] {1,3,2,2,2,3,4,3,1};
        // array = new int[] {1,1,1};
        // array = new int[] {1};
        array = new int[] {5,6,7,1,3,1,2,5,7,5,2,2,2,5,5,5,9};

        long finish1 = System.nanoTime();

        System.out.println(removeBoxes(array));

        long finish2 = System.nanoTime();

        System.out.println(removeBoxesFast(array));

        long finish3 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

        System.out.println("t2 = " + (finish3 - finish2) / 1000 + " microsec");


    }

    public static int removeBoxes(int[] boxes) { /** not accepted, brute-force, time limit exceeded **/

        List<Integer> listOfBoxes = Arrays.stream(boxes).boxed().collect(Collectors.toList());

        return recursiveSeeker(listOfBoxes);

    }

    public static int recursiveSeeker (List<Integer> boxes) {

        if (boxes.size() == 0) return 0;

        List<Integer> nextList;

        int index = 0;
        int currentElement = boxes.get(0);
        int currentIndex = 0;

        int maxProfit = 0;

        while (index < boxes.size()) {

            nextList = new ArrayList<>(boxes);

            while (index < boxes.size() && boxes.get(index) == currentElement) {
                nextList.remove(currentIndex);
                index++;
            }

            maxProfit = Math.max(maxProfit, recursiveSeeker(nextList) + (index - currentIndex) * (index - currentIndex));

            if (index < boxes.size()) {
                currentElement = boxes.get(index);
                currentIndex = index;
            } else break;
        }

        return maxProfit;
    }

    // let us find another way of solving this hard one
    public static int removeBoxesFast (int[] boxes) { /** accepted (speed: 33ms, ultra-fast, beats 95,44% of java submissions) **/

        int n = boxes.length; // the length of the boxes array given

        memoTable = new int[n][n][n]; // memo initialization

        return recursiveSeekerFast(boxes, memoTable, 0, n - 1, 0); // start recursive algo

    }

    public static int recursiveSeekerFast (int[] boxes, int[][][]dp, int i, int j, int k) { // i - left border, j - right border and k - number
        // of consecutive boxes with the same colour located in the right tale of interval (i, j) (at first goes (i, j) then k identical elements)

        if (i > j) return 0;

        while (j > i && boxes[j] == boxes[j - 1]) { // iterating through the same consecutive elements in the tail of
            // (i, j) interval to add it to the k ones already found
            k++;
            j--;
        }

        if (dp[i][j][k] != 0) return dp[i][j][k]; // if the value is already calculated then we can return it

        dp[i][j][k] = (k + 1) * (k + 1) + recursiveSeekerFast(boxes, dp, i, j - 1, 0); // adding the scores
        // obtained by deleting k + 1 consecutive boxes of the same colour, it is one possible outcome

        for (int l = i; l < j; l++) { // other possible outcomes, if there is some element in the interval (i, j)
            // which colour equals colour of consecutive tail-elements, then we can possibly increase
            // the general outcome by operating at first on the elements between them and after proceed
            // to the incremented by 1 consecutive boxes

            if (boxes[l] == boxes[j]) dp[i][j][k] = Math.max(dp[i][j][k], recursiveSeekerFast(boxes, dp,l + 1, j - 1, 0) +
                    recursiveSeekerFast(boxes, dp, i, l, k + 1));

        }

        return  dp[i][j][k];
    }

}
