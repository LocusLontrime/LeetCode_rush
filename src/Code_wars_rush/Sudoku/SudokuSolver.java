package Code_wars_rush.Sudoku;

import java.util.*;

public class SudokuSolver { /** DancingLinksAlgorithm -> accepted on codewars.com, incredibly fast **/

    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int NO_VALUE = 0;
    private static final int CONSTRAINTS = 4;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int COVER_START_INDEX = 1;

    private static int solutionsCounter;

    private static int[][] solution;

    private static int[][] grid;

    private static int[][] board = {
            /* {5, 0, 0, 0, 0, 0, 0, 8, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 8, 0, 9, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 7, 5, 0},
            {0, 0, 0, 7, 0, 0, 2, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 8},
            {4, 9, 0, 0, 0, 0, 0, 0, 0} */

            /* {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0} */


            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8}
    };

    public static void main(String[] args) {

        long start = System.nanoTime();

        SudokuSolver solver = new SudokuSolver(board);
        solver.solve();

        long finish = System.nanoTime();

        System.out.println("\nПрошло времени в милисекундах : " + (finish - start) / 1000 + " solCounter:");
    }

    public SudokuSolver(int[][] grid) {
        SudokuSolver.grid = grid;
    }

    public int[][] solve() {

        // invocation of IsBoardValid method
        if (!isSudokuValid(grid)) {
            throw new IllegalArgumentException();
        }

        solutionsCounter = 0;
        solution = new int[grid.length][grid[0].length]; // ???

        boolean[][] cover = initializeExactCoverBoard(grid);
        DancingLinks dlx = new DancingLinks(cover);
        dlx.runSolver();

        if (solutionsCounter != 1) // solution uniqueness criteria
        {
            throw new IllegalArgumentException();
        }

        return solution;
    }

    public static boolean isSudokuValid(int[][] board) // general check on validity
    {
        if (board.length != BOARD_SIZE) return false; // if the board has incorrect size

        for (int j = 0; j < BOARD_SIZE; j ++) {
            if (board[j].length != BOARD_SIZE) return false;
        }

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[j][i] != 0)
                {
                    if (board[j][i] < 1 || board[j][i] > 9) return false;
                }
            }
        }

        return isSudokuValidRepeats(board); // next validation method call
    }

    public static boolean isSudokuValidRepeats(int[][] board) // checks if there is any repeating numbers in row/column or square 3*3
    {
        int symbol;
        int counter_of_points = 0;

        HashSet<Integer> chars = new HashSet<Integer>(); // hash table for symbols

        //Rows

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                symbol = board[i][j];
                if (symbol != 0) chars.add(symbol);
                else counter_of_points++;
            }
            if (chars.size() + counter_of_points != 9) return false;
            chars.clear();
            counter_of_points = 0;
        }

        //Columns

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                symbol = board[j][i];
                if (symbol != 0) chars.add(symbol);
                else counter_of_points++;
            }
            if (chars.size() + counter_of_points != 9) return false;
            chars.clear();
            counter_of_points = 0;
        }

        //Squares 3x3...

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                symbol = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
                if (symbol != 0) chars.add(symbol);
                else counter_of_points++;
            }
            if (chars.size() + counter_of_points != 9) return false;
            chars.clear();
            counter_of_points = 0;
        }

        return true; // is Sudoku board valid?
    }

    public static void GetSol(int[][] solution, int[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                solution[j][i] = board[j][i];
            }
        }
    }

    public static void CopyBoardToSol(int[][] solution, int[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                solution[j][i] = board[j][i];
            }
        }
    }

    private int getIndex(int row, int column, int num) {
        return (row - 1) * BOARD_SIZE * BOARD_SIZE + (column - 1) * BOARD_SIZE + (num - 1);
    }

    private boolean[][] createExactCoverBoard() {
        boolean[][] coverBoard = new boolean[BOARD_SIZE * BOARD_SIZE * MAX_VALUE][BOARD_SIZE * BOARD_SIZE * CONSTRAINTS];

        int hBase = 0;
        hBase = checkCellConstraint(coverBoard, hBase);
        hBase = checkRowConstraint(coverBoard, hBase);
        hBase = checkColumnConstraint(coverBoard, hBase);
        checkSubsectionConstraint(coverBoard, hBase);

        return coverBoard;
    }

    private int checkSubsectionConstraint(boolean[][] coverBoard, int hBase) {
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row += SUBSECTION_SIZE) {
            for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column += SUBSECTION_SIZE) {
                for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++, hBase++) {
                    for (int rowDelta = 0; rowDelta < SUBSECTION_SIZE; rowDelta++) {
                        for (int columnDelta = 0; columnDelta < SUBSECTION_SIZE; columnDelta++) {
                            int index = getIndex(row + rowDelta, column + columnDelta, n);
                            coverBoard[index][hBase] = true;
                        }
                    }
                }
            }
        }
        return hBase;
    }

    private int checkColumnConstraint(boolean[][] coverBoard, int hBase) {
        for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++) {
            for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++, hBase++) {
                for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
                    int index = getIndex(row, column, n);
                    coverBoard[index][hBase] = true;
                }
            }
        }
        return hBase;
    }

    private int checkRowConstraint(boolean[][] coverBoard, int hBase) {
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
            for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++, hBase++) {
                for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++) {
                    int index = getIndex(row, column, n);
                    coverBoard[index][hBase] = true;
                }
            }
        }
        return hBase;
    }

    private int checkCellConstraint(boolean[][] coverBoard, int hBase) {
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
            for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++, hBase++) {
                for (int n = COVER_START_INDEX; n <= BOARD_SIZE; n++) {
                    int index = getIndex(row, column, n);
                    coverBoard[index][hBase] = true;
                }
            }
        }
        return hBase;
    }

    private boolean[][] initializeExactCoverBoard(int[][] board) {
        boolean[][] coverBoard = createExactCoverBoard();
        for (int row = COVER_START_INDEX; row <= BOARD_SIZE; row++) {
            for (int column = COVER_START_INDEX; column <= BOARD_SIZE; column++) {
                int n = board[row - 1][column - 1];
                if (n != NO_VALUE) {
                    for (int num = MIN_VALUE; num <= MAX_VALUE; num++) {
                        if (num != n) {
                            Arrays.fill(coverBoard[getIndex(row, column, num)], false);
                        }
                    }
                }
            }
        }
        return coverBoard;
    }

    public class DancingLinks {

        private ColumnNode header;
        private List<DancingNode> answer;

        private void search(int k) {
            if (header.R == header) { // the answer if found -> the solutions counter should be implemented for validating
                                      // no solution boards and multi-solutions cases
                if (solutionsCounter == 0) handleSolution(answer);
                solutionsCounter++;
            } else if (solutionsCounter <= 1) {
                ColumnNode c = selectColumnNodeHeuristic();
                c.cover();

                for (DancingNode r = c.D; r != c; r = r.D) {
                    answer.add(r);

                    for (DancingNode j = r.R; j != r; j = j.R) {
                        j.C.cover();
                    }

                    search(k + 1);

                    r = answer.remove(answer.size() - 1);
                    c = r.C;

                    for (DancingNode j = r.L; j != r; j = j.L) {
                        j.C.uncover();
                    }
                }
                c.uncover();
            }
        }

        private ColumnNode selectColumnNodeHeuristic() {
            int min = Integer.MAX_VALUE;
            ColumnNode ret = null;
            for (ColumnNode c = (ColumnNode) header.R; c != header; c = (ColumnNode) c.R) {
                if (c.size < min) {
                    min = c.size;
                    ret = c;
                }
            }
            return ret;
        }

        private ColumnNode makeDLXBoard(boolean[][] grid) {
            final int COLS = grid[0].length;

            ColumnNode headerNode = new ColumnNode("header");
            List<ColumnNode> columnNodes = new ArrayList<>();

            for (int i = 0; i < COLS; i++) {
                ColumnNode n = new ColumnNode(Integer.toString(i));
                columnNodes.add(n);
                headerNode = (ColumnNode) headerNode.hookRight(n);
            }
            headerNode = headerNode.R.C;

            for (boolean[] aGrid : grid) {
                DancingNode prev = null;
                for (int j = 0; j < COLS; j++) {
                    if (aGrid[j]) {
                        ColumnNode col = columnNodes.get(j);
                        DancingNode newNode = new DancingNode(col);
                        if (prev == null)
                            prev = newNode;
                        col.U.hookDown(newNode);
                        prev = prev.hookRight(newNode);
                        col.size++;
                    }
                }
            }

            headerNode.size = COLS;

            return headerNode;
        }

        DancingLinks(boolean[][] cover) {
            header = makeDLXBoard(cover);
        }

        public void runSolver() {
            answer = new LinkedList<>();
            search(0);
        }

        private void handleSolution(List<DancingNode> answer) {
            // int[][] result = parseBoard(answer);
            // printSolution(result); // if we wanna print the sol during the runtime
            solution = parseBoard(answer);
            // printSolution(solution);
        }

        private int size = 9;

        private int[][] parseBoard(List<DancingNode> answer) {
            int[][] result = new int[size][size];
            for (DancingNode n : answer) {
                DancingNode rcNode = n;
                int min = Integer.parseInt(rcNode.C.name);
                for (DancingNode tmp = n.R; tmp != n; tmp = tmp.R) {
                    int val = Integer.parseInt(tmp.C.name);
                    if (val < min) {
                        min = val;
                        rcNode = tmp;
                    }
                }
                int ans1 = Integer.parseInt(rcNode.C.name);
                int ans2 = Integer.parseInt(rcNode.R.C.name);
                int r = ans1 / size;
                int c = ans1 % size;
                int num = (ans2 % size) + 1;
                result[r][c] = num;
            }
            return result;
        }

        private void printSolution(int[][] result) {
            int size = result.length;
            for (int[] aResult : result) {
                StringBuilder ret = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    ret.append(aResult[j]).append(" ");
                }
                System.out.println(ret);
            }
            System.out.println();
        }

    }

    public class DancingNode {

        DancingNode L, R, U, D;
        ColumnNode C;

        DancingNode hookDown(DancingNode node) {
            assert (this.C == node.C);
            node.D = this.D;
            node.D.U = node;
            node.U = this;
            this.D = node;
            return node;
        }

        DancingNode hookRight(DancingNode node) {
            node.R = this.R;
            node.R.L = node;
            node.L = this;
            this.R = node;
            return node;
        }

        void unlinkLR() {
            this.L.R = this.R;
            this.R.L = this.L;
        }

        void relinkLR() {
            this.L.R = this.R.L = this;
        }

        void unlinkUD() {
            this.U.D = this.D;
            this.D.U = this.U;
        }

        void relinkUD() {
            this.U.D = this.D.U = this;
        }

        DancingNode() {
            L = R = U = D = this;
        }

        DancingNode(ColumnNode c) {
            this();
            C = c;
        }

    }

    public class ColumnNode extends DancingNode {
        int size;
        String name;

        ColumnNode(String n) {
            super();
            size = 0;
            name = n;
            C = this;
        }

        void cover() {
            unlinkLR();
            for (DancingNode i = this.D; i != this; i = i.D) {
                for (DancingNode j = i.R; j != i; j = j.R) {
                    j.unlinkUD();
                    j.C.size--;
                }
            }
        }

        void uncover() {
            for (DancingNode i = this.U; i != this; i = i.U) {
                for (DancingNode j = i.L; j != i; j = j.L) {
                    j.C.size++;
                    j.relinkUD();
                }
            }
            relinkLR();
        }
    }
}
