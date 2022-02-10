package Leet_code_rush.Arrays;

public class Replace_Elements_with_Greatest_Element_on_Right_Side_1299 { /** accepted **/

    public static void main(String[] args) {

        int[] array = new int[] {98}; //{17,18,5,4,6,1};

        replaceElements(array);

        array_print(array);

    }

    public static int[] replaceElements(int[] arr) {

        int max_right_element;
        int next_max_element = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {

            max_right_element = next_max_element;
            if (arr[i - 1] > next_max_element) next_max_element = arr[i - 1];

            arr[i - 1] = max_right_element;

        }

        arr[arr.length - 1] = -1;

        return arr;

    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
