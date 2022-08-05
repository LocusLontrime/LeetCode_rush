package SeminarsJavaCore.HomeWork1;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("  the sky is blue "));
    }

    public static String reverseWords(String s) {

        s = s.trim(); // removing the beginning and the ending spaces of String s
        String currW = "";
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') currW = s.charAt(i) + currW;
            else {
                result += !currW.equals("") ? currW + " " : "";
                currW = "";
            }
        }

        return result + currW;
    }
}
