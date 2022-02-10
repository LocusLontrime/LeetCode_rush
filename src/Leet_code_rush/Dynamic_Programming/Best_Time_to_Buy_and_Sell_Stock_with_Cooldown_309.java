package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

/** accepted (speed: very slow) **/

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {

    static int[] array;

    static int[] memo_table;

    public static void main(String[] args) {

        int[] array = new int[] {1,2,4}; //{1,2,3,0,2}; //{7,6,4,3,1}; //{1,2,3,4,5}; //{7,1,5,3,6,4};

        System.out.println(maxProfit(array));

    }

    public static int maxProfit(int[] prices) { // we are adding every possible 1-day profit to the max profit amount

        array = prices;

        memo_table = new int[array.length];
        Arrays.fill(memo_table, -1);

        return recursive_seeker(0);

    }

    public static int recursive_seeker (int i) {

        if (i >= array.length - 1) return 0;

        if (memo_table[i] == -1) {

        int max_profit_do_nothing = recursive_seeker(i + 1);

        int max_profit = Integer.MIN_VALUE;

        for (int j = i + 1; j < array.length; j ++) {

            max_profit = Math.max(max_profit, recursive_seeker(j + 2) + array[j] - array[i]);

        }

        memo_table[i] = Math.max(max_profit_do_nothing, max_profit);

        }

        return memo_table[i];

    }



}
