package Leet_code_rush.Arrays;

public class Duplicate_Zeros_1089 { /** accepted **/

    public static void main(String[] args) {

        int[] array = new int[] {1,0,2,3,0,4,5,0}; //{1,2,3}; //{1,0,2,3,0,4,5,0};

        duplicateZeros(array);

        array_print(array);

    }

    public static void duplicateZeros(int[] arr) {

        int aux_length = 0;

        for (int j : arr) if (j == 0) aux_length++;

        int[] auxiliary_array = new int[arr.length + aux_length];
        int upper_pointer = 0;

        for (int i = 0; i < arr.length; i ++) {

            auxiliary_array[upper_pointer] = arr[i];

            if (arr[i] == 0) {
                auxiliary_array[upper_pointer + 1] = 0;
                upper_pointer+=2;
            } else upper_pointer++;
        }

        System.arraycopy(auxiliary_array, 0, arr, 0, arr.length);

    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
