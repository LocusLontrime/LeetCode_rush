package Leet_code_rush.Dynamic_Programming;
import java.util.Arrays;

public class Number_of_Dice_Rolls_With_Target_Sum_1155 {

    static int[][] memoTable;

    static final int modulo = 1000000007;

    public static void main(String[] args) { // 5966266

        int n = 36, k = 50, target = 900;

        // int n = 2, k = 6, target = 7;

        // int n = 5, k = 12, target = 15;

        long finish1 = System.nanoTime();

        System.out.println(numRollsToTarget(n, k, target));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

    }

    public static int numRollsToTarget(int n, int k, int target) { /** accepted (speed: 4ms, ultra-fast, beats 98,59 java submissions) **/

        memoTable = new int[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++) Arrays.fill(memoTable[i], -1); // memo initial fulfilling

        return recursiveSeeker(n, k, target) % modulo;
    }

    public static int recursiveSeeker (int n, int k, int target) {

        if (memoTable[n][target] == -1) {

            if (n * k < target) memoTable[n][target] = 0;
            else {

                if (n == 1) {
                    if (k < target) memoTable[n][target] = 0;
                    else memoTable[n][target] = 1;
                } else {

                    int possibleWays = 0;

                    for (int kCurrent = 1; kCurrent <= k; kCurrent++) {
                        if (target - kCurrent > 0)
                            possibleWays = (possibleWays + recursiveSeeker(n - 1, k, target - kCurrent)) % modulo;
                        else break;
                    }

                    memoTable[n][target] = possibleWays;
                }

            }
        }

        return memoTable[n][target];
    }
}
