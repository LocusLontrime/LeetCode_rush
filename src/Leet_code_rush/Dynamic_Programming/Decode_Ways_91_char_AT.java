package Leet_code_rush.Dynamic_Programming;

public class Decode_Ways_91_char_AT { /** accepted, best time 419ms, but works faster **/

    static int[] memo_table;
    static String str;

    public static void main(String[] args) {

        String s = "111111111111111111111111111111111111111111111";

        long start = System.nanoTime();

        System.out.println(numDecodings(s));

        long finish1 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start) / 1000 + " microsec");

        System.out.println(Integer.MAX_VALUE);

    }

    public static int numDecodings(String s) {

        str = s;

        memo_table = new int[str.length()];

        if (str.charAt(0) == '0') return 0;

        return dp (str.length() - 1);
    }

    public static int dp (int i) {

        int dp2, dp1;

        if (i == 0) return 1;

        if (i == 1) {

            if (str.charAt(1) == '0' && str.charAt(0) > '2') return 0;
            else if (((str.charAt(0) == '1') || (str.charAt(0) == '2' && str.charAt(1) < '7')) && str.charAt(1) != '0') return 2;

            else return 1;
        }

        if (memo_table[i] == 0) {

            if (str.charAt(i) == '0' && str.charAt(i - 1) == '0') return 0;

            if (str.charAt(i) == '0' && !(str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2')) return 0;

            if (((str.charAt(i - 1) == '1') || (str.charAt(i - 1) == '2' && str.charAt(i) < '7')) && str.charAt(i) != 0) dp2 = dp(i - 2);
            else dp2 = 0;

            if (str.charAt(i) != '0') dp1 = dp(i - 1);
            else dp1 = 0;

            memo_table[i] = dp1 + dp2;

        }

        return memo_table[i];

    }

}
