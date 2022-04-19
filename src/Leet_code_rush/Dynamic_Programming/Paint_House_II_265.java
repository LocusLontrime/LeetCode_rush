package Leet_code_rush.Dynamic_Programming;

public class Paint_House_II_265 {

    static int[][] costsMatrix;
    static int[][] memoTable;
    static int housesQuantity;
    static int coloursQuantity;

    public static void main(String[] args) {

        System.out.println(minCostII(new int[][] {{1,5,3},{2,9,4}}));

        System.out.println(minCostII(new int[][] {{1,3},{2,4}}));
    }

    public static int minCostIIBottomUp(int[][] costs) { // we need to memorize only min and pre-min values from the previous row to
        // minimize the current cost

        housesQuantity = costs.length;
        coloursQuantity = costs[0].length;

        int min;
        int beforeMin;

        for (int i = 0; i < housesQuantity; i ++) {



        }

        return 989;
    }

    public static int minCostII(int[][] costs) { /** accepted (speed: 3ms, fast) **/

        costsMatrix = costs;

        housesQuantity = costs.length;
        coloursQuantity = costs[0].length;

        memoTable = new int[housesQuantity][coloursQuantity];

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < coloursQuantity; i++) {
            minCost = Math.min(minCost, recursiveSeeker(housesQuantity - 1, i));
        }

        return minCost;
    }

    public static int recursiveSeeker (int i, int colour) {

        if (i == 0) {
            return costsMatrix[i][colour];
        }

        int minCost = Integer.MAX_VALUE;

        if (memoTable[i][colour] == 0) {
            for (int j = 0; j < coloursQuantity; j++) {
                if (j != colour) {
                    minCost = Math.min(minCost, recursiveSeeker(i - 1, j));
                }
            }

            memoTable[i][colour] = minCost + costsMatrix[i][colour];
        }

        return memoTable[i][colour];
    }
}
