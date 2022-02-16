package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class Minimum_Cost_to_Cut_a_Stick_1547 {

    public static int[] allCuts;

    public static int[][] memoTable;

    public static void main(String[] args) {

        int n = 9; //7;
        int[] cuts = new int[] {5,6,1,4,2}; // {1, 3, 4, 5}; // {1, 3, 4, 5, 7, 12, 25, 98};

        System.out.println(minCost(n, cuts));

        int binL = Arrays.binarySearch(cuts, -100);
        int binR = Arrays.binarySearch(cuts, 2);

        System.out.println("binL = " + (binL >= 0 ? binL : -binL - 1) + " binR = " + (binR >= 0 ? binR : -binR - 2));
    }

    public static int minCost(int n, int[] cuts) {

        allCuts = cuts; // just for convenience and shortening of rec method signature
        Arrays.sort(allCuts); // sorting of array to implement binary search in order to achieve better algo performance

        memoTable = new int[n + 1][n + 1]; // memoization

        return recursiveSeeker(0, n); // here we start recursion
    }

    public static int recursiveSeeker (int i, int j) {

        if (j - i <= 1) return 0;

        int minCutsCost = Integer.MAX_VALUE;

        int binL = Arrays.binarySearch(allCuts, i);
        int binR = Arrays.binarySearch(allCuts, j);

        binL = binL >= 0 ? binL : -binL - 1;
        binR = binR >= 0 ? binR : -binR - 2;

        if (binL > binR) return 0;

        int counter = 0;

        for (int k = binL; k <= binR; k++) {

            if (i != allCuts[k] && j != allCuts[k]) {
                counter++;
                minCutsCost = Math.min(minCutsCost, recursiveSeeker(i , allCuts[k]) +
                        recursiveSeeker(allCuts[k], j));

            }

        }

        minCutsCost += (j - i);

        if (counter > 0) return minCutsCost;
        else return 0;
    }
}
