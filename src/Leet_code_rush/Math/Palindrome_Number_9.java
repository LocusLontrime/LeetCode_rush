package Leet_code_rush.Math;

public class Palindrome_Number_9 {

    public static void main(String[] args) {

        System.out.println(isPalindrome_string_method(156797651));
        System.out.println(isPalindrome(156797651));
        System.out.println(isPalindrome_fast(0));
    }

    public static boolean isPalindrome_string_method (int x) { /** accepted, but a kind of cheating **/

        String s = Integer.toString(x);

        for (int i = 0; 2 * i < s.length(); i ++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }

    public static boolean isPalindrome (int x) { /** accepted (speed: slow) **/

        if (x < 0) return false;
        if (x == 0) return true;

        int length = (int) Math.log10(x) + 1;
        int [] array = new int[length];

        for (int i = 0; i < length; i ++) {
            array[i] = x % 10;
            System.out.print(array[i] + " ");
            x /= 10;
        }

        for (int i = 0; i < length; i ++) {

            if (array[i] != array[length - 1 - i]) return false;

        }

        return true;
    }

    public static boolean isPalindrome_fast (int x) { /** accepted (speed: average) **/

        if (x < 0) return false;
        if (x == 0) return true;

        int length = (x + "").length();

        int initial_number = x;
        int reversed_number = 0;


        for (int i = 0; i < length; i ++) {
            reversed_number += (x % 10);
            if (i != length - 1) reversed_number *= 10;
            x /= 10;
        }

        System.out.println(reversed_number + " " + initial_number);

        return reversed_number == initial_number;

    }

}
