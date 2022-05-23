package Code_wars_rush;

public class Longest_Common_Subsequence_5kyu { // LL 36 366 98 989 accepted on codewars

    public static String[][] memoTable; // can be upgraded to StringBuilder

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println(lcs("abcdefatt", "bdeffzat"));
        System.out.println(lcs("abcdefabcdefamyytttabcdefghhfdhdfgdsijklmnabcdasfdsgtrjyqqvmnefghijklmnopqabcdefghijklmnopqopqabcdefg" +
                        "hijklmnopqabcdefghijklmnopqabcdefabcdefattabcdefghijklmnrtykvcbvabcdefghijklmnopqabcdefghijklmnopqopqabcdefghijklmnopqa",
                "fedcbafedcbaapcdefghijklmnobqabcdefabcdeffedcbafqweqwfxxeffttuoportwe dcbaapcdefghijklmnobqabcdefabcdeffedcbafedcbaapcd" +
                        "lmnobqabcdefabcdqwrwehbfddfdsgfdhgjyttkmnebevwecwcwvtruko9olooloyumyumtynrbervevwevrevrevrebvebtrehthyjuykiukillioloeff"));
        System.out.println(lcs("abcdef", "fedcba"));
        System.out.println(lcs("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(lcs("a", "abcdefattabcdefattabcdefattabcdefattabcdefattabcdefattabcdefattabcdefattabcdefattabcdefatt"));

        long finish = System.nanoTime();

        System.out.println("\nПрошло времени в микросекундах : " + (finish - start) / 1000);
    }

    public static String lcs(String a, String b) {

        memoTable = new String[a.length() + 1][b.length() + 1];
        memoTableFill();

        RecSeeker(a.length(), b.length(), a, b);

        return memoTable[a.length()][b.length()];
    }

    public static String RecSeeker(int i, int j, String a, String b)
    {
        if (memoTable[i][j].length() == 0)
        {
            if (i == 0 || j == 0)
            {
                return "";
            }
            else if (a.charAt(i - 1) == b.charAt(j - 1))
            {
                memoTable[i][j] = RecSeeker(i - 1, j - 1, a, b) + a.charAt(i - 1);
            }
            else
            {
                String s1 = RecSeeker(i, j - 1, a, b);
                String s2 = RecSeeker(i - 1, j, a, b);

                memoTable[i][j] = s1.length() > s2.length() ? s1 : s2;
            }
        }

        return memoTable[i][j];
    }

    public static void memoTableFill()
    {
        for (int j = 0; j < memoTable.length; j++)
        {
            for (int i = 0; i < memoTable[0].length; i++)
            {
                memoTable[j][i] = "";
            }
        }
    }
}
