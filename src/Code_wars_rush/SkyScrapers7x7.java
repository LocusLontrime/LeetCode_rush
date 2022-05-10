package Code_wars_rush;

import java.util.*;

public class SkyScrapers7x7 {

    private static final int SIZE = 7; // the size of skyscrapers grid

    private static int sumPows = 0;

    static {
        for (int i = 0; i < SIZE; ++i) {
            sumPows += 1 << i;
        }
    }

    private static Map<Integer, Couple<Set<Integer>>> hashTable = new HashMap<>();

    private static final int[] clues = new int[]{ 7,0,0,0,2,2,3, 0,0,3,0,0,0,0, 3,0,3,0,0,5,0, 0,0,0,0,5,0,4 };

    private static final  int[][] expectedSol = new int[][]{

            { 1,5,6,7,4,3,2 },
            { 2,7,4,5,3,1,6 },
            { 3,4,5,6,7,2,1 },
            { 4,6,3,1,2,7,5 },
            { 5,3,1,2,6,4,7 },
            { 6,2,7,3,1,5,4 },
            { 7,1,2,4,5,6,3 }

    };


    public static void main(String[] args) {

        System.out.println(sumPows);

        ckeckSolution();

    }

    private static void ckeckSolution() { // test case

        assertEquals(SkyScrapers7x7.solvePuzzle(clues), expectedSol);

    }


    public static int[][] solvePuzzle(int[] clues) { // the main method of solving the puzzle

        List<Set<Integer>> rowSets = new ArrayList<>(SIZE);
        List<Set<Integer>> colSets = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; ++i) {

            Set<Integer> leftToRight = getSetOfCombs(clues[4 * SIZE - 1 - i]).left;
            Set<Integer> rightToLeft = getSetOfCombs(clues[SIZE + i]).right;
            rowSets.add(isIntersected(leftToRight, rightToLeft));

            Set<Integer> topToBottom = getSetOfCombs(clues[i]).left;
            Set<Integer> bottomToTop = getSetOfCombs(clues[3 * SIZE - 1 - i]).right;
            colSets.add(isIntersected(topToBottom, bottomToTop));
        }

        int[][] board = new int[SIZE][SIZE];
        int[][] vars = new int[SIZE * SIZE][];

        long varCount;

        while (true) {

            varCount = 1;

            for (int r = 0; r < SIZE; ++r) {

                for (int c = 0; c < SIZE; ++c) {

                    int ind = r * SIZE + c;
                    int[] arr;

                    Set<Integer> rowVars = getDiffVars(rowSets.get(r), c);
                    Set<Integer> columnVars = getDiffVars(colSets.get(c), r);
                    Set<Integer> merged = isIntersected(rowVars, columnVars);

                    if (merged.size() == 0) {
                        throw new RuntimeException("merged is empty");
                    }

                    arr = new int[merged.size()];

                    int i = 0;

                    for (Integer val : merged) {
                        arr[i++] = val;
                    }

                    vars[ind] = arr;
                    board[r][c] = vars[ind][0];
                    varCount *= arr.length;
                }
            }

            boolean changed = false;

            for (int i = 0; i < SIZE * SIZE; ++i) {

                int[] legal = vars[i];
                int row = i / SIZE;
                int col = i % SIZE;

                Set<Integer> values = rowSets.get(row);
                Set<Integer> fixed = excludeNotValidOnes(values, legal, col);

                if (fixed.size() < values.size()) {
                    rowSets.set(row, fixed);
                    changed = true;
                }

                values = colSets.get(col);
                fixed = excludeNotValidOnes(values, legal, row);

                if (fixed.size() < values.size()) {
                    colSets.set(col, fixed);
                    changed = true;
                }
            }

            if (! changed) break;
        }

        // We assume all tests will cause only single solution (i.e. variantCount == 1).
        // But just in case I do check all possibilities.
        if (varCount > 1) {

            System.out.println("Variants to more then 1: " + varCount);

            LineOfCells[] lines = getLines(clues, board);

            int[] counter = new int[SIZE * SIZE];
            boolean changed = true;

            while (changed && !isGood(lines)) {

                changed = false;

                for (int i = SIZE * SIZE - 1; i >= 0; i--) {

                    int limit = vars[i].length - 1;

                    if (counter[i] == limit) {
                        counter[i] = 0;
                        board[i / SIZE][i % SIZE] = vars[i][0];
                    } else {
                        counter[i]++;
                        board[i / SIZE][i % SIZE] = vars[i][counter[i]];
                        changed = true;
                        break;
                    }
                }
            }

            if (!changed) {
                throw new RuntimeException("Not found solution");
            }
        }

        System.out.println("Solution:\n" + toString(board));

        return board;
    }

    private static Set<Integer> excludeNotValidOnes(Set<Integer> values, int[] legal, int digitIndex) { // ones that located not in the right position

        Set<Integer> result = new HashSet<>();

        for (Integer val : values) {

            int digit = (val >> (digitIndex * 3)) & 7;
            boolean isLegal = false;

            for (int i = 0; i < legal.length; ++i) {

                if (digit == legal[i]) {
                    isLegal = true;
                    break;
                }
            }
            if (isLegal) {
                result.add(val);
            }
        }
        return result;
    }

    private static Set<Integer> getDiffVars(Set<Integer> integers, int index) {

        Set<Integer> result = new HashSet<>();

        for (Integer val : integers) {

            int digit = (val >> (index * 3)) & 7;

            result.add(digit);
        }
        return result;
    }

    private static boolean isGood(LineOfCells[] lines) {

        for (int i = 0; i < lines.length; i++) {

            if (!lines[i].isValid()) return false;

        }
        return true;
    }

    private static LineOfCells[] getLines(int[] clues, int[][] board) {

        LineOfCells[] lines = new LineOfCells[4 * SIZE];

        int index = 0;

        for (int c = 0; c < SIZE; ++c) {

            lines[index] = new LineOfCells(board, clues[index]);
            lines[3 * SIZE - 1 - index] = new LineOfCells(board, clues[3 * SIZE - 1 - index]);

            for (int r = 0; r < SIZE; ++r) {

                lines[index].setCell(r, r, c);
                lines[3 * SIZE - 1 - index].setCell(r, SIZE - 1 - r, c);
            }

            index++;
        }
        for (int r = 0; r < SIZE; ++r) {

            lines[index] = new LineOfCells(board, clues[index]);
            lines[5 * SIZE - 1 - index] = new LineOfCells(board, clues[5 * SIZE - 1 - index]);

            for (int c = 0; c < SIZE; ++c) {

                lines[index].setCell(c, r, SIZE - 1 - c);
                lines[5 * SIZE - 1 - index].setCell(c, r, c);
            }

            index++;
        }

        return lines;
    }

    private static Set<Integer> isIntersected(Set<Integer> a, Set<Integer> b) {

        Set<Integer> result = new LinkedHashSet<>();

        for (Integer val : a) {
            if (b.contains(val)) {
                result.add(val);
            }
        }

        return result;
    }

    private static Couple<Set<Integer>> getSetOfCombs(int skyScrapers) {

        if (hashTable.containsKey(skyScrapers)) return hashTable.get(skyScrapers);

        Couple<ArrayList<Integer>> combinations = calcCombinations(skyScrapers);

        hashTable.put(skyScrapers, new Couple<>(new LinkedHashSet<>(combinations.left), new LinkedHashSet<>(combinations.right)));

        return hashTable.get(skyScrapers);
    }

    private static Couple<ArrayList<Integer>> calcCombinations(int skyScrapers) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> resultInv = new ArrayList<>();

        int[] temp3 = new int[SIZE];
        int[] temp = new int[SIZE];

        while (true) {
            for (int i = 0; i < SIZE; ++i) {
                temp[i] = i + 1;
            }

            int value = 0;
            int valueInv = 0;
            int max = 0;
            int visible = 0;

            for (int i = 0; i < SIZE && (visible <= skyScrapers || skyScrapers == 0); ++i) {

                int index = temp3[i];

                for (int j = 0; j < SIZE; ++j) {

                    if (temp[j] > 0) {

                        if (index == 0) {

                            if (temp[j] > max) {

                                max = temp[j];
                                visible++;

                                if (skyScrapers > 0 && visible > skyScrapers) {
                                    break;
                                }
                            }

                            value |= temp[j] << (3 * i);
                            valueInv |= temp[j] << (3 * (SIZE - 1 - i));
                            temp[j] = 0;

                            break;
                        } else {
                            index--;
                        }
                    }
                }
            }

            if (skyScrapers == 0 || visible == skyScrapers) {
                result.add(value);
                resultInv.add(valueInv);
            }

            boolean advanced = false;

            for (int i = SIZE - 1; i >= 0; i--) {

                int limit = SIZE - 1 - i;

                if (temp3[i] < limit) {

                    temp3[i]++;
                    advanced = true;

                    break;
                } else {
                    temp3[i] = 0;
                }
            }

            if (!advanced) break;
        }

        return new Couple<>(result, resultInv);
    }

    private static class LineOfCells {
        private int[] cells = new int[SIZE];
        private int skyScrapers;
        private int[][] board;

        public LineOfCells(int[][] board, int skyScrapers) {
            this.skyScrapers = skyScrapers;
            this.board = board;
        }

        public void setCell(int index, int row, int column) {

            cells[index] = row * 10 + column;

        }

        public int get(int cellIndex) {

            return board[getRow(cells[cellIndex])][getColumn(cells[cellIndex])];

        }

        public void set(int cellIndex, int val) {

            board[getRow(cells[cellIndex])][getColumn(cells[cellIndex])] = val;

        }

        private int getRow(int index) {

            return index / 10;

        }

        private int getColumn(int index) {

            return index % 10;

        }

        public boolean isValid() {

            int max = 0;
            int visible = 0;
            int magicSum = 0;

            for (int i = 0; i < SIZE; ++i) {

                int height = get(i);

                if (height > max) {
                    visible++;
                    max = height;
                }

                magicSum += 1 << (height - 1);
            }

            return magicSum == sumPows && (skyScrapers == 0 || visible == skyScrapers);
        }
    }

    private static void assertEquals(int[][] actual, int[][] expected) {

        if (actual.length != expected.length) throw new RuntimeException("Different lengths");

        for (int r = 0; r < actual.length; ++r) {

            if (actual[r].length != expected[r].length) throw new RuntimeException("Different row lengths, row: " + r);

            for (int c = 0; c < actual[r].length; ++c) {

                if (actual[r][c] != expected[r][c]) {

                    throw new RuntimeException("Arrays are different!\nActual:\n"
                            + toString(actual) + "\nExpected:\n" + toString(expected));
                }
            }
        }
    }

    private static String toString(int[][] a) {

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < a.length; ++r) {

            for (int c = 0; c < a[r].length; ++c) {

                if (c > 0) sb.append(" ");

                sb.append(a[r][c]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static class Couple<T> { // Generic class -> Couple of two objects

        public T left;
        public T right;

        public Couple(T left, T right) {
            this.left = left;
            this.right = right;
        }
    }
}
