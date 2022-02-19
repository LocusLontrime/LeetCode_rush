package Leet_code_rush.Hash_Table;

import java.util.HashSet;

public class Palindrome_Permutation_266 {

    public static void main(String[] args) { /** accepted (speed: 0ms, fast) **/

        String s = "aabbcctttffff";

        System.out.println(canPermutePalindrome(s));


    }

    public static boolean canPermutePalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        Character ch;

        for (int i = 0; i < s.length(); i++) {

            ch = s.charAt(i);

            if (set.contains(ch)) set.remove(ch);
            else set.add(ch);

        }

        return set.size() <= 1;
    }

}
