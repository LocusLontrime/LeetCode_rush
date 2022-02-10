package Leet_code_rush.Dynamic_Programming;
import java.util.Arrays;

public class Jump_Game_55 { /** accepted **/

    static int[] nums;
    static int[] memo_table;

    public static void main(String[] args) {

        int[] nums = new int[] {989}; //{2,3,1,1,4,4,4,6,1,8,9};

        System.out.println(canJump(nums));
    }

    /**
     *
     * @param nums - given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position
     * @return true if you can reach the last index, or false otherwise
     */

    public static boolean canJump(int[] nums) {

        Jump_Game_55.nums = nums;
        memo_table = new int[nums.length];
        memo_fulfilling();

        return recursive_seeker(0) == 1;
    }

    public static int recursive_seeker (int i) {

        if (i == nums.length - 1) return 1;
        //if (i >= nums.length) return false;

        if (memo_table[i] == -1) {

            int is_there_a_way = 0; // 0 - false, 1 - true

            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {

                if (recursive_seeker(i + j) == 1) {
                    is_there_a_way = 1;
                    break;
                }

            }

            memo_table[i] = is_there_a_way;

        }

        return memo_table[i];

    }

    public static void memo_fulfilling () {
        Arrays.fill(memo_table, -1);
    }

}
