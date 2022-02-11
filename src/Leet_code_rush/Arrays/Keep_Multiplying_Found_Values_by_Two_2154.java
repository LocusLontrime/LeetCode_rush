package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Keep_Multiplying_Found_Values_by_Two_2154 { /** accepted (speed: fast) **/

    public static void main(String[] args) {

        System.out.println(findFinalValue(new int[] {65536, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768}, 2));

    }

    public static int findFinalValue(int[] nums, int original) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++) if (nums[i] == original) original *= 2;

        return original;
    }

}
