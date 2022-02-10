package Leet_code_rush.Arrays;

import Leet_code_rush.Sorts.Q_sort_ints;

public class Height_Checker_1051 { /** accepted (speed: very fast) **/

    static int[]array;
    static int n_auxiliary;

    public static void main(String[] args) {

        int[] array = new int[] {8,8,2,5,6,3,2,2,4,7,4,9,6,5,9,7,4,3,6,2,7,3,2,5,7}; //{2, 2, 2, 2, 2, 2 ,2 }; //{5,1,2,3,4};

        Q_sort_ints.array_print(array);

        System.out.println("Matched indexes' number = " + heightChecker(array));

        Q_sort_ints.array_print(array);

    }

    public static int heightChecker(int[] heights) {

        array = heights;

        int[] nums = heights.clone();

        int counter = 0;

        q_sort(array, 0,array.length - 1);

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != array[i]) counter ++;
        }

        return counter;

    }

    public static void q_sort (int [] array, int starting_index, int ending_index) { // recursive method of array sorting

        if (starting_index < ending_index) {

            int median = (array[starting_index] + array[(starting_index + ending_index) / 2] + array[ending_index]) / 3; // using a median value for start, end and middle elements of the array given

            int pivot_index = array_permutation(array, starting_index, ending_index, median);

            if (pivot_index > starting_index) q_sort(array, starting_index, pivot_index);
            if (pivot_index + 1 < ending_index) q_sort(array, pivot_index + 1, ending_index);

        }
    }

    public static int array_permutation (int [] array, int starting_index, int ending_index, int median) { // Hoare partition
        int i = starting_index;
        int j = ending_index;

        while (true) {

            while (array[i] < median) i ++;
            while (array[j] > median) j --;

            if (i < j) {
                ints_permutation(i ++ , j --);
            } else return j; // returning j value if two pointer has met, this value will be counted as a pivot value for the next recursion step of the q_sort

        }
    }

    public static void ints_permutation (int i, int j) { // permutation without auxiliary variable requires multiple additional operations (addition and subtraction)

        n_auxiliary = array[i];
        array[i] = array[j];
        array[j] = n_auxiliary;

    }

}
