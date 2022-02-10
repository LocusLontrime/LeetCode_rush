package Leet_code_rush.Dynamic_Programming;

public class Leet_code_min_climbing_stairs { /** accepted **/

    public static void main(String[] args) {

        Leet_code_min_climbing_stairs l = new Leet_code_min_climbing_stairs();

        int[] coins = new int[] {1,100,1,1,1,100,1,1,100,1}; //{1, 5, 78, 5, 6, 1, 23, 123, 99, 989, 98};

        System.out.println("Min cost = " + l.minCostClimbingStairs(coins));

    }

    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 1) return cost[0];

        int one_before = 0;
        int two_before = 0;

        int temp_val;

        for (int i = 2; i <= cost.length; i ++) {

            temp_val = Math.min(one_before + cost[i - 1], two_before  + cost[i - 2]);
            two_before = one_before;
            one_before = temp_val;

        }

        return one_before;

    }

}
