package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_8 { /** accepted on both of (leetcode.com/codwars.com) **/

    static int[] coins; //coins array
    static int amount;

    static long[][] memo_coins_minimal_chains;


    public static void main(String[] args) {

        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422}; //{1}; //{2}; //{1, 2, 5};
        int amount = 9864; //0; //3; //11;

        long start = System.nanoTime(); // 366

        System.out.println(coinChange(coins, amount));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000); //366 98
        System.out.println();
    }

    /**
     *
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money
     *
     * @param coins - coins array
     * @param amount - target value if money
     * @return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0
     *
     * You may assume that you have an infinite number of each kind of coin
     *
     * the answer is guaranteed to fit into a signed 32-bit integer
     *
     */

    public static long coinChange(int[] coins, int amount) {

        LeetCode_rush_8.coins = coins;
        LeetCode_rush_8.amount = amount;
        memo_coins_minimal_chains = new long[LeetCode_rush_8.coins.length][amount + 1];
        memo_fulfilling();

        System.out.println("coins.length = " + LeetCode_rush_8.coins.length + " amount = " + LeetCode_rush_8.amount);

        LeetCode_rush.array_print(coins);

        return coins_combinations_quantity(LeetCode_rush_8.coins.length - 1, LeetCode_rush_8.amount);

    }

    public static long coins_combinations_quantity (int coin_index, int remainder) {

        if (remainder == 0) {
            memo_coins_minimal_chains[coin_index][0] = 1;
            return memo_coins_minimal_chains[coin_index][0];
        }

        if (coin_index == 0) {

            if (memo_coins_minimal_chains[0][remainder] == -1) {

                if (remainder % coins[0] == 0) memo_coins_minimal_chains[0][remainder] = 1;
                else memo_coins_minimal_chains[0][remainder] = 0;

            }

            return memo_coins_minimal_chains[0][remainder];

        }

        int current_remainder = remainder;
        int current_coins_counter = 0;
        long coins_chains_quantity = 0;

        if (memo_coins_minimal_chains[coin_index][remainder] == -1) {

            while (remainder - current_coins_counter * coins[coin_index] >= 0) {

                coins_chains_quantity += coins_combinations_quantity(coin_index - 1, current_remainder);

                current_coins_counter++;

                current_remainder -= coins[coin_index];

            }

            memo_coins_minimal_chains[coin_index][remainder] = coins_chains_quantity;


        }

        return memo_coins_minimal_chains[coin_index][remainder];

    }

    public static void memo_fulfilling () {

        for (int i  = 0; i < memo_coins_minimal_chains.length; i ++) {
            for (int j = 0; j < memo_coins_minimal_chains[0].length; j ++) {
                memo_coins_minimal_chains[i][j] = -1;
            }
        }

    }
}
