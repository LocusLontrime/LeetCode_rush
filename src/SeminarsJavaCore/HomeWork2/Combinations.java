package SeminarsJavaCore.HomeWork2;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combs;

    public static void main(String[] args) {
        combine(5, 2);
        printCombs();
    }

    public static List<List<Integer>> combine (int n, int k) {
        combs = new ArrayList<List<Integer>>();
        recursiveSeeker(new ArrayList<Integer>(), n, k, 1);
        return combs;
    }

    public static void recursiveSeeker(ArrayList<Integer> currComb, int n, int k, int prevElem) {
        if (currComb.size() == k) combs.add(new ArrayList<Integer>(currComb));

        for (Integer i = prevElem; i <= n; ++i) {
            ArrayList<Integer> newCombs = new ArrayList<Integer>(currComb);
            newCombs.add(i);
            recursiveSeeker(newCombs, n, k, i + 1);
        }
    }

    public static void printCombs() {
        for (List<Integer> list : combs) {
            for (Integer number : list) System.out.print(number);
            System.out.println();
        }
    }
}
