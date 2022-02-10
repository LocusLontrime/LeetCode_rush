package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714_ultra_fast { /** accepted **/

    static int[] array;
    static int transaction_fee;

    static int[][] memo_table;

    public static void main(String[] args) {

        int[] array = new int[]{1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit_first_case(array, fee));
        System.out.println(maxProfit_second_case(array, fee));
        System.out.println(maxProfit_third_case(array, fee));
        System.out.println(maxProfit_fourth_case(array, fee));

        array = new int[] {1,3,7,5,10,3};
        fee = 3;

        System.out.println(maxProfit_first_case(array, fee));
        System.out.println(maxProfit_second_case(array, fee));
        System.out.println(maxProfit_third_case(array, fee));
        System.out.println(maxProfit_fourth_case(array, fee));

        array = new int[] {1, 1, 67, 7, 6, 83, 67, 6, 7, 0, 111, 98, 989, 0, 0, 1, 6, 77, 3, 121, 44, 5, 98, 989};
        fee = 7;

        System.out.println(maxProfit_first_case(array, fee));
        System.out.println(maxProfit_second_case(array, fee));
        System.out.println(maxProfit_third_case(array, fee));
        System.out.println(maxProfit_fourth_case(array, fee));

    }

    /** This is Dynamic Programming at its finest. To get such insights:

     First try using a recursive Top Down approach to get max profit.
     Then try drawing the recursion tree on paper to figure out sub-problems that can be cached in a table.
     Then look at the key/values that the recursion is setting in the table (cache) and under what conditions.
     Next develop a bottoms-up DP solution that builds the table mentioned above directly by watching the recursion tree for which values got calculated first, which got done next.
     After doing this you'll notice that you're wasting space by using a table because to calculate the next state you only need 2 variables.
     When you change the code to use 2 variables, you'll land up with this solution.

     **/

    public static int maxProfit_first_case (int[] prices, int fee) { /** accepted (speed: 44ms, slow) **/

      //here there will be a code

        array = prices;
        transaction_fee = fee;

        memo_table = new int[2][array.length];
        Arrays.fill(memo_table[0], -1);
        Arrays.fill(memo_table[1], -1);

        return recursive_seeker_1(prices.length - 1, 1); // ??? initial rec state ???

    }

    public static int maxProfit_second_case (int[] prices, int fee) { /** accepted (speed: 32ms, slow) **/

        //here there will be a code

        array = prices;
        transaction_fee = fee;

        memo_table = new int[2][array.length];
        Arrays.fill(memo_table[0], -1);
        Arrays.fill(memo_table[1], -1);

        return recursive_seeker_2(prices.length - 1, 1); // ??? initial rec state ???

    }

    public static int maxProfit_third_case (int[] prices, int fee) { /** accepted (speed: 3ms, too fast) **/

        int hold = -prices[0], sold = 0;

        for (int i = 1; i < prices.length; i ++) {

            sold = Math.max(hold + prices[i] - fee, sold);
            hold = Math.max(sold - prices[i], hold);

        }

        return sold;

    }

    public static int maxProfit_fourth_case (int[] prices, int fee) { /** accepted (speed: 7ms, average) **/

        int hold = -prices[0], sold = 0, previous_sold;

        for (int i = 1; i < prices.length; i ++) {

            previous_sold = sold;
            sold = Math.max(hold + prices[i] - fee, sold);
            hold = Math.max(previous_sold - prices[i], hold);

        }

        return sold;

    }

    public static int recursive_seeker_1 (int i, int state) { // state: "0" means that we are able to buy a stock and "1" means that we are able to sell it

        if (i == 0 && state == 1) return 0;
        if (i == 0 && state == 0) return -array[0];

        int max_profit;

        if (memo_table[state][i] == -1) {

            if (state == 0) max_profit = Math.max(recursive_seeker_1(i - 1, 1) - array[i], recursive_seeker_1(i - 1, 0)); // we are able to buy only next day
            else max_profit = Math.max(recursive_seeker_1(i - 1, 0) + array[i] - transaction_fee, recursive_seeker_1(i - 1, 1));

            memo_table[state][i] = max_profit;

        }

        return memo_table[state][i];

    }

    public static int recursive_seeker_2 (int i, int state) { // state: "0" means that we are able to buy a stock and "1" means that we are able to sell it

        if (i == 0 && state == 1) return 0;
        if (i == 0 && state == 0) return -array[0];

        int max_profit;

        if (memo_table[state][i] == -1) {

            if (state == 0) max_profit = Math.max(recursive_seeker_2(i, 1) - array[i], recursive_seeker_2(i - 1, 0)); // we are able to buy even if we have just sold a stock
            else max_profit = Math.max(recursive_seeker_2(i - 1, 0) + array[i] - transaction_fee, recursive_seeker_2(i - 1, 1));

            memo_table[state][i] = max_profit;

        }

        return memo_table[state][i];

    }


}
