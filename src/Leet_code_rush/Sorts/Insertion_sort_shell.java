package Leet_code_rush.Sorts;

import Leet_code_rush.Sorts.Q_sort_ints;

import java.util.ArrayList;
import java.util.Collections;

import static Leet_code_rush.Sorts.Shell_sequence_type.*;

public class Insertion_sort_shell {

    static int[]array;
    static long steps_counter = 0;

    static ArrayList<Integer> list = new ArrayList<>(); // keeps shell_sequence_elements - Pratt's idea or something else

    static int[] auxiliary_array; // keeps shell_sequence_elements - Pratt's idea

    public static void main(String[] args) {

        array = Q_sort_ints.array_random_fulfilling(10000000);

        long start = System.nanoTime();

        insertion_sort_shell(KNUTH);

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

        //array_print();
        System.out.println();

        System.out.println("insertion_sort made " + steps_counter + " steps");

        //Q_sort_ints.array_print(array);

    }

    public static void insertion_sort () {

        int current_value;
        int j;

        for (int i = 2; i < array.length; i ++) {

            current_value = array[i];

            j = i - 1;

            while (j > 0 && array[j] > current_value) {

                array[j + 1] = array[j];

                j--;
                steps_counter ++;

            }

            array[j + 1] = current_value;

        }

    }

    public static void insertion_sort_shell (Shell_sequence_type type) {

        switch (type) {
            case PRATT: find_shell_elements_Pratt (array.length);
            break;
            case SHELL: find_shell_elementary_elements(array.length);
            break;
            case HIBBARD: find_shell_elements_Hibbard(array.length);
            break;
            case KNUTH: find_shell_elements_Knuth(array.length);
            break;
        }

        int distance; // shell_parameter - distance between elements
        int current_value; // element to insert in a proper way
        int j;

        for (int k = list.size() - 1; k >= 0; k --) {

            distance = list.get(k);

            for (int i = distance; i < array.length; i++) {

                current_value = array[i];

                j = i - distance;

                while (j > 0 && array[j] > current_value) {

                    array[j + distance] = array[j];

                    j-= distance;
                    steps_counter++;

                }

                array[j + distance] = current_value;

            }
        }

    }

    public static void find_shell_elements_Pratt (int N) {

        int sequence_element = 1;

        int i = 0, j = -1;

        while (Math.pow(2, i) <= N/2.0) {

            while (sequence_element <= N/2.0) {

                list.add(sequence_element);

                sequence_element = (int) (Math.pow(2, i) * Math.pow(3, j));

                j ++;
            }

            j = 1;
            i ++;
            sequence_element = (int) Math.pow(2, i);
        }

        Collections.sort(list);

        list.remove(0);
        list.remove(0);

        System.out.println(list);

    }

    public static void find_shell_elementary_elements (int N) {

        int sequence_element = N / 2;

        while (sequence_element >= 1) {

            list.add(0, sequence_element);

            sequence_element /= 2;

        }

        System.out.println(list);

    }

    public static void find_shell_elements_Hibbard (int N) {

        int sequence_element = 1;
        int i = 2;

        while (sequence_element <= N) {

            list.add(sequence_element);

            sequence_element = (int) (Math.pow(2, i) - 1);

            i++;

        }

        System.out.println(list);

    }

    public static void find_shell_elements_Knuth (int N) {

        int sequence_element = 1;
        int i = 2;

        while (sequence_element <= N / 3) {

            list.add(sequence_element);

            sequence_element = (int) ((Math.pow(3, i) - 1) / 2);

            i++;

        }

        System.out.println(list);

    }

}
