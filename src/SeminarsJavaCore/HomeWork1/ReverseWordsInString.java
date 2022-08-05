package SeminarsJavaCore.HomeWork1;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        s = s.trim();

        String[] words = s.split("\\s+");
        reverseWordsArray(words);

        return String.join(" ", words);
    }

    public static void reverseWordsArray(String[] ws) {

        for (int i = 0; i <= (ws.length - 1) / 2; i++) {
            String tempChar = ws[i];
            ws[i] = ws[ws.length - 1 - i];
            ws[ws.length - 1 - i] = tempChar;
        }
    }
}
