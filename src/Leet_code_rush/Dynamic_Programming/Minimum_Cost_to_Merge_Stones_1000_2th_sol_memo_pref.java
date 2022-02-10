package Leet_code_rush.Dynamic_Programming;
import java.util.Arrays;

public class Minimum_Cost_to_Merge_Stones_1000_2th_sol_memo_pref {

    static int[][] memo_table; // memoization of states
    static int[] stones_sums; // prefix sum array

    public static void main(String[] args) { /** accepted (speed: 0ms, incredibly fast, beats 100 percents of java submissions) **/

        int[] array = new int[]{3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98, 3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32,
                98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98, 3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98, 3, 1, 4, 3,
                6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7,
                98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98,
                99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6,
                98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98,
                87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99,
                100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98,
                66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98, 3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87,
                8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100,
                7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66,
                6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8,
                98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7,
                87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6,
                67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3,
                1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98,3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6,
                7, 8, 7, 98, 87, 8, 98, 3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98};

        array = new int[] {1, 3, 6, 7, 1, 2, 9}; //{1, 11, 16, 18, 5, 14, 60, 14, 36, 6, 6, 2, 9, 5, 26, 4, 7, 15, 10, 19, 9, 1, 2, 3, 19, 98}; //{3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 64, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98, 3, 1, 4, 3, 6};
        int k = 3;

        System.out.println("Stones_length = " + array.length);

        long finish1 = System.nanoTime();

        System.out.println("Min cost = " + mergeStones(array, k));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec"); // calculating the runtime of the program
        System.out.println();

        System.out.println("Final merging cost = " + stones_sums[array.length]);

        for (int[] arr : memo_table) { // printing the memo_table to realize how to build a bottom-up algo...
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int mergeStones(int[] stones, int k) {

        int stones_row_length = stones.length;

        if ((stones_row_length - 1) % (k - 1) != 0) return -1; // cases when there is no way to merge all the stone heaps given into a big one

        stones_sums = new int[stones_row_length + 1];
        memo_table = new int[stones_row_length][stones_row_length];

        for (int [] arr : memo_table) {
            Arrays.fill(arr, -1); // just for optimal visualisation
        }

        for (int i = 1; i < stones_row_length + 1; i ++) { // prefix sum array "stones_sums" fulfilling
            stones_sums[i] = stones_sums[i - 1] + stones[i - 1];
        }

        return recursive_seeker(0, stones_row_length - 1, k); // run the recursive algo
    }


    public static int recursive_seeker (int left_border, int right_border, int k) { // searching for the min cost way to merge all the stones

        if (memo_table[left_border][right_border] > 0) return memo_table[left_border][right_border]; // we are using here the min cost values that
        // have been previously calculated

        if (right_border - left_border < k - 1) { // these are the piles remained, they will be merged after calculating costs of all cases with stone piles
            // row length >= k, in other words: finally we will merge all the piles remained in one act and pay the cost that is being evaluated
            // after the recurrent relation below

            memo_table[left_border][right_border] = 0; // memo (but it is unnecessary)
            return 0; // ???

        }

        if (right_border - left_border == k - 1) { // the group of stone piles can be merged into a big one, we pay the cost that equals the quantity of stones
            // in these k piles

            memo_table[left_border][right_border] = stones_sums[right_border + 1] - stones_sums[left_border]; // memo, we are using prefix sum array here
            return memo_table[left_border][right_border];

        }

        int min_cost = Integer.MAX_VALUE; // min cost initially equals to the max Integer value, it is a convenient way to minimize it afterwards

        for (int i = left_border ; i + 1 <= right_border; i += (k - 1)) {

            min_cost = Math.min(min_cost, recursive_seeker(left_border, i, k) + recursive_seeker(i + 1, right_border, k));
            // recurrent relation: the cost of merging stones, located in a long row equals to the sum of two costs of merging stones
            // located in two adjacent rows which a long one consists of PLUS a final cost of merging all the stones of a long row into the one final pile
            // we are evaluating this cost in the condition below:
        }

        if ((right_border - left_border) % (k - 1) == 0) { // as this piles of stones can be finally merged into a one pile (condition checks it)
            // we must pay the following cost:

            min_cost += (stones_sums[right_border + 1] - stones_sums[left_border]); // we are using prefix sum array here

        }

        memo_table[left_border][right_border] = min_cost; // memo

        return min_cost; // return the minimal value
    }
}
