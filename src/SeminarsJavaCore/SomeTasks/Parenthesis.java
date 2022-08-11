package SeminarsJavaCore.SomeTasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {

    private static Map<Character, Integer> openings = new HashMap<Character, Integer>() {{
        put('(', 1);
        put('[', 2);
        put('{', 3);
        put('〈', 4);
    }};

    private static Map<Character, Integer> closing = new HashMap<Character, Integer>() {{
        put(')', 1);
        put(']', 2);
        put('}', 3);
        put('〉', 4);
    }};


    public static void main(String[] args) {

        System.out.println(isParenthesisCorrect("([{}])"));

        System.out.println(isParenthesisCorrect("{([)[](])}"));
    }

    public static boolean isParenthesisCorrect(String expression) {

        Stack<Integer> parenthesisStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            Character currCh = expression.charAt(i);

            if (openings.containsKey(currCh)) {

                parenthesisStack.add(openings.get(currCh));

            } else if (closing.containsKey(currCh)) {

                if (parenthesisStack.size() > 0 && parenthesisStack.peek() == closing.get(currCh)) {
                    parenthesisStack.pop();
                }

                else return false;
            }
        }

        return parenthesisStack.size() == 0;
    }
}
