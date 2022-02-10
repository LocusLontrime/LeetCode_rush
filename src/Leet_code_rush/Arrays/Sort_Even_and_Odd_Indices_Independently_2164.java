package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Sort_Even_and_Odd_Indices_Independently_2164 { /** accepted (speed: 2ms, ultra-fast, beats 98,12% java submissions) **/

    public static void main(String[] args) {

        int[] array = new int[]{5, 7, 4, 3, 6, 6, 2, 2, 9}; // { 2,7,4,6,5,3,6,2,9}
        array = new int[] {4,1,2,3};
        array = new int[] {3, 6, 6};

        System.out.println(Arrays.toString(sortEvenOdd(array)));

    }

    public static int[] sortEvenOdd(int[] nums) {

        // for odds

        int temp;

        for (int i = 1; i <= nums.length - 2; i += 2) {
            for (int j = 1; j <= nums.length - i - 2; j += 2) {

                if (nums[j] < nums[j + 2]) {
                    temp = nums[j + 2];
                    nums[j + 2] = nums[j];
                    nums[j] = temp;
                }

            }
        }

        // for evens

        for (int i = 0; i < nums.length - 2; i += 2) {
            for (int j = 0; j < nums.length - i - 2; j += 2) {

                if (nums[j] > nums[j + 2]) {
                    temp = nums[j + 2];
                    nums[j + 2] = nums[j];
                    nums[j] = temp;
                }

            }
        }

        return nums;
    }
}
