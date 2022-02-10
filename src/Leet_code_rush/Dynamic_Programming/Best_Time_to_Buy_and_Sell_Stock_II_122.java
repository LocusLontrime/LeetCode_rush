package Leet_code_rush.Dynamic_Programming; /** accepted (speed: average) **/

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

    public static void main(String[] args) {

        int[] array = new int[]{7,6,4,3,1}; //{1,2,3,4,5}; //{7,1,5,3,6,4};

        System.out.println(maxProfit(array));

    }

    public static int maxProfit(int[] prices) { // we are adding every possible 1-day profit to the max profit amount

        int max_profit = 0;

        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i] < prices[i + 1]) max_profit += prices[i + 1] - prices[i]; // if prices[i] < prices[i + 1] then we add the subtraction to the max profit
        }

        return max_profit;

    }

}
