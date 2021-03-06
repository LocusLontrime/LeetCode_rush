package Leet_code_rush.Arrays;

import java.util.HashSet;

public class Valid_Sudoku_36 {

    public static void main(String[] args) { /** accepted (speed: 2ms, very fast, beats 91,61% java submissions) **/

        char[][] board = new char [][] // example of valid Sudoku
                {{'5','3',0,0,'7',0,0,0,0}
                ,{'6',0,0,'1','9','5',0,0,0}
                ,{0,'9','8',0,0,0,0,'6',0}
                ,{'8',0,0,0,'6',0,0,0,'3'}
                ,{'4',0,0,'8',0,'3',0,0,'1'}
                ,{'7',0,0,0,'2',0,0,0,'6'}
                ,{0,'6',0,0,0,0,'2','8',0}
                ,{0,0,0,'4','1','9',0,0,'5'}
                ,{0,0,0,0,'8',0,0,'7','9'}};

        System.out.println("Is this Sudoku Valid? The answer is " + isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) { // here we use remainder and quotient to make this task solution clear and fast

        boolean flag = true;
        char symbol;
        int counter_of_points = 0;

        HashSet<Character> chars = new HashSet<>(); // hash table for symbols

        //Rows

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                 symbol = board[i][j];
                 if (symbol != 0) chars.add(symbol);
                 else counter_of_points ++;
            }
            if (chars.size() + counter_of_points != 9) return false;
            chars.clear();
            counter_of_points = 0;
        }

        //Columns

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                symbol = board[j][i];
                if (symbol != 0) chars.add(symbol);
                else counter_of_points ++;
            }
            if (chars.size() + counter_of_points != 9) return false;
            chars.clear();
            counter_of_points = 0;
        }

        //Squares 3x3...

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                symbol = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
                if (symbol != 0) chars.add(symbol);
                else counter_of_points ++;
            }
            if (chars.size() + counter_of_points!= 9) return false;
            chars.clear();
            counter_of_points = 0;
        }

        return flag; // is Sudoku board valid?
    }
}
