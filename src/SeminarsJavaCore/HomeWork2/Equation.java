package SeminarsJavaCore.HomeWork2;

import java.util.ArrayList;
import java.util.List;

public class Equation {
    private static String[] qwe;
    private static List<String> sols;

    public static void main(String[] args) {
        List<String> solutions = solveEq("2? + ?5 = 69");
        List<String> sol = solveEq("12? + ?6? = ??8");
        List<String> solut = solveEq("1?545 + 9?76 = ?2?21");
        for (String s : solutions) System.out.print(s + " | "); System.out.println("\n");
        for (String s : sol) System.out.print(s + " | "); System.out.println("\n");
        for (String s : solut) System.out.print(s + " | "); System.out.println("\n");
    }

    public static List<String> solveEq(String equation) {
        sols = new ArrayList<String>();
        String[] parts = equation.split("=");
        String[] qAndW = parts[0].split("\\+");

        qwe = new String[]{qAndW[0].trim(), qAndW[1].trim(), parts[1].trim()};

        int counter = 0;
        for (int i = 0; i < equation.length(); i++) if (equation.charAt(i) == '?') counter++;

        recursiveSeeker(new ArrayList<>(), counter, 0);

        return sols;
    }

    public static void recursiveSeeker(ArrayList<Integer> list, int maxLength, int currLength) {

        if (currLength == maxLength) {

            int index = 0;
            int[] qweNumbers = new int[]{0, 0, 0};

            for (int i = 0; i < qwe.length; i++) {
                for (int j = 0; j < qwe[i].length(); j++) {
                    qweNumbers[i] *= 10;
                    if (qwe[i].charAt(j) != '?') qweNumbers[i] += Character.getNumericValue(qwe[i].charAt(j));
                    else qweNumbers[i] += list.get(index++);
                }
            }

            if (qweNumbers[0] + qweNumbers[1] == qweNumbers[2]) {
                sols.add(qweNumbers[0] + " + " + qweNumbers[1] + " = " + qweNumbers[2]);
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            recursiveSeeker(newList, maxLength, currLength + 1);
        }
    }
}
