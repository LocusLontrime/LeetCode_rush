package Code_wars_rush;

import java.util.ArrayList;
import java.util.Collections;

public class Weight_for_weight_5kyu {

    public static void main(String[] args) {

        String s = "56 65 74 100 99 68 86 83 180 92 90"; /** "100 180 90 56 65 74 68 86 99" 366 989**/

        // s = "2000 10003 1234000 44444444 9999 11 11 22 123";

        s = "59544965313";

        s = "2000 103 123 4444 99 11 11 2000 10003 22 123 1234000 44444444 9999 2000 10003 1234000 44444444 9999" +
                " 123456789 3 16 9 38 95 1131268 49455 347464 59544965313 85246814996697 496636983114762";

        System.out.println("\nResult: " + orderWeight(s));

        System.out.print(digitsSum(85246814996697L, 0) + " " + digitsSum(496636983114762L, 0));

        // System.out.print((8 + "").compareTo(1111111 + ""));
    }

    public static String orderWeight(String strng) { // covering

        if (strng.equals("")) return "";

        long[] array = parse(strng);

        StringBuilder resString = new StringBuilder("");

        q_sort(array, 0, array.length - 1);

        int i = 0;

        ArrayList<String> strs = new ArrayList<String>();

        while (i < array.length) {

            while (i < array.length - 1 && digitsSum(array[i], 0) == digitsSum(array[i + 1], 0)) {

                strs.add(array[i++] + " ");

            }

            strs.add(array[i++] + "");

            Collections.sort(strs);

            for (String s : strs) {
                System.out.print(s + " ");
                resString.append(s).append(" ");
            }

            strs.clear();
        }

        resString.delete(resString.length() - 1, resString.length());

        return resString.toString();
    }

    public static long[] parse(String string) {

        String[] nums = string.split(" ");

        long[] numbers = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Long.parseLong(nums[i]);
        }

        return numbers;
    }

    public static void q_sort (long [] array, int starting_index, int ending_index) { // recursive method of array sorting

        if (starting_index < ending_index) {

            int median = (digitsSum(array[starting_index], 0) + digitsSum(array[(starting_index + ending_index) / 2], 0) + digitsSum(array[ending_index], 0)) / 3; // using a median value for start, end and middle elements of the array given

            // int alphabeticalMedian = (array[starting_index] + array[(starting_index + ending_index) / 2] + array[ending_index]) / 3;

            int pivot_index = array_permutation(array, starting_index, ending_index, median);

            if (pivot_index > starting_index) q_sort(array, starting_index, pivot_index);
            if (pivot_index + 1 < ending_index) q_sort(array, pivot_index + 1, ending_index);
        }
    }

    public static int array_permutation (long[] array, int starting_index, int ending_index, int median) { // Hoare partition
        int i = starting_index;
        int j = ending_index;

        while (true) {

            while (digitsSum(array[i], 0) < median) i ++;
            while (digitsSum(array[j], 0) > median) j --;

            if (i < j) {
                ints_permutation(i ++ , j --, array);
            } else return j; // returning j value if two pointer has met, this value will be counted as a pivot value for the next recursion step of the q_sort
        }
    }


    public static void ints_permutation (int i, int j, long[] array) { // permutation without auxiliary variable requires multiple additional operations (addition and subtraction)

        long n_auxiliary = array[i];
        array[i] = array[j];
        array[j] = n_auxiliary;
    }

    public static int digitsSum(long number, int result) {
        if (number == 0) return result;

        return digitsSum(number / 10L, result + (int) (number % 10));
    }
}
