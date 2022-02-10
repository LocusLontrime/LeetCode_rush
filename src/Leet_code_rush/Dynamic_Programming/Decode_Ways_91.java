package Leet_code_rush.Dynamic_Programming;

public class Decode_Ways_91 { /** accepted, best time 157ms **/

    static char[] chars;
    static int[] array;

    static int[] memo_table;

    public static void main(String[] args) {

        String s = "111111111111111111111111111111111111111111111";

        long start = System.nanoTime();

        System.out.println(numDecodings(s));

        long finish1 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start) / 1000 + " microsec");

        System.out.println(Integer.MAX_VALUE);

    }

    public static int numDecodings(String s) {

        chars = s.toCharArray();

        array = new int[chars.length];
        memo_table = new int[chars.length];

        for (int i = 0; i < chars.length; i ++) array[i] = Character.getNumericValue(chars[i]);

        if (array[0] == 0) return 0;

        return dp (array.length - 1);

    }

    public static int dp (int i) {

        int dp2, dp1;

        if (i == 0) return 1;
        if (i == 1) {

            int temp = array[0] * 10 + array[1];

            if (array[1] == 0 && array[0] > 2) return 0;
            else if (temp >= 11 && temp <= 26 && temp != 20) return 2;
            else return 1;

        }

        if (memo_table[i] == 0) {

            int temp = array[i - 1] * 10 + array[i];

            if (array[i] == 0 && array[i - 1] == 0) return 0; // проврека на 2 нуля - конец return 0

            if (array[i] == 0 && !(array[i - 1] == 1 || array[i - 1] == 2))
                return 0; // проверка на 2+ цифру и ноль - конец return 0

            if (temp >= 10 && temp <= 26) dp2 = dp(i - 2); // проверка на существование dp(i - 2) 10 <= symbol <= 26
            else dp2 = 0;

            if (array[i] != 0) dp1 = dp(i - 1); // проверка на существование dp(i - 1) когда не нулевой символ
            else dp1 = 0;

            memo_table[i] = dp1 + dp2;

        }

        return memo_table[i];

    }

}
