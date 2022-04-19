package Leet_code_rush.Dynamic_Programming;

public class Digit_Count_in_Range_1067 {

    static int N;

    static int counter = 0;

    public static void main(String[] args) {

        //System.out.println(digitsCount(3, 100, 250));
        //System.out.println(digitsCount(1, 1, 13));
        //System.out.println(digitsCount(2, 1, 20));
        //System.out.println(digitsCount(0, 625, 1250));
        //System.out.println(digitsCount(0, 1, 958)); // 185
        System.out.println(digitsCount(0, 1, 9980055)); // 5881017

        // System.out.println(digitsCount(0, 1, 100)); // 11
        System.out.println("Counter = " + counter);
    }

    public static int digitsCount(int d, int low, int high) {

        N = low;

        int recLow = recursiveSeeker(d, low - 1);

        N = high;

        int recHigh = recursiveSeeker(d, high);

        System.out.println("recLow = " + recLow + " recHigh = " + recHigh);

        return recHigh - recLow;
    }

    public static int recursiveSeeker(int d, int n) {

        if (n < 10) {
            counter++;
            if (n < d) return 0;
            else return 1;
        }

        String s = n + "";

        int number = Integer.parseInt(s.substring(0, 1));
        int countAll = 0;

        System.out.println("first phase: " + (n - number * (int) Math.pow(10, s.length() - 1)));
        countAll += recursiveSeeker(d, n - number * (int) Math.pow(10, s.length() - 1)); // first phase

        System.out.println("second phase: " + ((int) Math.pow(10, s.length() - 1) - 1));
        countAll += number * recursiveSeeker(d, (int) Math.pow(10, s.length() - 1) - 1); // second phase

        System.out.println("lala");
        if (number >= d + 1) countAll += (int) Math.pow(10, s.length() - 1); // third phase
        else if (number == d) countAll += n - number * (int) Math.pow(10, s.length() - 1) + 1;

        return countAll;
    }
}
