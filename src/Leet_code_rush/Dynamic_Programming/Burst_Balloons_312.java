package Leet_code_rush.Dynamic_Programming;

public class Burst_Balloons_312 {

    static int[] balloons;

    static int[][] memo_table;

    public static void main(String[] args) {

        int [] array = new int []{3,1,5,8,44,1,8,99,1,7,98,1,1,66,87,1,3,5,6,7,78,7,56,4,56,3,56,12,121,989};
        //array = new int[]{3,1,5,8};
        //array = new int[]{1, 5};

        long finish1 = System.nanoTime();

        System.out.println(maxCoins(array));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

    }

    public static int maxCoins(int[] nums) {

        int n = nums.length;

        balloons = new int[n + 2];
        System.arraycopy(nums, 0, balloons, 1, n);
        memo_table = new int[n + 2][n + 2];

        balloons[0] = 1;
        balloons[n + 1] = 1;

        return recursive_seeker(1, n);

    }

    public static int recursive_seeker (int left_border, int right_border) { /** accepted (speed: 108ms, fast enough, beats 67,64% submissions) **/

        if (left_border > right_border) return 0;

        if (memo_table[left_border][right_border] > 0) return memo_table[left_border][right_border];

        int separator;

        int max_profit = 0;

        int burst_separator_profit;

        for (separator = left_border; separator <= right_border; separator ++) {

            burst_separator_profit = balloons[left_border - 1] * balloons[separator] * balloons[right_border + 1];

            max_profit = Math.max(max_profit, recursive_seeker(left_border, separator - 1) + recursive_seeker(separator + 1, right_border)
                    + burst_separator_profit);

        }

        memo_table[left_border][right_border] = max_profit;

        return max_profit;

    }

}
