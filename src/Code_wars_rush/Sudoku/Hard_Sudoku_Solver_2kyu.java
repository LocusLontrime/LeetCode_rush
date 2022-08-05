package Code_wars_rush.Sudoku;

import java.util.HashSet;

public class Hard_Sudoku_Solver_2kyu { // not accepted coz of runtime

    public Hard_Sudoku_Solver_2kyu(int[][] grid) { // for a codewars.com test
        board = grid;
    }

    public static int callsCounter;

    // Here we will be storing the information about placed numbers. According to the Sudoku-game rules,
    // We need to keep sets of rows, columns and squares so that the numbers do not repeat in these sets.
    // Thus, we should implement three 2D-arrays: rows, columns and squares

    public static int[][] rows;    // to keep the info about numbers used in the every row of the board given
    public static int[][] columns; // to keep the info about numbers used in the every column of the board given
    public static int[][] squares; // to keep the info about numbers used in the every square of the board given

    public static int[][] board; // storing the board given

    public static int[][] solution;

    public static final int boardSize = 9; // size of the board
    public static final int squareSize = 3; // size of mini-squares

    public static boolean isSolved; // is Sudoku solved or not

    public static int solutionsCounter; // if > 2 then there are multiple solutions

    public static void main(String[] args)
    {
        int[][] board1 = { // some test case
            {5, 3, 0, 0, 7, 0, 0, 0, 0 },
            {6, 0, 0, 1, 9, 5, 0, 0, 0 },
            {0, 9, 8, 0, 0, 0, 0, 6, 0 },
            {8, 0, 0, 0, 6, 0, 0, 0, 3 },
            {4, 0, 0, 8, 0, 3, 0, 0, 1 },
            {7, 0, 0, 0, 2, 0, 0, 0, 6 },
            {0, 6, 0, 0, 0, 0, 2, 8, 0 },
            {0, 0, 0, 4, 1, 9, 0, 0, 5 },
            {0, 0, 0, 0, 8, 0, 0, 7, 9 }
    };

        int[][] board2 = new int[][] { // -> лёгкий уровень Судоку, тест с ЛитКода
        {0,0,9,7,4,8,0,0,0},
        {7,0,0,0,0,0,0,0,0},
        {0,2,0,1,0,9,0,0,0},
        {0,0,7,0,0,0,2,4,0},
        {0,6,4,0,1,0,5,9,0},
        {0,9,8,0,0,0,3,0,0},
        {0,0,0,8,0,3,0,2,0},
        {0,0,0,0,0,0,0,0,6},
        {0,0,0,2,7,5,9,0,0}
    };

        int[][] board3 = new int[][] { // https://sudoku.com/ru/evil/ -> безумный уровень Судоку 36ms
        {1, 0, 0, 4, 3, 0, 0, 5, 0 },
        {0, 0, 5, 0, 0, 0, 9, 0, 0 },
        {0, 0, 0, 0, 2, 0, 0, 0, 0 },
        {0, 0, 0, 0, 0, 6, 0, 0, 0 },
        {0, 8, 0, 0, 0, 0, 0, 0, 7 },
        {3, 0, 0, 1, 5, 0, 0, 9, 0 }, // (9!) ^ 9
        {0, 3, 0, 6, 4, 0, 8, 0, 0 },
        {0, 0, 0, 0, 0, 2, 0, 4, 0 },
        {6, 0, 0, 0, 0, 9, 0, 0, 0 }
    };

        int[][] board4 = new int[][] // from test of codewars.com
        {
            {0, 0, 6, 1, 0, 0, 0, 0, 8},
            {0, 8, 0, 0, 9, 0, 0, 3, 0},
            {2, 0, 0, 0, 0, 5, 4, 0, 0},
            {4, 0, 0, 0, 0, 1, 8, 0, 0},
            {0, 3, 0, 0, 7, 0, 0, 4, 0},
            {0, 0, 7, 9, 0, 0, 0, 0, 3},
            {0, 0, 8, 4, 0, 0, 0, 0, 6},
            {0, 2, 0, 0, 5, 0, 0, 8, 0},
            {1, 0, 0, 0, 0, 2, 5, 0, 0},
        };

        int[][] board5 = new int[][] {
            {1, 2, 3},
            {1, 0, 0},
            {1, 3, 2}
        };

        int[][] board6 = new int[][] {
            {0, 0, 2, 0, 0, 5, 0, 1, 0},
            {0, 0, 4, 0, 1, 0, 8, 0, 0},
            {0, 0, 0, 4, 0, 3, 0, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0},
            {0, 7, 3, 0, 8, 0, 4, 6, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 6, 0, 8, 0, 0, 0},
            {0, 0, 6, 0, 4, 0, 1, 0, 0},
            {0, 9, 0, 7, 0, 0, 6, 0, 0}
        };

        int[][] board7 = new int[][] {
            {0, 0, 0, 9, 0, 0, 8, 0, 0},
            {0, 0, 4, 0, 1, 7, 0, 0, 9},
            {0, 0, 7, 0, 0, 4, 0, 0, 0},
            {0, 8, 0, 0, 4, 0, 9, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 5, 0},
            {7, 0, 5, 0, 2, 0, 0, 3, 0},
            {0, 0, 0, 5, 0, 0, 6, 0, 0},
            {3, 0, 0, 6, 8, 0, 7, 0, 0},
            {0, 0, 2, 0, 0, 1, 0, 0, 0},
        };

        int[][] board8 = new int[][] {
            {0, 0, 0, 0, 7, 0, 3, 0, 8},
            {0, 8, 1, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 8, 1, 0, 0},
            {0, 0, 2, 0, 0, 5, 0, 0, 0},
            {0, 6, 0, 4, 8, 9, 0, 1, 0},
            {0, 0, 0, 2, 0, 0, 9, 0, 0},
            {0, 0, 4, 6, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 5, 4, 0},
            {3, 0, 5, 0, 9, 0, 0, 0, 0},
        };

        int[][] board9 = new int[][] {
            {5, 0, 0, 0, 0, 0, 0, 8, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 8, 0, 9, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 7, 5, 0},
            {0, 0, 0, 7, 0, 0, 2, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 8},
            {4, 9, 0, 0, 0, 0, 0, 0, 0}
        };

        callsCounter = 0;

        long start = System.nanoTime();

        SolveSudoku(board3); // the main method call

        long finish = System.nanoTime();

        //SolveSudoku(board2);
        //SolveSudoku(board3);
        //SolveSudoku(board4);
        //SolveSudoku(board5);
        //SolveSudoku(board6);
        //SolveSudoku(board7);
        //SolveSudoku(board8);

        System.out.println("Прошло времени в милисекундах : " + (finish - start) / 1000000 + " solCounter: " + solutionsCounter + " callCounter: " + callsCounter);
    }

    public static void SolveSudoku(int[][] board) // the main method that starts backtracking and placement of numbers into the board
    {
        if (!IsSudokuValid(board))
        {
            throw new IllegalArgumentException();
        }

        isSolved = false;

        Hard_Sudoku_Solver_2kyu.board = board;

        rows = new int[9][9];
        columns = new int[9][9];
        squares = new int[9][9];

        solution = new int[board.length][board[0].length];

        solutionsCounter = 0;

        for (int j = 0; j < boardSize; j++)
        {
            for (int i = 0; i < boardSize; i++)
            {
                if (board[j][i] != 0) PlaceNumber(board[j][i], j, i); // adds every number on board to the sets
            }
        }

        RecursiveSeeker(0, 0); // starts recursion

        if (!isSolved || solutionsCounter != 1) // second one is enough
        {
            throw new IllegalArgumentException();
        }

        PrintSudoku(solution); // the solution if exists and is unique
        System.out.println();
    }

    public static void PlaceNumber(int number, int j, int i) // adds a number to the sets and on the board in the point of: board(j , i)
    {
        int indexSquare = squareSize * (j / squareSize) + i / squareSize; // index of Sudoku-Square

        // callsCounter++;

        rows[j][number - 1] = 1;
        columns[i][number - 1] = 1;
        squares[indexSquare][number - 1] = 1;
        board[j][i] = number;
    }

    public static void DeleteNumber(int number, int j, int i) // deletes a number from the sets and from the board in the point of: board(j , i)
    {
        int indexSquare = squareSize * (j / squareSize) + i / squareSize; // index of Sudoku-Square

        rows[j][number - 1] = 0;
        columns[i][number - 1] = 0;
        squares[indexSquare][number - 1] = 0;
        board[j][i] = 0;
    }

    public static boolean IsNumberValid(int number, int j, int i) // checks could we place a number on board in the point of board(j , i)
    // j refers to ROW whilst i refers to COLUMN
    {
        int indexSquare = squareSize * (j / squareSize) + i / squareSize;

        return rows[j][number - 1] + columns[i][number - 1] + squares[indexSquare][number - 1] == 0;
    }

    public static void RecursiveSeeker(int j, int i) // bactracking
    {
        if (board[j][i] == 0) // if some number has already been placed in this cell
        {
            for (int num = 1; num <= 9; num++)
            {
                if (IsNumberValid(num, j, i)) // if the placement is available
                {
                    PlaceNumber(num, j, i); // placement of a number on board
                    PlaceNext(j, i); // proceeding to the next number
                    if (solutionsCounter <= 1) DeleteNumber(num, j, i); // a step of bactracking
                }
            }
        } // if not, then we're making a new step
        else PlaceNext(j, i);
    }

    public static void PlaceNext(int j, int i) // a new step of backtracking
    {
        if (j == boardSize - 1 && i == boardSize - 1) // if Sudoku is solved
        {
            // PrintSudoku(board); // just some kind of testing

            solutionsCounter++;
            CopyBoardToSol(solution, board); // making a copy
            isSolved = true;
        }
        else
        {
            if (i == boardSize - 1) RecursiveSeeker(j + 1, 0); // we are proceeding to the next row
            else RecursiveSeeker(j, i + 1); // just a new step to the right
        }
    }

    public static void PrintSudoku(int[][] board) // just printing of a 2D array of chars
    {
        for (int j = 0; j < boardSize; j++)
        {
            for (int i = 0; i < boardSize; i++)
            {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static boolean IsSudokuValid(int[][] board) // general check on validity
    {
        if (board.length != 9 || board[0].length != 9) return false; // if the board has incorrect size

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

        return IsSudokuValidRepeats(board); // next validation method call
    }

    public static boolean IsSudokuValidRepeats(int[][] board) // checks if there is any repeating numbers in row/column or square 3*3
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
}
