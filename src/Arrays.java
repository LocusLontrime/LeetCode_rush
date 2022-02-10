import Leet_code_rush.Sorts.Q_sort_ints;

public class Arrays
{

    static int [] array_left = {1, 5, 78, 5, 6, 989};
    static int [] array_right = {56, 6, 78, 1, 0, 98};

    public static void main(String[] args) {
        arrays_swap(array_left, array_right);

        Q_sort_ints.array_print(array_left);
        Q_sort_ints.array_print(array_right);
    }

    public static void arrays_swap (int[] array_l, int[] array_r) {

        for (int i = 0; i < array_l.length; i ++) {

            array_l[i] = array_l[i] + array_r[i];
            array_r[i] = array_l[i] - array_r[i];
            array_l[i] = array_l[i] - array_r[i];

        }

    }



}
