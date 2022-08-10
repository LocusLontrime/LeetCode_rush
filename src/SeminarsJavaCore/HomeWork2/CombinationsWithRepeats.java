package SeminarsJavaCore.HomeWork2;
import java.util.ArrayList;
import java.util.List;

public class CombinationsWithRepeats {
    public static List<List<Integer>> combs;

    public static void main(String[] args) {
        combineWithRepeats(5, 3);
        printCombs();
    }

    public static List<List<Integer>> combineWithRepeats (int n, int k) {
        combs = new ArrayList<List<Integer>>();
        recursiveSeekerRepeats(new ArrayList<Integer>(), n, k, 1);
        return combs;
    }

    public static void recursiveSeekerRepeats(ArrayList<Integer> currComb, int n, int k, int prevElem) {
        if (currComb.size() == k) combs.add(new ArrayList<Integer>(currComb));

        else for (Integer i = prevElem; i <= n; i++) {
            ArrayList<Integer> newCombs = new ArrayList<Integer>(currComb);
            newCombs.add(i);
            recursiveSeekerRepeats(newCombs, n, k, i);
        }
    }

    public static void printCombs() {
        for (List<Integer> list : combs) {
            for (Integer number : list) System.out.print(number);
            System.out.println();
        }
    }
}
