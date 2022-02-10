package Leet_code_rush.Two_Pointers;
public class Implement_strStr_28_2th_solution {

    public static void main(String[] args) {
        String s1 = "mississippi"; // sliding window rush (dynamic)
        String s2 = "issip";

        System.out.println(strStr(s1, s2));
    }

    public static int strStr(String haystack, String needle) { /** accepted (speed: 1181ms, low) **/

        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        if(needle.length() > haystack.length()) return -1;

        int left_pointer = 0;
        int right_pointer = 0;

        while (right_pointer < haystack.length()) {

            if (haystack.substring(left_pointer, right_pointer + 1).equals(needle.substring(0, right_pointer -left_pointer + 1))) {
                if (right_pointer - left_pointer == needle.length() - 1) return left_pointer;
                right_pointer++;
            } else {
                if (left_pointer < right_pointer) left_pointer++;
                else {
                    left_pointer++;
                    right_pointer++;
                }
            }
        }
        return -1;
    }
}
