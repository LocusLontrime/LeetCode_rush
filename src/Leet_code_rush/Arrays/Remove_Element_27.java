package Leet_code_rush.Arrays;

public class Remove_Element_27 {

    public static void main(String[] args) { /** accepted **/

        int[] array = new int[] {1, 2, 2, 4, 4, 7, 9, 12, 2, 4, 5, 4, 4, 2, 1, 2, 2, 98};
        int val = 2;

        System.out.println(removeElement(array, val));

        System.out.println();

        array_print(array);

    }

    public static int removeElement(int[] nums, int val) {

        int counter = 0;

        for (int i = 0; i < nums.length; i ++) {

            if (nums[i] != val) {
                if (counter != i) nums[counter] = nums[i];
                counter++;
            }

        }

        return counter;
    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
