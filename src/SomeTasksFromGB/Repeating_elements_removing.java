package SomeTasksFromGB;

import Leet_code_rush.Sorts.Q_sort_ints;

public class Repeating_elements_removing {

    static int [] array = new int [] {1, 1, 1, 5, 5, 989, 999, 999, 999, 7777};

    public static void main(String[] args) {

        System.out.print("Initial array: ");

        Q_sort_ints.array_print(array); // just an elementary self-made print method

        System.out.println("Arithmetic mean = " + arithmetic_mean());

        repeating_elements_removing();

        System.out.print("The array after repeating elements removing: ");

        Q_sort_ints.array_print(array);

    }

    public static double arithmetic_mean () {

        double sum = 0;

        for (int j : array) sum += j;

        return sum / array.length;
    }

    public static void repeating_elements_removing () {

        int counter = 0;

        for (int i = 0; i < array.length - 1; i ++) {
            if (array[i] != array[i + 1]) {
                counter ++;
                array[counter] = array[i + 1]; // write new element on the right position
            }
        }

        for (int i = counter + 1; i < array.length; i ++) array[i] = 0; // removing a tail of repeating elements
    }

}
