package Leet_code_rush.Two_Pointers;

public class Reverse_Words_in_a_String_III_557 {

    public static void main(String[] args) {

        String s = "Fafalala gets Tutufufu";

        s = "Let's take LeetCode contest"; //"God Ding"

        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {

        String[] strings = s.split(" ");
        String result = "";

        for (int i = 0; i < strings.length; i ++) {

            if (i != strings.length - 1) result = result.concat(reverseString(strings[i]) + " ");
            else result = result.concat(reverseString(strings[i]));

        }

        return result;
    }

    public static String reverseString(String s) {

        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result = result.concat(String.valueOf(s.charAt(i)));
        }

        return result;

    }

}
