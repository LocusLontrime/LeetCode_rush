package Leet_code_rush.Arrays;

public class Max_Consecutive_Ones_III_1004 {

    public static void main(String[] args) {

        int[] binary_array = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        System.out.println(longestOnes(binary_array, k));

    }

    public static int longestOnes(int[] nums, int k) {

        int left_window_border = 0, right_window_border = 0;

        for (right_window_border = 0; right_window_border < nums.length; right_window_border++) {

            if (nums[right_window_border] == 0) k--;

            if (k < 0) {
                k += 1 - nums[left_window_border];
                left_window_border++;
            }

        }

        return right_window_border - left_window_border;

    }

}
