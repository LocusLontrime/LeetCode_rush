package Leet_code_rush.Two_Pointers;

public class Implement_strStr_28 {

    public static void main(String[] args) {

        String s1 = "mississippi"; // sliding window rush (dynamic)
        String s2 = "issip";

        System.out.println(strStr(s1, s2));

        System.out.println(strStr_1(s1, s2));

        System.out.println();

    }

    public static int strStr(String haystack, String needle) { /** accepted (speed: 2656ms, ultra-low) **/

        if (needle.equals("")) return 0;

        if (haystack.equals("")) return -1;

        boolean flag;

        for (int i = 0; i + needle.length() <= haystack.length(); i ++) {

            flag = true;

            for (int j = 0; j < needle.length(); j ++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) return i;
        }

        return -1;
    }

    public static int strStr_1 (String haystack, String needle) {

        if (needle.equals("")) return 0;

        if (haystack.equals("")) return -1;

        boolean flag1 = false;

        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        if (needle.length() == 1) {

            for (int i = 0; i < haystack.length(); i ++) {

                if (chars1[i] == chars2[0]) return i;

            }

            return -1;
        }

        int sec_pointer = 1;


        for (int i = 0; i < haystack.length(); i ++) {

            if (flag1) {

                if (sec_pointer == chars2.length) return i - chars2.length;

                if (chars1[i] == chars2[sec_pointer]) sec_pointer++;
                else {
                    flag1 = false;
                    sec_pointer = 1;
                }
            }

            if (chars1[i] == chars2[0]) flag1 = true;
        }

        System.out.println("lala");

        if (sec_pointer == chars2.length) return haystack.length() - chars2.length;

        System.out.println("sec_pointer = " + sec_pointer);

        return -1;
    }
}
