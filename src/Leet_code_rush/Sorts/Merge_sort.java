package Leet_code_rush.Sorts;

import Leet_code_rush.Sorts.Q_sort_ints;

public class Merge_sort {

    private static int[]array;
    private static int n_auxiliary;

    public static void main(String[] args) {

        array = Q_sort_ints.array_random_fulfilling(10000000);

        long start = System.nanoTime();

        merge_sort(array, 0, array.length - 1);

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //array_print();
        System.out.println();

        long steps_counter = 0;
        System.out.println("bubble_sort made " + steps_counter + " steps");

        //Q_sort_ints.array_print(array);

    }

    public static void merge_sort (int[] array, int starting_index, int ending_index) {

        int median = (starting_index + ending_index) / 2; // or a + (b - a) / 2

        if (starting_index < ending_index) {

            merge_sort(array, starting_index, median); // divide and conquer strategy section, initial array is dividing into 2 parts until sub-arrays become of 1 element
            merge_sort(array, median + 1, ending_index);

            merge(array, starting_index, median, ending_index); // merging section, after the recursive stack reaches its bottom sub-arrays begin to merge from 1-element arrays to the final sorted one.

        }

    }

    public static void merge (int[] array, int starting_index, int median, int ending_index) { // merge algorithm, it needs some additional memory to run

        int[] auxiliary_array_left = new int[median - starting_index + 1]; // initialization of auxiliary arrays
        int[] auxiliary_array_right = new int[ending_index - median];

        int i = 0;
        int j = 0;

        array_copy(auxiliary_array_left, starting_index, median); // fulfilling the auxiliary arrays
        array_copy(auxiliary_array_right, median + 1, ending_index);

        while (i < auxiliary_array_left.length && j < auxiliary_array_right.length) { // choosing the right elements from two sub-arrays and write them to final array

            if (auxiliary_array_left[i] <= auxiliary_array_right[j]) {
                array[starting_index + i + j] = auxiliary_array_left[i];
                i ++;
            } else {
                array[starting_index + i + j] = auxiliary_array_right[j];
                j ++;
            }
        }

        for (int counter = i; counter < auxiliary_array_left.length; counter ++) array[starting_index + counter + j] = auxiliary_array_left[counter];
        for (int counter = j; counter < auxiliary_array_right.length; counter ++) array[starting_index + counter + i] = auxiliary_array_right[counter];

    }

    public static void array_copy (int[] array_to_save_copy, int left_border, int right_border) {

        for (int i = 0; i <= right_border - left_border; i ++) {
            array_to_save_copy[i] = array[left_border + i];
        }

    }

}
