package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_3 { /** accepted **/

    static char[] chars1, chars2;
    static int[][] memo_lengths = new int[1001][1001];

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println("The length of the longest subsequence is " + longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
        //System.out.println("The length of the longest subsequence is " + longestCommonSubsequence("abc", "def"));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);

    }

    /**
     *
     * @param text1 - given two strings text1 and text2
     * @param text2 - a string
     * @return the length of their longest common subsequence. If there is no common subsequence, return 0
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     *
     * For example, "ace" is a subsequence of "abcde"
     * A common subsequence of two strings is a subsequence that is common to both strings
     */

    public static int longestCommonSubsequence(String text1, String text2) {

        chars1 = text1.toCharArray();
        chars2 = text2.toCharArray();

        int n1 = chars1.length - 1;
        int n2 = chars2.length - 1;

        return longest_sebseq(n1, n2);
    }

    public static int longest_sebseq (int text1_index, int text2_index) {

        if (text1_index == -1 || text2_index == -1) return 0;

        if (memo_lengths[text1_index][text2_index] == 0) {
            if (chars1[text1_index] == chars2[text2_index]) {
                memo_lengths[text1_index][text2_index] = longest_sebseq(text1_index - 1, text2_index - 1) + 1;
            } else {
                memo_lengths[text1_index][text2_index] = Math.max(longest_sebseq(text1_index, text2_index - 1), longest_sebseq(text1_index - 1, text2_index));
            }
        }
        return memo_lengths[text1_index][text2_index];
    }
}
