package Leet_code_rush.Dynamic_Programming;

public class Best_Time_to_Buy_and_Sell_Stock_IV_188 { /** accepted (speed: not so fast) **/

    static int[] array;

    static int max_profit;

    static int[][][] memo_table;

    public static void main(String[] args) {

        int[] prices = new int[] {3, 2, 6, 5, 0, 3, 0, 0, 98, 989, 9, 9, 98, 99, 7, 77, 1, 0, 1, 0, 9, 7, 3, 98, 11, 11, 6, 7, 0, 989, 77, 98, 34, 0, 1, 979, 575, 0, 0, 11, 989, 34, 33, 12, 154, 333, 111, 0, 0, 1, 0, 1, 989};
        int k = 7;

        long start = System.nanoTime();

        System.out.println("Max profit = " + maxProfit(k, prices));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);

    }

    public static int maxProfit(int k, int[] prices) {

        array = prices;

        memo_table = new int[array.length][k + 1][2];

        return recursive_seeker(0, k, 1);
    }

    /**
     *
     * @param i - day's number
     * @param j - transactions remained
     * @param state - "1" if we are able to buy and "0" when we are able to sell
     * @return
     */

    public static int recursive_seeker (int i, int j, int state) { // here we are finding the max possible profit

        if (i == array.length) return 0; // base case when the iterator i exceeds the max index of prices array

        if (j == 0) return 0; // base case when we run out of all the transactions available

        if (memo_table[i][j][state] == 0) {

            if (state == 1) {
                max_profit = recursive_seeker(i + 1, j, 0) - array[i]; // if we are able only to buy a stock - we are buying it and lose some profit
            } else {
                max_profit = recursive_seeker(i + 1, j - 1, 1) + array[i]; // if we are now able to sell a stock - we are selling it and increase ou profit!
            }

            max_profit = Math.max(max_profit, recursive_seeker(i + 1, j, state)); // state of doing nothing - we are not selling or buying anything for now

            memo_table[i][j][state] = max_profit; // we are writing current max profit into the memo_table

        }

        return memo_table[i][j][state];

    }

    public static void memo_fulfilling () { // it turned to be unnecessary, increases the algo time strongly

        for (int i  = 0; i < memo_table.length; i ++) {
            for (int j = 0; j < memo_table[0].length; j ++) {
                for (int k = 0; k < memo_table[0][0].length; k ++) {
                    memo_table[i][j][k] = -1;
                }
            }
        }

    }

}
