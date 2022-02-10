package Leet_code_rush.Arrays;

public class Max_Consecutive_Ones_II_1004 { /** accepted (speed: 2ms, too fast, faster than 94% ) **/

    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 0}; // {0, 1}; //{1, 0}; //{1, 1, 0, 1}; //{1, 0}; //{0, 1}; //{1, 0};//{1, 1, 0, 0, 0}; //{0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1}; //{0, 0, 1, 1}; // //{1, 1, 1}; //

        System.out.println(findMaxConsecutiveOnes(array));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        if (nums.length == 1) return 1;

        int ones_counter = 0, memo_ones_counter = 0, max = 0;
        int consecutive_nulls_counter = 0;

        int i = 0;

        while (i < nums.length) {

            while (i < nums.length && nums[i] == 0) {
                i++;
                consecutive_nulls_counter++;
            }

            if (consecutive_nulls_counter == nums.length) return 1;

            while (i < nums.length && nums[i] == 1) {
                i++;
                ones_counter++;
            }

            if (consecutive_nulls_counter == 1 && ones_counter != 0) if (ones_counter + memo_ones_counter + 1 > max) max = ones_counter + memo_ones_counter + 1;

            if (consecutive_nulls_counter == 1 && i == nums.length && ones_counter == 0) if (memo_ones_counter + 1 > max) max = memo_ones_counter + 1;

            if (consecutive_nulls_counter > 1) if (Math.max(ones_counter, memo_ones_counter) + 1 > max) max = Math.max(ones_counter, memo_ones_counter) + 1;

            if (consecutive_nulls_counter == 0) if (ones_counter > max) max = ones_counter;

            memo_ones_counter = ones_counter;
            ones_counter = 0;
            consecutive_nulls_counter = 0;

            if (i == nums.length) break;

        }

        return max;

    }

}
