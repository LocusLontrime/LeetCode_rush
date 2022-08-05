package SeminarsJavaCore;

import java.util.ArrayList;

public class Combinations {
    public static ArrayList<String> combs;

    public static void main(String[] args) {
        getCombsRec(4, 5);
        printCombs();
    }

    // preparation to an upcoming Seminar
    public static ArrayList<String> getCombsRec(int n, int k) {
        combs = new ArrayList<>();
        recursiveSeeker("", n, k);
        return combs;
    }

    public static void recursiveSeeker(String currStr,int n, int k) {
        if (currStr.length() == n) combs.add(currStr);
        else for (int i = 0; i < k; i ++) recursiveSeeker(currStr + i, n, k);
    }

    public static void printCombs() {
        for (String s : combs) System.out.println(s);
    }
}
