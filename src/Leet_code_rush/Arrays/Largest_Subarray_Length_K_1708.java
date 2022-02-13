package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Largest_Subarray_Length_K_1708 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(largestSubarray(new int[] {1, 2, 98, 5, 6, 15, 19, 13, 23, 66, 700, 8000, 9, 111, 12}, 5)));

    }

    public static int[] largestSubarray(int[] nums, int k) {

        int[] array = new int[k];

        int max = 0;

        int max_index = 0;

        for (int i = 0; i <= nums.length - k; i ++) {

            if (max < nums[i]) {
                max = nums[i];
                max_index = i;
            }

        }

        System.arraycopy(nums, max_index, array, 0, k);

        return array;
    }
}
