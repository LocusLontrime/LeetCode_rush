package Leet_code_rush.Math;

import java.util.Arrays;

public class Add_Digits_258 { /** accepted (speed: 1ms, very fast) **/

    public static void main(String[] args) {

        System.out.println(Arrays.toString(translationToArray(9643698)));

        System.out.println(addDigits(9643698));

    }

    public static int addDigits(int num) { // main method

        if (num < 10) return num;

        int[] array;

        while (num > 9) { // while number has two or more digits

            array = translationToArray(num); // auxiliary method invocation

            num = 0; // we are now using num as SUM variable

            for (int j : array) { // enhanced for
                num += j;
            }

        }

        return num;

    }

    public static int[] translationToArray (int number) { // auxiliary method for calculating array of number's digits

        int length = (int) Math.log10(number) + 1; // digits quantity defining

        int[] digits = new int[length];

        for (int i = 0; i < length; i ++) { // cycle for all digits

            digits[length - 1 - i] = number % 10;
            number /= 10;

        }

        return digits;
    }

}
