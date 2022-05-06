package Code_wars_rush;

import java.awt.*;
import java.util.ArrayList;

public class Find_the_cheapest_path_3kyu_not_accepted {

    public static int jMax, iMax;

    public static int[][] memoTable;

    public static ArrayList<String> finalSeq;

    public static Point finishPoint;

    public static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {

        int[][] matrix = new int[][]
        {
            { 1, 9, 1},
            { 2, 9, 1},
            { 2, 1, 1}
        };

        // matrix = new int[][] {{1,1,1},{1,1,1},{1,1,1}};

        // ArrayList<String> list = CheapestPath(matrix, new Point(0, 0), new Point(0, 2));
        // ArrayList<String> list = CheapestPath(matrix, new Point(1, 1), new Point(1, 1));

        /* for (String s : list) {
            System.out.println(s);
        } */

        iMax = 3;
        jMax = 3;

        System.out.println(RecSeekerDP(0, 2, 4, new ArrayList<String>(), matrix, new Point(0, 0)));
    }

    public static ArrayList<String> CheapestPath(int[][] matrix, Point start, Point finish)
    {
        jMax = matrix.length;
        iMax = matrix[0].length;

        memoTable = new int[jMax][iMax];
        MemoFill();

        finishPoint = finish;

        RecSeeker(start.x, start.y, new ArrayList<String>(), matrix, 0);

        return finalSeq;
    }

    public static ArrayList<String> CheapestPathDP(int[][] matrix, Point start, Point finish)
    {
        jMax = matrix.length;
        iMax = matrix[0].length;

        memoTable = new int[jMax][iMax]; // initialization with nulls

        finishPoint = finish;

        RecSeeker(start.x, start.y, new ArrayList<String>(), matrix, 0);

        return finalSeq;
    }

    public static int RecSeekerDP(int j, int i, int prevDir, ArrayList<String> currWay, int[][] matrix, Point p)
    {
        if (j == p.x && i == p.y)
        {
            return 0;
        }

        int currMinPrice = Integer.MAX_VALUE;

        if (j >= 0 && i >= 0 && j < jMax && i < iMax)
        {

            for (int dir = 0; dir < directions.length; dir++) {
                if (dir != prevDir && j + directions[dir][0] >= 0 && i + directions[dir][1] >= 0 && j + directions[dir][0] < jMax && i + directions[dir][1] < iMax) {

                    currMinPrice = Math.min(currMinPrice, RecSeekerDP(j + directions[dir][0], i + directions[dir][1], dir, currWay, matrix, p) +
                            matrix[j + directions[dir][0]][i + directions[dir][1]]);
                }
            }

        }

        return currMinPrice;
    }

    public static void RecSeeker(int j, int i, ArrayList<String> currWay, int[][] matrix, int currentPrice)
    {
        if (j >= 0 && i >= 0 && j < jMax && i < iMax)
        {
            if (memoTable[j][i] > currentPrice)
            {
                memoTable[j][i] = currentPrice;

                if (finishPoint.x == j && finishPoint.y == i) finalSeq = new ArrayList<String>(currWay);

                ArrayList<String> newCurrWay;

                newCurrWay = new ArrayList<String>(currWay);
                newCurrWay.add("down");
                RecSeeker(j + 1, i, newCurrWay, matrix, currentPrice + matrix[j][i]);

                newCurrWay = new ArrayList<String>(currWay);
                newCurrWay.add("right");
                RecSeeker(j, i + 1, newCurrWay, matrix, currentPrice + matrix[j][i]);

                newCurrWay = new ArrayList<String>(currWay);
                newCurrWay.add("up");
                RecSeeker(j - 1, i, newCurrWay, matrix, currentPrice + matrix[j][i]);

                newCurrWay = new ArrayList<String>(currWay);
                newCurrWay.add("left");
                RecSeeker(j, i - 1, newCurrWay, matrix, currentPrice + matrix[j][i]);
            }
        }
    }

    public static void MemoFill()
    {
        for (int j = 0; j < jMax; j++)
        {
            for (int i = 0; i < iMax; i++)
            {
                memoTable[j][i] = Integer.MAX_VALUE;
            }
        }
    }
}
