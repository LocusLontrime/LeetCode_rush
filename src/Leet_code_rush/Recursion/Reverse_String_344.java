package Leet_code_rush.Recursion;

import java.util.Arrays;

public class Reverse_String_344 { /** accepted **/

    public static void main(String[] args) {

        String s = "ses"; //"hello";

        char[] chars = s.toCharArray();

        reverseString(chars);

        s = Arrays.toString(chars);

        System.out.println("Reversed s = " + s);

    }

    public static void reverseString(char[] s) {

        recursive_swap(s,0, s.length - 1); // here recursion starts

    }

    public static void recursive_swap (char[] s, int i, int j) {

        if (i >= j) return;

        char temp;

        temp = s[i]; //swapping
        s[i] = s[j];
        s[j] = temp;

        recursive_swap(s, ++i, --j);

    }

}
