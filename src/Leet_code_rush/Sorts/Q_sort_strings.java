package Leet_code_rush.Sorts;

public class Q_sort_strings {

    static String [] array;
    static String s_auxiliary;

    static int recursive_counter = 0;

    public static void main(String[] args) {

        array = new String[]{"1", "11", "15", "16", "16", "15", "97", "13", "21", "111", "27", "77", "7", "77", "1", "1", "1", "1", "1", "1", "1", "50"};

        String s = "hello";

        System.out.println("Comparing: " + s.compareTo("monday"));

        System.out.println(array[21]);

        q_sort (array, 0, array.length - 1);

        System.out.println("q_sort has been called " + recursive_counter + "-times");

    }

    public static void stabilization () { // initial array modifying for q_sort stability

        for (int i = 0; i < array.length; i ++) {



        }
    }

    public static void q_sort (String [] array, int starting_index, int ending_index) { // recursive method of array sorting

        if (starting_index < ending_index) {

            recursive_counter ++;

        String median = string_median(array[starting_index], array[(starting_index + ending_index) / 2], array[ending_index]); // using a median value for start, end and middle elements of the array given
        System.out.println("median = " + median);

        int pivot_index = array_permutation(array, starting_index, ending_index, median);
        System.out.println("pivot_index = " + pivot_index);

        array_print();

        //if (pivot_index != starting_index && pivot_index != ending_index) {

            q_sort(array, starting_index, pivot_index);
            q_sort(array, pivot_index + 1, ending_index);

            //}
        }
    }

    public static int array_permutation (String [] array, int starting_index, int ending_index, String median) { // Hoare partition
        int i = starting_index;
        int j = ending_index;

        System.out.println("At the beginning i = " + i);
        System.out.println("At the beginning j = " + j);

        while (true) {

            while (array[i].compareToIgnoreCase(median) < 0) i ++;
            while (array[j].compareToIgnoreCase(median) > 0) j --;

            if (i < j) strings_permutation(i++, j--);
            else return j; // returning j value if two pointer has met, this value will be counted as a pivot value for the next recursion step of the q_sort

        }
    }

    public static void strings_permutation (int i, int j) {

        s_auxiliary = array[i];
        array[i] = array[j];
        array[j] = s_auxiliary;

    }

    public static String string_median (String s1, String s2, String s3) { // median for 3 String values

        if (s1.compareToIgnoreCase(s2) >= 0) {
            if (s2.compareToIgnoreCase(s3) >= 0) return s2;
            else {
                if (s1.compareToIgnoreCase(s3) >= 0) return s3;
                else return s1;
            }
        } else {
            if (s2.compareToIgnoreCase(s3) >= 0) {
                if (s1.compareToIgnoreCase(s3) >= 0) return s1;
                else return s3;
            } else return s2;
        }

    }

    public static void array_print () {
        for (String j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }

}
