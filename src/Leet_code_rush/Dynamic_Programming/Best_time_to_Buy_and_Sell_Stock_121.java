package Leet_code_rush.Dynamic_Programming;

public class Best_time_to_Buy_and_Sell_Stock_121 { /** accepted (speed: 1ms, ultra-fast, beats 100% submissions) **/

    public static void main(String[] args) {

        int[] array = new int[] {7,1,5,3,6,4};

        System.out.println(maxProfit(array));

    }

    public static int maxProfit(int prices[]) {

        int min_price = Integer.MAX_VALUE, max_profit = 0;

        for (int i = 0; i < prices.length; i ++) {

            if (prices[i] < min_price) min_price = prices[i];
            else if (prices[i] - min_price > max_profit) {
                max_profit = prices[i] - min_price;
            }

        }

        return max_profit;

    }

}
