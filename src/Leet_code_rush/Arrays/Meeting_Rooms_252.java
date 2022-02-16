package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Meeting_Rooms_252 {
    static int[][] array;

    public static void main(String[] args) {

        int[][] pairs = new int[][] {}; //{{7,10},{2,4}}; // {{0,30},{5,10},{15,20}}; // {{10,30},{5,10},{15,20},{5,25}};

        System.out.println(pairs.length);

        System.out.println("True or False: " + canAttendMeetings(pairs));
    }

    public static boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length == 0) return true; // dangerous case

        boolean flag = true;

        array = intervals;

        recursiveBubble(intervals.length); // sorting elements

        for (int i = 0; i < intervals.length - 1; i++) {

            if (array[i][1] > array[i + 1][0]) { // condition of intervals overlapping
                flag = false;
                break; // if the flag is false now we can break from the cycle
            }

        }

        return flag; // the answer itself
    }

    public static void recursiveBubble (int length) { // recursiveBubble

        if (length == 1) return; // base case
        int[] temp; // temporal variable

        for (int i = 0; i < length - 1; i++) {
            if (array[i][0] > array[i + 1][0]) { // changing elements
                temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }

        recursiveBubble(length - 1); // step of recursion
    }
}
