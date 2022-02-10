package Leet_code_rush.Arrays;

public class Move_Zeroes_283 { /** accepted **/

    public static void main(String[] args) {

        int[] array = new int[]{0,1,0,3,12};

        moveZeroes(array);

        array_print(array);

    }

    public static void moveZeroes(int[] nums) {

        int non_zeroes_counter = 0;
        int temp;

        for (int i = 0; i < nums.length; i ++) {

            if (nums[i] != 0) {
                if (i != non_zeroes_counter) nums[non_zeroes_counter] = nums[i];
                non_zeroes_counter++;
            }

        }

        for (int i = non_zeroes_counter; i < nums.length; i ++) {
            nums[i] = 0;
        }

    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }


}
