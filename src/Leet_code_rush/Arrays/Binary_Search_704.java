package Leet_code_rush.Arrays;

public class Binary_Search_704 {

    static int recursive_counter;

    public static void main(String[] args) { /** accepted (speed: fast) **/

        int[] array = new int[] {-2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 24, 43 ,56, 67, 98};
        //array = array_fulfilling(1024 * 1024 * 1024);
        int target = 1024 * 1024;
        target = -1;

        System.out.println(search(array, target));

        System.out.println("Actions quantity: " + recursive_counter);

    }

    public static int search(int[] nums, int target) {

        if (target < nums[0]) return -1;

        recursive_counter = 0;

        return recursive_seeker(nums, target,0, nums.length - 1);

    }

    public static int recursive_seeker(int[] nums, int target, int left_border, int right_border) { // some addition to binary sort like in Arrays.binSearch

        recursive_counter++;

        //base case if()

        if (left_border == right_border) {
            if (nums[left_border] == target) return left_border;
            else return -1 * left_border - 1;
        }

        // median evaluating

        int pivot_index = (left_border + right_border) / 2;

        int pivot_element = nums[pivot_index];

        // comparison with pivot element

        if (pivot_element == target) return pivot_index;
        else if (pivot_element < target) return recursive_seeker(nums, target,pivot_index + 1, right_border);
        else return recursive_seeker(nums, target, 0 , pivot_index);
         // left rec + right rec
    }

    public static int[] array_fulfilling (int length) {

        int[] array = new int[length];

        for (int i = 0; i < length; i ++) {
            array[i] = i;
        }

        return array;

    }

}
