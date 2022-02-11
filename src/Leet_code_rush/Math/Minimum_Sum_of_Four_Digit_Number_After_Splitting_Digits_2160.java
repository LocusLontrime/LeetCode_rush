package Leet_code_rush.Math;

import java.util.Arrays;

public class Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits_2160 { /** accepted (speed: fast enough) **/

    public static void main(String[] args) {

        System.out.println(minimumSum(2932)); // 27 + 69 // 2679 // 1018

    }

    public static int minimumSum(int num) {

        int[] ints = new int[4];

        ints[3] = num % 10; num /=10;
        ints[2] = num % 10; num /=10;
        ints[1] = num % 10; num /=10;
        ints[0] = num % 10;

        Arrays.sort(ints);

        System.out.println(Arrays.toString(ints));

        return ints[0] * 10 + ints[2] + ints[1] * 10 + ints[3];

    }

}
