package Leet_code_rush.Arrays;

public class Remove_Duplicates_from_Sorted_Array_26 { /** accepted **/

    public static void main(String[] args) {

        int[] array = new int[] {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(array));

        array_print(array);

    }

    public static int removeDuplicates(int[] nums) {

        int counter = 0;

        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] != nums[i + 1]) {
                counter ++;
                nums[counter] = nums[i + 1]; // write new element on the right position
            }
        }

        for (int i = counter + 1; i < nums.length; i ++) nums[i] = 0; // removing a tail of repeating elements

        return counter + 1;

    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
