package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class Number_of_Digit_One_233 {

    static int[] memoTable;

    public static void main(String[] args) {

        int number = 1000000000;

        long finish1 = System.nanoTime();

        System.out.println(countDigitOne(number));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

    }

    public static int countDigitOne(int n) {

        String s = n + "";

        memoTable = new int[s.length()];

        Arrays.fill(memoTable, -1);

        return recursiveSeeker(n);
    }

    public static int recursiveSeeker (int n) { /** accepted (speed: 1ms, fast) **/

        if (n < 10) {
            if (n == 0) return 0;
            else return 1;
        }

        String s = n + "";
        int number = Integer.parseInt(s.substring(0, 1));
        int countAll = 0;

        if (n == (int) Math.pow(10, s.length() - 1) - 1 && memoTable[s.length() - 1] != -1) {
            return memoTable[s.length() - 1];
        }

        countAll += recursiveSeeker(n - number * (int) Math.pow(10, s.length() - 1)); // first phase

        countAll += number * recursiveSeeker((int) Math.pow(10, s.length() - 1) - 1); // second phase

        if (number >= 2) countAll += (int) Math.pow(10, s.length() - 1); // third phase
        else countAll += n - (int) Math.pow(10, s.length() - 1) + 1;

        if (n == (int) Math.pow(10, s.length() - 1) - 1 && memoTable[s.length() - 1] == -1) {
            memoTable[s.length() - 1] = countAll;
        }

        return countAll;
    }
}
