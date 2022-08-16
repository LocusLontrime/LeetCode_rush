package SeminarsJavaCore.SomeTasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewTask { // Маркуша

    private static List<String> clones;

    private static final Map<Character, Character> rusEnSameLetters = new HashMap<Character, Character>() {{

        put('а', 'a');
        put('А', 'A');
        put('р', 'p');
        put('Р', 'P');
        put('у', 'y');
        put('е', 'e');
        put('Е', 'E');
        put('о', 'o');
        put('О', 'O');
        put('В', 'B');
        put('с', 'c');
        put('С', 'C');
        put('М', 'M');

    }};

    private static final Map<Character, Character> enRusSameLetters= new HashMap<Character, Character>() {{

        put('a', 'а');
        put('A', 'А');
        put('p', 'р');
        put('P', 'Р');
        put('y', 'у');
        put('e', 'е');
        put('E', 'Е');
        put('o', 'о');
        put('O', 'О');
        put('B', 'В');
        put('c', 'с');
        put('C', 'С');
        put('M', 'М');

    }};

    public static void main(String[] args) {

        printClones(getClones("Тарелка"));
        printClones(getClones("Встреча"));

    }

    public static List<String> getClones(String s) {

        clones = new ArrayList<>();

        recursiveSeeker(s, new StringBuilder(""), 0);

        return clones;
    }

    public static void recursiveSeeker(String s, StringBuilder newS, int currIndex) {

        if (currIndex == s.length()) {
            clones.add(newS.toString());
            return;
        }

        char currCh = s.charAt(currIndex);

        recursiveSeeker(s, newS.append(currCh), currIndex + 1);
        newS.delete(newS.length() - 1, newS.length());

        if (enRusSameLetters.containsKey(currCh)) {

            recursiveSeeker(s, newS.append(enRusSameLetters.get(currCh)), currIndex + 1);
            newS.delete(newS.length() - 1, newS.length());
        }
        else if (rusEnSameLetters.containsKey(currCh)) {

            recursiveSeeker(s, newS.append(rusEnSameLetters.get(currCh)), currIndex + 1);
            newS.delete(newS.length() - 1, newS.length());
        }
    }

    public static void printClones(List<String> clones) {

        System.out.println("All possible clones of initial string: ");
        int counter = 0;

        for (String str : clones) {
            System.out.println(++counter + "-th clone: " + str);
        }
    }
}
