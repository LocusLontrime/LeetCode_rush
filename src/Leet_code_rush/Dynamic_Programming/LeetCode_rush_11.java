package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class LeetCode_rush_11 { // Perhaps a bad solution

    static int[] coins; //coins array
    static int amount;

    static int[] memo_coins_minimal_chains;


    public static void main(String[] args) {

        int[] coins = {1, 2, 5, 7, 15, 25, 53, 66, 77}; //{411,412,413,414,415,416,417,418,419,420,421,422}; //{1}; //{2}; //{1, 2, 5};
        int amount = 1614; //9864; //0; //3; //11;

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

    public static int coinChange(int[] coins, int amount) { //return min_coins_combination(coins.length - 1, amount);

        LeetCode_rush_11.coins = coins;
        LeetCode_rush_11.amount = amount;
        memo_coins_minimal_chains = new int [amount + 1];
        memo_fulfilling();

        //System.out.println("coins.length = " + LeetCode_rush_7.coins.length + " amount = " + LeetCode_rush_7.amount);

        LeetCode_rush.array_print(coins);

        return min_coins_combination(amount);

    }

    public static int min_coins_combination (int remainder) { // it needs to remove one dp index - coin_index

        if (remainder == 0) return 0;
        if (remainder < 0) return -1;

        int current_remainder = remainder;
        int min_coins_chain = Integer.MAX_VALUE;

        int temp_val;

        if (memo_coins_minimal_chains [remainder] == -1) {

            for (int i = 0; i < coins.length; i ++) {

                current_remainder = remainder - coins[i];

                temp_val = min_coins_combination(current_remainder);
                if (temp_val != -1) min_coins_chain = Math.min(min_coins_chain, temp_val + 1);

            }

            if (min_coins_chain != Integer.MAX_VALUE) memo_coins_minimal_chains [remainder] = min_coins_chain;
            else memo_coins_minimal_chains[remainder] = -1;

        }

        return memo_coins_minimal_chains[remainder];

    }

    public static void memo_fulfilling () {
        Arrays.fill(memo_coins_minimal_chains, -1);
    }

}
