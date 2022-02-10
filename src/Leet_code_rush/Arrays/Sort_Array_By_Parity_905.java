package Leet_code_rush.Arrays;

public class Sort_Array_By_Parity_905 {

    public static void main(String[] args) { /** accepted **/

        int[] array = new int[] {2}; //{3,1,2,2,2,6,7,3,2,4}; //{0, 2}; //;

        sortArrayByParity(array);

        Move_Zeroes_283.array_print(array);

    }

    public static int[] sortArrayByParity(int[] nums) {

        int left_pointer = 0;
        int right_pointer = nums.length - 1;
        int temp;

        while (right_pointer > left_pointer) {

            while (nums[right_pointer] % 2 == 1 && right_pointer > left_pointer) right_pointer--;
            while (nums[left_pointer] % 2 == 0 && right_pointer > left_pointer) left_pointer++;

            temp = nums[right_pointer];
            nums[right_pointer] = nums[left_pointer];
            nums[left_pointer] = temp;

            right_pointer--;
            left_pointer++;

        }

        return nums;
    }

}
