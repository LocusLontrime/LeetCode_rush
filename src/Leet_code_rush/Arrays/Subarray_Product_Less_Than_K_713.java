package Leet_code_rush.Arrays;

public class Subarray_Product_Less_Than_K_713 { /** accepted (speed: 5ms, ultra-fast, beats 99,56% java submissions) **/

    public static void main(String[] args) {

        System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int left_index = 0;
        int right_index = 0;

        int arrays_quantity = 0;

        int current_product = 1;

        while (right_index < nums.length) {

            if (current_product * nums[right_index] < k) {

                current_product *= nums[right_index];
                arrays_quantity += ((right_index - left_index) + 1);
                right_index++;

            } else {

                if (right_index == left_index) {
                    right_index++;
                    left_index++;
                    current_product = 1;
                } else {
                    current_product /= nums[left_index];
                    left_index++;
                }

            }

        }

        return arrays_quantity;

    }

}
