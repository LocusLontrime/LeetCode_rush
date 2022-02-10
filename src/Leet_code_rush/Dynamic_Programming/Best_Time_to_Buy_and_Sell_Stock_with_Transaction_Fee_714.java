package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 { /** TOO SLOW **/

    static int[] array;
    static int transaction_fee;

    static int[] memo_table;

    public static void main(String[] args) {

        int[] array = new int[]{1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit(array, fee));

        array = new int[] {1,3,7,5,10,3};
        fee = 3;

        System.out.println(maxProfit(array, fee));

        array = new int[] {1, 1, 67, 7, 6, 83, 67, 6, 7, 0, 111, 98, 989, 0, 0, 1, 6, 77, 3, 121, 44, 5, 98, 989};
        fee = 7;

        System.out.println(maxProfit(array, fee));

    }

    /** This is Dynamic Programming at its finest. To get such insights:

     First try using a recursive Top Down approach to get max profit.
     Then try drawing the recursion tree on paper to figure out sub-problems that can be cached in a table.
     Then look at the key/values that the recursion is setting in the table (cache) and under what conditions.
     Next develop a bottoms-up DP solution that builds the table mentioned above directly by watching the recursion tree for which values got calculated first, which got done next.
     After doing this you'll notice that you're wasting space by using a table because to calculate the next state you only need 2 variables.
     When you change the code to use 2 variables, you'll land up with this solution.

     **/

    public static int maxProfit(int[] prices, int fee) {

        array = prices;
        transaction_fee = fee;

        memo_table = new int[array.length];
        Arrays.fill(memo_table, -1);

        return recursive_seeker(0);

    }

    public static int recursive_seeker (int i) {

        if (i >= array.length - 1) return 0;

        if (memo_table[i] == -1) {

            int max_profit_do_nothing = recursive_seeker(i + 1);

            int max_profit = 0;

            for (int j = i + 1; j < array.length; j ++) {

                max_profit = Math.max(max_profit, recursive_seeker(j + 1) + array[j] - array[i] - transaction_fee);

            }

            memo_table[i] = Math.max(max_profit_do_nothing, max_profit);

        }

        return memo_table[i];

    }

}
