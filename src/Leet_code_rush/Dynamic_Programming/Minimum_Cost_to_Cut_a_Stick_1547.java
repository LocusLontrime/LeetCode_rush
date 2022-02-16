package Leet_code_rush.Dynamic_Programming;
import javafx.util.Pair;
import java.util.Arrays;
import java.util.HashMap;

public class Minimum_Cost_to_Cut_a_Stick_1547 {
    public static int[] allCuts;

    // public static int[][] memoTable; // dangerous memoization -> memory runtime error for lengthy sticks

    public static HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>(); // better memoization

    public static void main(String[] args) {

        int n = 100; //9; //7;
        int[] cuts = new int[] {1, 2, 3, 5, 7, 12, 25, 34, 36, 43, 73, 65, 63, 34, 78, 98, 97, 99}; //{5,6,1,4,2}; // {1, 3, 4, 5}; // {1, 3, 4, 5, 7, 12, 25, 98};

        long finish1 = System.nanoTime();
        System.out.println("Min cost = " + minCost(n, cuts));
        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

        int binL = Arrays.binarySearch(cuts, -100);
        int binR = Arrays.binarySearch(cuts, 2);

        System.out.println("Does pairs equal each other: " + new Pair<>(98, 989).equals(new Pair<>(98, 989))); // some checking
        System.out.println("binL = " + (binL >= 0 ? binL : -binL - 1) + " binR = " + (binR >= 0 ? binR : -binR - 2));
    }

    public static int minCost(int n, int[] cuts) { /** accepted (speed: 300-1000ms, slow) **/

        allCuts = cuts; // just for convenience and shortening of rec method signature
        Arrays.sort(allCuts); // sorting of array to implement binary search in order to achieve better algo performance

        //memoTable = new int[n + 1][n + 1]; // memoization

        return recursiveSeeker(0, n); // here we start recursion
    }

    public static int recursiveSeeker (int i, int j) {

        if (!map.containsKey(new Pair<>(i, j))) { // check if i and j pair located in map already

            if (j - i <= 1) return 0;

            int minCutsCost = Integer.MAX_VALUE;

            int binL = Arrays.binarySearch(allCuts, i); // binary search for the left border
            int binR = Arrays.binarySearch(allCuts, j); // binary search for the right border

            binL = binL >= 0 ? binL : -binL - 1;
            // translation the return value of Arrays.binSort to convenient value (left border)
            binR = binR >= 0 ? binR : -binR - 2; // (right one)

            if (binL > binR) return 0; // if there are no possible cuts between indexes i and j

            int counter = 0; // counter for checking if there is any possible cuts besides boundary ones

            for (int k = binL; k <= binR; k++) {

                if (i != allCuts[k] && j != allCuts[k]) { // the main recurrent relation
                    counter++;
                    minCutsCost = Math.min(minCutsCost, recursiveSeeker(i , allCuts[k]) +
                            recursiveSeeker(allCuts[k], j));

                }

            }

            if (counter == 0) minCutsCost = 0;
            else minCutsCost += (j - i); // cost of cutting a stick remained

            map.put(new Pair<>(i, j), minCutsCost); // adding a new value to the map
        }

        return map.get(new Pair<>(i, j)); // returning the value stored in map
    }
}
