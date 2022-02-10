package Leet_code_rush.Arrays;

public class Max_Consecutive_Ones_458 { /** accepted **/

    public static void main(String[] args) {

        int[] nums = new int[] {0,1}; //{1, 0}; //{98}; //{1,0,1,1,0,1}; //{1,1,0,1,1,1};

        System.out.println(findMaxConsecutiveOnes(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int result = 0;
        int max_sequence_counter = 0;
        int i = 0;

        while (i < nums.length) {

            while (nums[i] != 1) {
                if (i == nums.length - 1) break;
                i++;
            }

            while (nums[i] == 1) {
                max_sequence_counter++;
                if (i == nums.length - 1) break;
                i++;
            }

            if (result < max_sequence_counter) result = max_sequence_counter;
            max_sequence_counter = 0;

            if (i == nums.length - 1) break;

        }

        return result;
    }

}
