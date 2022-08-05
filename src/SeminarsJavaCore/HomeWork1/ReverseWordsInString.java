package SeminarsJavaCore.HomeWork1;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        s = s.trim(); // removing the beginning and the ending spaces of String s

        String[] words = s.split("\\s+"); // splits by multiple spaces
        reverseWordsArray(words); // reverses the array of words

        return String.join(" ", words); // builds the result String from the array of words and returns it
    }

    // auxiliary method of array reversing
    public static void reverseWordsArray(String[] ws) {
        // cycling until we reach the middle point
        for (int i = 0; i <= (ws.length - 1) / 2; i++) {
            String tempChar = ws[i];
            ws[i] = ws[ws.length - 1 - i];
            ws[ws.length - 1 - i] = tempChar;
        }
    }
}
