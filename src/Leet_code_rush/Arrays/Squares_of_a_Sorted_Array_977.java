package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Squares_of_a_Sorted_Array_977 { /** accepted **/

    public static void main(String[] args) {

        int[] nums = new int[] {1}; //{-10000,-9999,-7,-5,0,0,10000};  //{-5, -4, -4, -4, -3, -2, 0}; //{-1}; //{-7,-3,2,3,11}; //{-4,-1,0,3,10}; //{-10, -6, -1, 2, 3, 3, 6, 8, 88};
        //nums = new int[] {0, 1, 2, 3};
        //nums = new int[] {-7, -2, -1};
        //nums = new int[] {0};

        array_print(sortedSquares(nums));

    }

    public static int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int left_pointer = 0;
        int right_pointer = n - 1;

        int squared_element;

        for (int i = 0; i < n; i ++) {

            if (Math.abs(nums[left_pointer]) > Math.abs(nums[right_pointer])) {
                squared_element = nums[left_pointer] * nums[left_pointer];
                left_pointer++;
            } else {
                squared_element = nums[right_pointer] * nums[right_pointer];
                right_pointer--;
            }

            result [n - 1 - i] = squared_element;

        }

        return result;

    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
