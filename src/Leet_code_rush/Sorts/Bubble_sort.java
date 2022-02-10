package Leet_code_rush.Sorts;

public class Bubble_sort {

    static int[]array;
    static int n_auxiliary;
    static long steps_counter = 0;

    public static void main(String[] args) {

        array = Q_sort_ints.array_random_fulfilling(100000);

        long start = System.nanoTime();

        bubble_sort();

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //array_print();
        System.out.println();

        System.out.println("bubble_sort made " + steps_counter + " steps");

    }

    public static void bubble_sort () {

        int l = array.length;

        for (int i = 0; i < l - 1; i ++) { // bubble sort from the largest one (left) to the smallest (right).
            for (int j = l - 1; j > i; j --) {
                if (array[j] > array[j - 1]) {
                    ints_permutation(j, j-1);
                    steps_counter ++;
                }
            }
        }

    }

    public static void ints_permutation (int i, int j) { // permutation without auxiliary variable requires multiple additional operations (addition and subtraction)

        n_auxiliary = array[i];
        array[i] = array[j];
        array[j] = n_auxiliary;

    }

}
