package Leet_code_rush.Two_Pointers;

public class strStr {

    public static void main(String[] args) {
        String s1 = "mississippi"; // sliding window rush (dynamic)
        String s2 = "issip";

        s1 = "l";
        s2 = "l";

        System.out.println(strStr(s1, s2));
    }

    public static int strStr(String haystack, String needle) { /** accepted (speed: 1ms, ultra-fast, beats 99,91% submissions) **/

        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        if(needle.length() > haystack.length()) return -1;

        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        int length1 = haystack.length();
        int length2 = needle.length();

        int pointer_haystack;
        int pointer_needle;

        for (int i = 0; i + length2 <= length1; i ++ ) {

            if (chars1[i] == chars2[0] && chars1[i + length2 - 1] == chars2[length2 - 1]) {

                if (length2 == 1) return i;

                pointer_haystack = i;
                pointer_needle = 0;

                while (chars1[pointer_haystack] == chars2[pointer_needle]) {

                    pointer_haystack++;
                    pointer_needle++;

                    if (pointer_needle == length2 - 1) return i;

                }

                //if (pointer_needle == length2 - 1) return i;

            }

        }

        return -1;
    }
}
