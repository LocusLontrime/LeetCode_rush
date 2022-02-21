package Leet_code_rush.Math;

public class Count_Integers_With_Even_Digit_Sum_2180 { /** accepted (speed: 2ms, fast) **/

    public static void main(String[] args) {

        // System.out.println((int) Math.log10(24));

        System.out.println(countEven(30));

    }

    public static int countEven(int num) {

        int counter = 0;

        for (int i = 1; i <= num; i++) {

            int length = (int) Math.log10(i) + 1;
            int currentNum = i;
            int sum = 0;

            for (int j = 0; j < length; j++) {
                sum += currentNum % 10;
                currentNum /= 10;
            }

            if (sum %2 == 0) counter++;

        }

        return counter;
    }
}
