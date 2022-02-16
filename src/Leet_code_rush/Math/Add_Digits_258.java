package Leet_code_rush.Math;

import java.util.Arrays;

public class Add_Digits_258 { /** accepted (speed: 1ms, very fast) **/

    public static void main(String[] args) {

        System.out.println(Arrays.toString(translationToArray(9643698)));

        System.out.println(addDigits(9643698));

    }

    public static int addDigits(int num) {

        if (num < 10) return num;

        int[] array;

        while (num > 9) {

            array = translationToArray(num);

            num = 0;

            for (int i = 0; i < array.length; i ++) {
                num += array[i];
            }

        }

        return num;

    }

    public static int[] translationToArray (int number) {

        int length = (int) Math.log10(number) + 1;

        int[] digits = new int[length];

        for (int i = 0; i < length; i ++) {

            digits[length - 1 - i] = number % 10;
            number /= 10;

        }

        return digits;
    }

}
