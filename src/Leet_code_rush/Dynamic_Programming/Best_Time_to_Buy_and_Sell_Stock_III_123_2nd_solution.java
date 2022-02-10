package Leet_code_rush.Dynamic_Programming;

public class Best_Time_to_Buy_and_Sell_Stock_III_123_2nd_solution { /** accepted (speed: too fast) **/

    static int[] array;
    static int max_profit;
    static int[][][] memo_table;

    public static void main(String[] args) {

        int[] prices = new int[]{3,3,5,0,0,3,1,4};

        System.out.println("Max profit = " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int first_min_cost = Integer.MAX_VALUE;
        int second_min_cost = Integer.MAX_VALUE;

        int first_max_profit = 0;
        int second_max_profit = 0;

        for (int i = 0; i < prices.length; i ++) {

            first_min_cost = Math.min(first_min_cost, prices[i]);
            first_max_profit = Math.max(first_max_profit, prices[i] - first_min_cost);

            second_min_cost = Math.min(second_min_cost, prices[i] - first_max_profit);
            second_max_profit = Math.max(second_max_profit, prices[i] - second_min_cost);

        }
        return second_max_profit;
    }
}
