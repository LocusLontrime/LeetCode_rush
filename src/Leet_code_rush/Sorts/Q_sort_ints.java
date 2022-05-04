package Leet_code_rush.Sorts;

public class Q_sort_ints {

    static int[]array;
    static int n_auxiliary;
    static int recursive_counter = 0;

    public static void main(String[] args) {

        // array = new int[]{1, 11, 15, 16, 16, 15, 97, 13, 21, 111, 27, 77, 7, 77, 1, 1, 1, 1, 1, 1, 1, 50};

        array = array_random_fulfilling(10000000);

        //array = new int[] {8,8,2,5,6,3,2,2,4,7,4,9,6,5,9,7,4,3,6,2,7,3,2,5,7};

        long start = System.nanoTime();

        System.out.println("Sorting array of " + array.length + " numbers from " + 0 + " to " + array.length);

        q_sort(array, 0,array.length - 1);

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //array_print(array);
        System.out.println();

        System.out.println("q_sort has been called " + recursive_counter+ "-times");

    }

    public static int [] array_random_fulfilling (int array_length) {

        int [] array = new int [array_length];

        for (int i = 0; i < array_length; i++) {
            array[i] = (int) (Math.random() * array_length);
        }

        return array;
    }

    public static void stabilization () { // initial array modifying for q_sort stability

        for (int i = 0; i <array.length; i ++) {



        }
    }

    public static void q_sort (int [] array, int starting_index, int ending_index) { // recursive method of array sorting

        if (starting_index < ending_index) {

            recursive_counter++;

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

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
