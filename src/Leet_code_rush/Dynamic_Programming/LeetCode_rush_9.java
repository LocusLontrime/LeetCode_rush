package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_rush_9 { /** accepted **/

    static String s;
    static List<String> wordDict;

    static int[] memo_table;

    //static char[] word_chars;

    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");

        long start = System.nanoTime();

        System.out.println(wordBreak(s, wordDict));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println();

    }

    /**
     *
     * @param s - a string, consisting a given word
     * @param wordDict - a dictionary of strings
     * @return true if s can be segmented into a space-separated sequence of one or more dictionary words
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation
     *
     */

    public static boolean wordBreak(String s, List<String> wordDict) {

        LeetCode_rush_9.wordDict = wordDict;
        LeetCode_rush_9.s = s;

        memo_table = new int[s.length()];

        memo_fulfilling();

        return can_the_word_be_segmented(s.length() - 1);

    }

    public static boolean can_the_word_be_segmented (int word_index) {

        boolean temp_boolean = false;

        if (memo_table[word_index] == -1) {

            for (String str : wordDict) {

                if (str.length() <= word_index + 1 && str.equals(s.substring(word_index - str.length() + 1, word_index + 1))) {

                    if (word_index - str.length() == -1) {
                        temp_boolean = true;
                        break;
                    }

                    temp_boolean = temp_boolean || can_the_word_be_segmented(word_index - str.length());
                }

            }

        }

        memo_table[word_index] = temp_boolean ? 1 : 0;

        return memo_table[word_index] == 1;

    }

    public static void memo_fulfilling () {
        Arrays.fill(memo_table, -1);
    }

}
