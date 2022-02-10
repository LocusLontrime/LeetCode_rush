package Leet_code_rush.Recursion;

public class Pascals_Triangle_118 { /** accepted **/

    public static void main(String[] args) {

       getRow(10);
    }

    public static int[] getRow(int rowIndex) { // returns n-th row of Pascal Triangle

        int[] array = new int[rowIndex + 1];

        array[0] = 1;

        array_print(array);

        int[] prev_array = array.clone();

        for (int i = 1; i <= rowIndex; i ++) {

            for (int j = 1; j < i; j ++) array[j] = prev_array[j] + prev_array[j-1];

            array[i] = 1;

            prev_array = array.clone();

            array_print(array);
        }

        return array;
    }

    public static void array_print(int[] array) { // prints array

        for (int i : array) {

            if (i == 0) break;

            System.out.print(i + " ");
        }

        System.out.println();
    }
}
