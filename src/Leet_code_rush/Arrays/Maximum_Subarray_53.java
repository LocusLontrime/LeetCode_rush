package Leet_code_rush.Arrays;

public class Maximum_Subarray_53 {

    public static void main(String[] args) {

        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(array));

    }

    public static int maxSubArray(int[] nums) { // ideal place to implement Kadane's Algorithm

        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int i = 0; i < nums.length; i ++) {

            current_sum = Math.max(current_sum + nums[i], nums[i]);

            max_sum = Math.max(max_sum, current_sum);

        }

        return max_sum;

    }

}
