package Leet_code_rush.Sorts;

import Leet_code_rush.Sorts.Q_sort_ints;

public class Comb_sort {

    static int[]array;
    static int n_auxiliary;
    static int steps_counter = 0;
    static int distance; // distance between two elements being compared
    static int permutations_counter = 2; // minimal value higher than 1, auxiliary parameter for while cycle functioning
    static int counter; // counter of permutation

    final static double golden_ratio = (1.0 + Math.sqrt(5)) / 2;
    final static double coefficient = 1.0 / (1.0 - Math.pow(Math.E, - golden_ratio)); // ideal coefficient for comb_sort

    public static void main(String[] args) {

        System.out.println("Golden ratio = " + golden_ratio + " Coefficient = " + coefficient + "\n");

        array = Q_sort_ints.array_random_fulfilling(10000000);
        distance = array.length;

        long start = System.nanoTime();
        comb_sort();
        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000 + "\n");

        //array_print();
        System.out.println();

        System.out.println("comb_sort made " + steps_counter + " steps");

        //Q_sort_ints.array_print(array);

    }

    public static void comb_sort () {

        while (permutations_counter > 1) { // auxiliary parameter for cycle management

            distance = (int) (distance / coefficient);

            if (distance < 1) distance = 1; // while distance reaches values less than 1 the algorithm proceed to the second phase - babble sorting until all the array's elements has been sorted (counter equals zero)

            counter = 0; //permutations counter

            for (int i = 0; i + distance < array.length; i++) {

                if (array[i] > array[i + distance]) {
                    ints_permutation(i,i + distance);
                    counter = i;
                }

                steps_counter ++;

            }

            if (distance == 1) permutations_counter = counter + 1;

        }

    }

    public static void ints_permutation (int i, int j) { // permutation without auxiliary variable requires multiple additional operations (addition and subtraction)

        n_auxiliary = array[i];
        array[i] = array[j];
        array[j] = n_auxiliary;

    }

}

