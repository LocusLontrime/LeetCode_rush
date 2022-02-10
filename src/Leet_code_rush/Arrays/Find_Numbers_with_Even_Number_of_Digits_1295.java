package Leet_code_rush.Arrays;

public class Find_Numbers_with_Even_Number_of_Digits_1295 { /** accepted **/

    public static void main(String[] args) {

        int[] nums = new int[] {555,901,482,1771}; //{12,345,2,6,7896};

        System.out.println(findNumbers(nums));

    }

    public static int findNumbers(int[] nums) {

        int counter = 0;

        for (int i = 0; i < nums.length; i ++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) counter ++;
        }

        return counter;

    }

}
