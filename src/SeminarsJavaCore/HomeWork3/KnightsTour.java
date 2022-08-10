package SeminarsJavaCore.HomeWork3;
import java.util.*;

public class KnightsTour { // 36 366 98 989

    private static int[][] deltas = new int[][]{{-2, -1, 1, 2, 2, 1, -1, -2}, {1, 2, 2, 1, -1, -2, -2, -1}};
    private static int[] order = new int[]{4, 0, 5, 1, 6, 2, 7, 3};
    private static int[][] adjOnes = new int[][]{{-1, 0, 1, 0}, {0, 1, 0, -1}};

    private static boolean flag;

    private static int[][] board;
    private static int boardSize;


    public static void main(String[] args) throws Exception{
        System.out.println(isValid(8, deltas[0][2], deltas[1][2]) + " " + deltas.length);
        printBoard(findKnightsTour(24)); // till 174 on even size and 155 on odd works perfectly!!!
    }

    public static int[][] findKnightsTour(int boardSize) throws Exception {

        KnightsTour.boardSize = boardSize;
        board = new int[boardSize][boardSize];
        flag = true;
        board[0][0] = 1;

        recursiveSeeker(0, 0, 1 + 1); // 55*55 size and stack over... but we know how to handle that, yeah?)

        return board;
    }

    // linear recursion with Warnsdorf's heuristic, adj and angle minimization ath the every step and backtracking
    public static void recursiveSeeker(int j, int i, int counter) throws InterruptedException { // works better, but cannot handle really big sizes...
        // needs to be run with special parameters
        if (counter == boardSize * boardSize + 1) {
            flag = false;
            return;
        }

        Map<Integer, Integer> allPossibleCells = new HashMap<>();
        for (int index = 0; index < deltas[0].length; index++) {
            if (isValid(boardSize, j + deltas[0][index], i + deltas[1][index]) && board[j + deltas[0][index]][i + deltas[1][index]] == 0) {
                allPossibleCells.put(index, nextPossibleCells(j + deltas[0][index], i + deltas[1][index]));
            }
        }

        if (allPossibleCells.size() > 0) {
            Integer minValueNext = deltas[0].length;
            Integer minValueAdj = adjOnes[0].length;
            Integer minAngleKey;

            for (Integer key : allPossibleCells.keySet()) {
                if (allPossibleCells.get(key) < minValueNext) {
                    minValueNext = allPossibleCells.get(key);
                }
            }

            Map<Integer, Integer> minNextPossCells = new HashMap<>();

            for (Integer key : allPossibleCells.keySet()) {
                if (allPossibleCells.get(key) == minValueNext) {
                    minNextPossCells.put(key, adjacentPossibleCells(j + deltas[0][key], i + deltas[1][key]));
                }
            }

            for (Integer key : minNextPossCells.keySet()) {
                if (minNextPossCells.get(key) < minValueAdj) {
                    minValueAdj = minNextPossCells.get(key);
                }
            }

            Map<Integer, Integer> minNextPossAdjCells = new HashMap<>();

            for (Integer key : minNextPossCells.keySet()) {
                if (minNextPossCells.get(key) == minValueAdj) {
                    minNextPossAdjCells.put(key, minNextPossCells.get(key));
                }
            }

            for (int k = 0; k < order.length; k++) {
                if (flag && minNextPossAdjCells.containsKey(order[k])) {
                    minAngleKey = order[k];

                    board[j + deltas[0][minAngleKey]][i + deltas[1][minAngleKey]] = counter;
                    recursiveSeeker(j + deltas[0][minAngleKey], i + deltas[1][minAngleKey], counter + 1);
                    if(flag) board[j + deltas[0][minAngleKey]][i + deltas[1][minAngleKey]] = 0;
                }
            }
        }
    }

    public static int nextPossibleCells(int currJ, int currI) { // both these methods can be simplified to one method,
        // but let them be in order to achieve a greater understandability
        int nextPossibleCells = 0;

        for (int i = 0; i < deltas[0].length; i++) {
            if (isValid(boardSize, currJ + deltas[0][i], currI + deltas[1][i]) && board[currJ + deltas[0][i]][currI + deltas[1][i]] == 0) {
                nextPossibleCells++;
            }
        }

        return nextPossibleCells;
    }

    public static int adjacentPossibleCells(int currJ, int currI) {
        int adjacentPossibleCells = 0;

        for (int i = 0; i < adjOnes[0].length; i++) {
            if (isValid(boardSize, currJ + adjOnes[0][i], currI + adjOnes[1][i]) && board[currJ + adjOnes[0][i]][currI + adjOnes[1][i]] == 0) {
                adjacentPossibleCells++;
            }
        }

        return adjacentPossibleCells;
    }

    public static boolean isValid(int boardSize, int j, int i) {
        return i >= 0 && j >= 0 && i < boardSize && j < boardSize;
    }

    public static void printBoard(int[][] board) { // prints the board in a convenient way
        int maxLength = (int) Math.log10(boardSize * boardSize) + 1;
        String[] gaps = new String[maxLength];
        String currStr = "";

        for (int i = 0; i < maxLength; i++) { // to avoid boundless concatenating of Strings in loop
            currStr += " ";
            gaps[i] = currStr;
        }

        for (int j = 0; j < board.length; j ++) {
            for (int i = 0; i < board[0].length; i++) {
                int elem = board[j][i];
                int currLength = (int) Math.log10(elem) + 1;
                System.out.print(elem + gaps[maxLength - currLength]);
            }
            System.out.println();
        }
    }

    public static void printMap(Map<Integer, Integer> map) {
        for (Integer key : map.keySet()) {
            System.out.print("{" + key + "," + map.get(key) + "} ");
        }
        System.out.println();
    }
}
