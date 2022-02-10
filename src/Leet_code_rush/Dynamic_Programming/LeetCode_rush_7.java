package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_7 {

    static int[] coins; //coins array
    static int amount;

    static int[][] memo_coins_minimal_chains;


    public static void main(String[] args) {

        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422}; //{1}; //{2}; //{1, 2, 5};
        int amount = 9864; //0; //3; //11;

        long start = System.nanoTime();

        System.out.println(coinChange(coins, amount));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000); // 366 989 98
        System.out.println();

    }

    /**
     *
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money
     *
     * @param coins - coins array
     * @param amount - target value if money
     * @return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1
     *
     * You may assume that you have an infinite number of each kind of coin
     *
     */

    public static int coinChange(int[] coins, int amount) {

        LeetCode_rush_7.coins = coins;
        LeetCode_rush_7.amount = amount;
        memo_coins_minimal_chains = new int[LeetCode_rush_7.coins.length][amount + 1];
        memo_fulfilling();

        System.out.println("coins.length = " + LeetCode_rush_7.coins.length + " amount = " + LeetCode_rush_7.amount);

        LeetCode_rush.array_print(coins);

        return min_coins_combination(LeetCode_rush_7.coins.length - 1, LeetCode_rush_7.amount);

    }

    public static int min_coins_combination (int coin_index, int remainder) {

        if (remainder == 0) return 0;

        if (coin_index == 0) {

            if (memo_coins_minimal_chains[0][remainder] == -1) {

                if (remainder % coins[0] == 0) memo_coins_minimal_chains[0][remainder] = remainder / coins[0];
                else memo_coins_minimal_chains[0][remainder] = -1;

            }

            return memo_coins_minimal_chains[0][remainder];

        }

        int current_remainder = remainder;
        int current_coins_counter = 0;
        int min_coins_chain = Integer.MAX_VALUE;

        int temp_val;

        if (memo_coins_minimal_chains[coin_index][remainder] == -1) {

        while (remainder - current_coins_counter * coins[coin_index] >= 0) {

            temp_val = min_coins_combination(coin_index - 1, current_remainder);

            if (temp_val != -1) min_coins_chain = Math.min(min_coins_chain, temp_val + current_coins_counter);

            current_coins_counter++;

            current_remainder -= coins[coin_index];

        }

        if (min_coins_chain != Integer.MAX_VALUE) memo_coins_minimal_chains[coin_index][remainder] = min_coins_chain;
        else memo_coins_minimal_chains[coin_index][remainder] = -1;

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
