import Leet_code_rush.Sorts.Q_sort_ints;

public class Two_pointers {

    static int [] array = new int[] {13, 2, 2, 13, 2, 6, 4, 2, 2, 98, 98, 2, 1, 1, 2}; //{1, 5, 2, 1, 1, 2};

    public static void main(String[] args) {

        Q_sort_ints.array_print(array);

        //sort();

        delete_elements();

        Q_sort_ints.array_print(array);

    }

    public static void sort () {

        int left_pointer = 0;
        int right_pointer = array.length - 1;
        int temp;

        while (true) {

            while (array[right_pointer] == 2) right_pointer--; // {9, 4, 2, 6, 7, 8, 2, 2}
            while (array[left_pointer] != 2) left_pointer++;

            if (left_pointer >= right_pointer) break;

            temp = array[right_pointer]; // swap
            array[right_pointer] = array[left_pointer];
            array[left_pointer] = temp;

            left_pointer++;
            right_pointer--;

        }
    }






    public static void delete_elements () {
        int special_pointer = -1;
        int temp;

        for (int i = 0; i < array.length; i ++) {

            if (array[i] != 2) {
                special_pointer ++;

                temp = array[i];
                array[i] = array[special_pointer];
                array[special_pointer] = temp;

            }
        }

        for (int i = special_pointer + 1; i < array.length; i ++) array[i] = 0;

    }







    public static void sort_ints (int... array) {

    }
}
