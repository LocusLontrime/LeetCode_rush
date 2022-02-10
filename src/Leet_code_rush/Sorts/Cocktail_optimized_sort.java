package Leet_code_rush.Sorts;

public class Cocktail_optimized_sort {

    static int[]array;
    static int n_auxiliary;
    static long steps_counter = 0;

    public static void main(String[] args) {

        array = Q_sort_ints.array_random_fulfilling(100000);

        long start = System.nanoTime();

        cocktail_sort();

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //array_print();
        System.out.println();

        System.out.println("cocktail_sort made " + steps_counter + " steps");

        Q_sort_ints.array_print(array);

    }

    public static void cocktail_sort() { // on every step new array is shaping by the indexes of last elements rearranged

        int left_index = 0;
        int right_index = array.length - 1;

        int new_position = 0;


        while (left_index < right_index ) {

            for (int i = left_index; i < right_index; i ++) {

                if (array[i] > array[i + 1]) {
                    ints_permutation(i, i + 1);
                    new_position = i;
                }

                steps_counter ++;

            }

            right_index = new_position;

            for (int i = right_index; i > left_index; i --) {

                if (array[i] < array[i - 1]) {
                    ints_permutation(i, i - 1);
                    new_position = i;
                }

                steps_counter ++;

            }

            left_index = new_position;

        }

    }

    public static void ints_permutation (int i, int j) { // permutation without auxiliary variable requires multiple additional operations (addition and subtraction)

        n_auxiliary = array[i];
        array[i] = array[j];
        array[j] = n_auxiliary;

    }

}
