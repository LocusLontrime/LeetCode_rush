package Leet_code_rush.Math;

import java.util.Arrays;

public class Find_Three_Consecutive_Integers_That_Sum_to_a_Given_Number_2177 { /** accepted (speed: 0ms, fast) **/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfThree(33)));
    }

    public static long[] sumOfThree(long num) {

        if (num % 3 != 0) return new long[] {};
        long k = num / 3 - 1;
        return new long[]{k, k + 1, k + 2};

    }

}
