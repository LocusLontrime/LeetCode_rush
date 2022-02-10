package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush {

    static int [] array = new int[]{2,2,3,3,3,4}; //{3, 4, 2};//{3, 3, 3, 5, 7, 7, 6, 6, 6, 2, 2, 2}; //{10, 15, 20}; //{2,7,9,3,1}; //{1,2,3,1};

    public static void main(String[] args) {
        System.out.println("Tribonacci 25 = " + tribonacci(36));
        System.out.println("Distinct_ways_quantity = " + stairs_ways(10));

        System.out.println("Max amount = " + rob(array));

        System.out.println("Min amount = " + minCostClimbingStairs(array));

        System.out.println("HashMap of nums is " + deleteAndEarn(array));


    }

    /**
     *
     * @param n - index of Tribonacci number
     * @return Tribonacci number corresponding the index given
     */

    public static int tribonacci(int n) {

        int[] Tribonacci = new int[38];

        Tribonacci[0] = 0;
        Tribonacci[1] = 1;
        Tribonacci[2] = 1;

        for (int i = 3; i <= n; i ++) Tribonacci[i] = Tribonacci[i-1] + Tribonacci[i - 2] + Tribonacci[i - 3];

        return Tribonacci[n];
    }

    /**
     *
     * @param stairs_height - how many steps doest it takes you to reach the top of the staircase
     * @return - in how many distinct ways can you climb to the top if each time you can either climb 1 or 2 steps?
     */

    public static long stairs_ways (int stairs_height ) {

        long[] ways = new long[46];

        ways[0] = 0;
        ways[1] = 1;

        for (int current_step = 2;  current_step <= stairs_height; current_step ++) ways[current_step] = ways[current_step - 1] + ways[current_step - 2];

        return ways[stairs_height];
    }

    /**
     *
     * @param nums - the amount of money of each house; you are a professional robber planning to rob houses along a street, you cannot rob two adjacent houses because of cool signalization system
     * @return the maximum amount of money you can rob tonight without alerting the police
     */

    public static int rob(int[] nums) { /** House Robber - accepted **/

        int[] max_amount = new int[101];

        if (nums.length == 1) return nums[0];

        max_amount[0] = nums[0];
        max_amount[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i ++) max_amount[i] = Math.max(max_amount[i - 1], max_amount[i - 2] + nums[i]);

        return max_amount[nums.length - 1];
    }

    /**
     *
     * @param cost - you are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps
     * @return the minimum cost to reach the top of the floor
     */

    public static int minCostClimbingStairs(int[] cost) { /** accepted **/

        int[] min_amount = new int[1001];

        if (cost.length == 1) return cost[0];

        min_amount[0] = 0;
        min_amount[1] = 0;

        for (int i = 2; i <= cost.length; i ++) min_amount[i] = Math.min(min_amount[i - 1] + cost[i - 1], min_amount[i - 2] + cost[i - 2]);

        return min_amount[cost.length];

    }

    /**
     *
     * @param nums - given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
     * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1
     * @return - the maximum number of points you can earn by applying the above operation some number of times
     */

    public static int deleteAndEarn(int[] nums) { /** accepted, BUT it needs improving!!! **/

        if (nums.length == 1) return nums[0];

        int[] num_quantity = new int[10001]; // from our task conditions
        int[] point_earned = new int[10001];

        for (int num : nums) num_quantity[num] ++;

        point_earned[0] = 0;
        System.out.println("point_earned[0] = " + point_earned[0]);
        point_earned[1] = num_quantity[1];
        System.out.println("point_earned[1] = " + point_earned[1]);

        for (int num = 2; num < num_quantity.length; num ++) {

            if (num_quantity[num] != 0) {
                if (num_quantity[num - 1] != 0) {
                    point_earned[num] = Math.max(point_earned[num - 2] + num * num_quantity[num], point_earned[num - 1]);
                } else {
                    point_earned[num] = point_earned[num - 2] + num * num_quantity[num];
                }
            } else {
                point_earned[num] = point_earned[num - 1];
            }

        }

        return point_earned[10000];
    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
