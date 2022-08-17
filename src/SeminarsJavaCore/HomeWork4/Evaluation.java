package SeminarsJavaCore.HomeWork4;

import java.util.*;

public class Evaluation {

    // sets for possible symbols storing
    public static Set<Character> numbers = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    public static Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    public static Set<Character> ops = new HashSet<>(Arrays.asList('%', '^', '*', '/', '+', '-'));

    public static Map<String, Double> constants = new HashMap<String, Double>() {{ // constants-collection, can be extended

        put("pi", Math.PI);
        put("e", Math.E);
        put("phi", (Math.sqrt(5) + 1) / 2);

    }};

    public static Map <Character, Integer> opsPriority = new HashMap<Character, Integer>() {{ // word-operators-collection, can be extended
        // (do not forget to extend evalWordOperator() method too

        put('%', 5);
        put('^', 4);
        put('*', 3);
        put('/', 3);
        put('+', 2);
        put('-', 2);
        put('(', 1);

    }};

    public static void main(String[] args) { // tests and so on

        List<Object> list = infixToPostfix("6 ^ 10 % 6 - 7 / 7 + 9"); // works without words-operators like a usual infix-to-postfix translator

        for (Object o : list) System.out.print(o + " ");
        System.out.println();

        System.out.println(evaluatePostfixExpression(list));

        System.out.println(Double.parseDouble("989"));

        System.out.println(evaluate("(2^3 * (10 / (5 - 3)))^(Sin(Pi))"));

        System.out.println(evaluate("Sin(Pi)"));

        System.out.println(evaluate("log(200000 - 100000) / 7.99 + 2 ^ 3 * cosh(sin(9.989 * pi) + abs(1.1989 - 2.19898))")); // something more difficult

        // System.out.println(numbers.contains(' '));

    }

    public static double evaluate(String expression) { // evaluate a mathematical expression with operators and constants
        return evaluatePostfixExpression(infixToPostfix(expression));
    }

    // translates a simple infix structure to postfix one, but if there is operators like sin, log and so on ->
    // this method simplifies the expression by evaluating all the ops recursively
    public static List<Object> infixToPostfix(String mathExpression) {

        int index = 0; // the main cycling index
        mathExpression = mathExpression.trim().toLowerCase(); // for the further convenience
        int eLength = mathExpression.length();

        Stack<Character> operatorsStack  = new Stack<>(); // stack for simple operators like: %^*/+-
        List<Object> postfixArray = new ArrayList<>(); // for building the postfix variant of the expression given (Strings and Doubles)

        char currChar; // current character of the expression
        StringBuilder currNumber; // var for building numbers from the math expression
        StringBuilder currOperator; // var for building word-operators from the math expression

        // building a list of tokens for defining the postfix notation and doing some further calculations
        while(index < eLength) {

            currChar = mathExpression.charAt(index);
            currNumber = new StringBuilder();
            currOperator = new StringBuilder();

            if (alphabet.contains(currChar)) { // words-operators like: log
                while (alphabet.contains(currChar)) { // builds the operator from chars

                    currOperator.append(currChar);
                    index++;
                    if (index == eLength) break;
                    currChar = mathExpression.charAt(index);
                }

                String currOpStr = currOperator.toString(); // prevents three times called method .toString() for StringBuilder element

                if (constants.containsKey(currOpStr)) { // if the current operator is just a math constant

                    postfixArray.add(constants.get(currOpStr));

                }
                else { // defines the beginning and end of the operator's parenthesis

                    int parenthesesCounter = 1;
                    int newIndex = ++index;

                    while (parenthesesCounter > 0) {
                        if (mathExpression.charAt(newIndex) == '(') parenthesesCounter++;
                        else if (mathExpression.charAt(newIndex) == ')') parenthesesCounter--;
                        newIndex++;
                    }

                    // evaluates the operator by recursively calling of the evaluatePostfixExpression(expr) = evaluatePostfixExpression(infixToPostfix(expr))
                    // method for the substring of mathExpression...
                    double operatorAppliedValue = evalWordOperator(currOpStr, evaluate(mathExpression.substring(index, newIndex - 1)));

                    postfixArray.add(operatorAppliedValue);
                    index = newIndex;
                }
            } else if (numbers.contains(currChar)) { // numbers (int or double), but finally all numbers will have a double type

                // building the number from chars
                while (numbers.contains(currChar) || currChar == '.') {

                    currNumber.append(currChar);
                    index++;
                    if (index == eLength) break;
                    currChar = mathExpression.charAt(index);
                }

                // parsing to the double type
                double num = Double.parseDouble(currNumber.toString());

                postfixArray.add(num);

            } else if (currChar == '(') { // parentheses part

                operatorsStack.push(currChar);
                index++;

            } else if (currChar == ')') {

                Character topToken = operatorsStack.pop();

                // error of an Object type and instance of operator been fixed
                while(topToken != '(') {

                    postfixArray.add(topToken);
                    topToken = operatorsStack.pop();
                }

                index++;
            }
            else if (ops.contains(currChar)){ // operators like: %^*/+-

                while (!operatorsStack.empty() && opsPriority.get(operatorsStack.peek()) >= opsPriority.get(currChar)) {

                    postfixArray.add(operatorsStack.pop());
                }

                operatorsStack.push(currChar);
                index++;

            } else if (currChar == ' ') { // spaces

                index++;

            } else { // some unexpected symbols
                System.out.println("Expression is invalid!");
                return null; // mb throw an Exception...
            }
        }

        while(!operatorsStack.empty()) { // adds all the operators from stack to the postfix expression

            postfixArray.add(operatorsStack.pop());
        }

        return postfixArray;
    }

    // now, when we have the list of postfix expression we can easily evaluate it
    public static double evaluatePostfixExpression(List<Object> postfixExpression) {

        Stack<Double> operandsStack  = new Stack<>();

        // cycling through the expression
        for (Object token : postfixExpression) {

            if (token instanceof Double) {

                operandsStack.push((Double) token);

            } else {

                // reversed operands' couple
                double secondOp = operandsStack.pop();
                double firstOp = operandsStack.pop();

                // evaluating
                double res = eval(token, firstOp, secondOp);
                operandsStack.push(res);
            }
        }

        // returns the last value in stack
        return operandsStack.pop();
    }

    // evaluates the common math operators
    public static double eval(Object token, double op1, double op2) {

        Character operator = (Character) token;

        double res;

        switch (operator) {
            case '%':
                res = op1 % op2;
                break;
            case '^':
                res = Math.pow(op1, op2);
                break;
            case '/':
                res = op1 / op2;
                break;
            case '*':
                res = op1 * op2;
                break;
            case '+':
                res = op1 + op2;
                break;
            case '-':
                res = op1 - op2;
                break;
            default:
                System.out.println("error");
                res = -1;
        }

        return res;
    }

    // evaluates the math operators like log and sin
    public static double evalWordOperator(String wordOperator, double value) {

        double res;

        switch (wordOperator) {
            case "log":
                res = Math.log10(value);
                break;
            case "ln":
                res = Math.log(value);
                break;
            case "log2":
                res = Math.log(value) / Math.log(2);
                break;
            case "sin":
                res = Math.sin(value);
                break;
            case "cos":
                res = Math.cos(value);
                break;
            case "tan":
                res = Math.tan(value);
                break;
            case "ctg":
                res = Math.cos(value) / Math.sin(value);
                break;
            case "asin":
                res = Math.asin(value);
                break;
            case "acos":
                res = Math.acos(value);
                break;
            case "atan":
                res = Math.atan(value);
                break;
            case "sinh":
                res = Math.sinh(value);
                break;
            case "cosh":
                res = Math.cosh(value);
                break;
            case "tanh":
                res = Math.tanh(value);
                break;
            case "ctgh":
                res = Math.cosh(value) / Math.sinh(value);
                break;
            case "abs":
                res = Math.abs(value);
                break;
            default:
                System.out.println("The unknown operator");
                // mb throw an Exception?
                res = -1; // it is not important what to return in this case
        }

        return res;
    }
}
