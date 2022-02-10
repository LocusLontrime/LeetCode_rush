package Leet_code_rush.Sorts;

import Leet_code_rush.Sorts.Q_sort_ints;

import java.util.ArrayList;
import java.util.List;

public class Radix_sort {

    static int[]array;
    static List<Integer>[] radix_lists = new ArrayList[10];

    static long steps_counter = 0;

    static {
        for (int i = 0; i < radix_lists.length; i ++) radix_lists[i] = new ArrayList<Integer>();
    }

    public static void main(String[] args) {

        array = Q_sort_ints.array_random_fulfilling(10000000);

        long start = System.nanoTime();

        radix_sort();

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        System.out.println();

        System.out.println("radix_sort made " + steps_counter + " steps");
        //Q_sort_ints.array_print(array);
    }

    public static void radix_sort () {

        boolean cyclingOrNo = true;
        int divisor = 1;
        int element_at_current_step;
        int counter;

        while (cyclingOrNo) {

            cyclingOrNo = false;

            for (int j : array) { // dividing by radix lists

                element_at_current_step = j / divisor;

                radix_lists[element_at_current_step % 10].add(j);

                if (!cyclingOrNo && element_at_current_step > 0) cyclingOrNo = true;

                steps_counter ++;

            }

            counter = 0;

            for (List<Integer> list : radix_lists) { // merging in array

                for (int element : list) {
                    array[counter] = element;
                    counter ++;
                    steps_counter ++;
                }

            }

            for (List<Integer> list : radix_lists) {
                list.clear();
                steps_counter ++;
            }

            divisor *= 10;

        }

    }

}
