package SeminarsJavaCore.HomeWork3;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class nQueens {

    public static int N;
    public static Set<Set<Pair<Integer, Integer>>> set = new HashSet<>();

    public static void main(String[] args) {

        System.out.println("All placements number: " + TotalNQueens(8) + "\n");

        System.out.println("All placements Queens coordinates:\n");

        int counter = 1;
        for (Set<Pair<Integer, Integer>> set : set)
        {
            System.out.print("Partition number " + counter++ + ": ");
            for (Pair<Integer, Integer> pair: set) System.out.print("(" + pair.getKey() + "," + pair.getValue() + ") ");
            System.out.println();
        }
    }

    public static int TotalNQueens(int n)
    {
        N = n;

        System.out.println("N = " + N);

        return RecursiveSeeker(0, new ArrayList<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
    }

    public static int RecursiveSeeker(int row, ArrayList<Integer> verticalSet, HashSet<Integer> diag1Set, HashSet<Integer> diag2Set) // List (it is ordered) -> only for printing
    // the placements queens coordinates
    {
        if (row == N) {
            Set<Pair<Integer, Integer>> currSet = new HashSet<Pair<Integer, Integer>>();

            int currRow = 0;
            for (int i : verticalSet) currSet.add(new Pair<Integer, Integer>(currRow++, i));

            set.add(currSet);

            return 1;
        }

        int count = 0;

        for (int i = 0; i < N; i++)
        {
            if (!verticalSet.contains(i) && !diag1Set.contains(row + i) && !diag2Set.contains(row - i)) {

                verticalSet.add(i);
                diag1Set.add(row + i);
                diag2Set.add(row - i);

                count += RecursiveSeeker(row + 1, verticalSet, diag1Set, diag2Set);

                verticalSet.remove((Integer) i);
                diag1Set.remove(row + i);
                diag2Set.remove(row - i);
            }
        }

        return count;
    }
}
