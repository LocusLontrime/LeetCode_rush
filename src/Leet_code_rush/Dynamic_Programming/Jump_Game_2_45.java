package Leet_code_rush.Dynamic_Programming;
import java.util.Arrays;

public class Jump_Game_2_45 { /** accepted **/ //it needs to optimize the solution

    static int[] nums;

    static int[] memo_table;

    public static void main(String[] args) {

        int[] nums = new int[] {2,3,1,1,4}; //{2,3,0,1,4}; //{5,9,3,2,1,0,2,3,3,1,0,0}; //{2,3,0,1,4}; //{2,3,1,1,4}; //{2,3,1,1,4,4,4,6,1,8,9};

        System.out.println(jump(nums));
    }

    /**
     *
     * @param nums - given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position
     * @return true if you can reach the last index, or false otherwise
     */

    public static int jump(int[] nums) {

        Jump_Game_2_45.nums = nums;
        memo_table = new int[nums.length];
        memo_fulfilling();

        return recursive_seeker(0);
    }

    public static int recursive_seeker (int i) {

        if (i == nums.length - 1) return 0;

        if (memo_table[i] == -1) {

            int min_value = Integer.MAX_VALUE / 2; // 0 - false, 1 - true

            if (i + nums[i] >= nums.length - 1) return 1;

            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {

                if (nums[i + j] != 0) min_value = Math.min(min_value, recursive_seeker(i + j) + 1);

                //if (i + j == nums.length - 1) return 1 + recursive_seeker(nums.length - 1);

            }

            memo_table[i] = min_value;

        }

        return memo_table[i];

    }

    public static void memo_fulfilling () {
        Arrays.fill(memo_table, -1);
    }

}
