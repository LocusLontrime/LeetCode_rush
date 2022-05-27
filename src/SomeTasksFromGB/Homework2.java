package SomeTasksFromGB;

public class Homework2 {

    static int [] array;

    public static void main(String[] args) {

        array = new int[] {1, 1, 6, 7, 989, 5, 77, 9, 1, 55, 555, 0, 7, 7, 100};

        System.out.println(sum_between_min_and_max());
        System.out.println(5 + 77 + 9 + 1 + 55 + 555);

        //System.out.println("Odd elements sum = " + odd_elements_sum());
        //System.out.println(1 + 1 + 7 + 989 + 77 + 9 + 1 + 55 + 555 + 7 + 7);

        //System.out.println("Odd indexes elements sum = " + odd_indexes_elements_sum());
        //System.out.println(1 + 7 + 77 + 1 + 555 + 7 + 100);

        //array_reverse();

        //System.out.println("Arithmetic mean = " + arithmetic_mean());

        //Q_sort_ints.array_print(array);

    }

    /**
     * Task 9 - calculation of the sum of all array elements located between min and max values
     */

    public static int sum_between_min_and_max () { // {1, 1, 0, 56, 989, 7, 98}

        int max_element_index = 0;
        int min_element_index = 0;
        int sum = 0;

        for (int counter = 1; counter < array.length; counter ++) { //finding min and max elements' indexes
            if (array[counter] > array[max_element_index]) max_element_index = counter; // max element location
            if (array[counter] < array[min_element_index]) min_element_index = counter; // min element location
        }

        int left_border = Math.min(max_element_index, min_element_index); // calculating the left border of array to sum

        for (int counter = 1 /* left border is not counted */; counter < Math.abs(max_element_index - min_element_index) /* right border is not counted */; counter ++) {
            sum += array[left_border + counter];
        }

        return sum; // required sum
    }

    /**
     * Task 8 - array mirror reverse
     */

    public static void array_reverse () {

        int i = 0;

        while (i < array.length - 1 - i) elements_swap(i, array.length - 1 - i++);

    }

    /**
     * method for array's elements swapping
     * @param first_index - first element to swap
     * @param second_index - second one
     */

    public static void elements_swap (int first_index, int second_index) {

        int temporal_variable = array[first_index];
        array[first_index] = array[second_index];
        array[second_index] = temporal_variable;

    }

    /**
     * Task 4 - calculation ot the sum of odd array's elements
     */

    public static int odd_elements_sum () {

        int sum = 0;

        for (int i = 0; i < array.length; i ++) if (array[i] % 2 != 0) sum += array[i];

        return sum;

    }

    /**
     * Task 3 - calculating of the sum of array's elements with odd indexes
     */

    public static int odd_indexes_elements_sum () {

        int sum = 0;

        for (int i = 0; i < array.length; i ++) if (i % 2 != 0) sum += array[i];

        return sum;

    }

    /**
     * Task 5 - arithmetic mean of all array's elements
     */

    public static double arithmetic_mean () {

        double sum = 0;

        for (int i = 0; i < array.length; i ++) sum += array[i];

        return sum / array.length;

    }

}
