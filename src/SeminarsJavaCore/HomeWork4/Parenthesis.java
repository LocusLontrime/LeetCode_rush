package SeminarsJavaCore.HomeWork4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {

    // dictionaries for different kinds of parentheses
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

        // tests
        System.out.println(isParenthesisCorrect("([{}])"));
        System.out.println(isParenthesisCorrect("{([)[](])}"));
    }

    public static boolean isParenthesisCorrect(String expression) {

        Stack<Integer> parenthesisStack = new Stack<>(); // stack for par-nums

        for (int i = 0; i < expression.length(); i++) { // cycling all over expression given (not only parentheses can occur)

            Character currCh = expression.charAt(i);

            if (openings.containsKey(currCh)) { // if the current char is the one from the opening pars

                parenthesisStack.add(openings.get(currCh));

            } else if (closing.containsKey(currCh)) { // if the current char is the one from the closing pars

                if (parenthesisStack.size() > 0 && parenthesisStack.peek() == closing.get(currCh)) {
                    parenthesisStack.pop();
                }

                else return false;
            }
        }

        return parenthesisStack.size() == 0; // stack must be empty if the parenthesis structure is valid
    }
}
