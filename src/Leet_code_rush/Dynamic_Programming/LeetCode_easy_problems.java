package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class LeetCode_easy_problems {

    public static void main(String[] args) {

        System.out.println("Fibonacci = " + fib(45));

        System.out.println("Tribonacci = " + trib(36));

        System.out.println("ClimbStairs = " + climbStairs(4));

        int[] array = new int[] {1, 2, 3, 4, 5};

        //System.out.println(Arrays.copyOfRange(array, 1, array.length - 1));
        //System.out.println(Arrays.copyOfRange(array, 0, array.length - 2));

        LeetCode_rush.array_print(Arrays.copyOfRange(array, 1, array.length));
        LeetCode_rush.array_print(Arrays.copyOfRange(array, 0, array.length - 1));

        System.out.println();

        array = new int[] {7, 8}; //{1,2,3,1};

        System.out.println("Max profit = " + rob(array));

    }

    public static int fib (int n) { /** accepted **/

        int one_before = 1;
        int two_before = 0;

        if (n == 0) return two_before;
        if (n == 1) return one_before;

        int temp_val;

        for (int i = 2; i <=n; i ++) {

            temp_val = one_before + two_before;
            two_before = one_before;
            one_before = temp_val;

        }

        return one_before;

    }

    public static int trib (int n) { /** accepted **/

        int one_before = 1;
        int two_before = 1;
        int three_before = 0;

        if (n == 0) return three_before;
        if (n == 1) return two_before;
        if (n == 2) return one_before;

        int temp_val;

        for (int i = 3; i <=n; i ++) {

            temp_val = one_before + two_before + three_before;
            three_before = two_before;
            two_before = one_before;
            one_before = temp_val;

        }

        return one_before;

    }

    public static int climbStairs (int n) { /** accepted **/

        return ways_recursive_seeker(n);

    }

    public static int ways_recursive_seeker (int n) {

        if (n == 0) return 1;
        if (n == 1) return 1;

        return ways_recursive_seeker(n - 1) + ways_recursive_seeker(n - 2);

    }

    public static int rob (int[] nums) { /** House robber 2 - accepted **/

        if (nums.length == 1) return nums[0];

        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);

        return Math.max(rob_recursive_seeker(nums1), rob_recursive_seeker(nums2));

    }

    public static int rob_recursive_seeker (int[] nums) { // House Robber 2

        int[] max_amount = new int[101];

        if (nums.length == 1) return nums[0];

        max_amount[0] = nums[0];
        max_amount[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i ++) max_amount[i] = Math.max(max_amount[i - 1], max_amount[i - 2] + nums[i]);

        return max_amount[nums.length - 1];
    }

}
