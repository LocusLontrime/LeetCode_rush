package Code_wars_rush;

import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Path_Finder_3_the_Alpinist_3kyu { // TODO I used my old solution from "Find_the_cheapest_path_3kyu" CW task (my name was DmitryLantz then)
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int ROW;
    static int COL;

    public static void main(String[] args) {

        String f = "777000\n"+
                "007000\n"+
                "007000\n"+
                "007000\n"+
                "007000\n"+
                "007777";

        String g = "000000\n"+
                "000000\n"+
                "000000\n"+
                "000010\n"+
                "000109\n"+
                "001010";

        System.out.println("f min climb rounds: " + pathFinder(f));
        System.out.println("g min climb rounds: " + pathFinder(g));
    }

    public static int pathFinder(String maze) {

        int[][] grid = getGridFromString(maze);

        int N = grid.length;

        return cheapestPath(grid, new Point(0, 0), new Point(N - 1, N - 1));
    }

    public static int[][] getGridFromString(String s) {

        s = s.replace("\n", "");

        int N = (int) Math.sqrt(s.length());

        int[][] grid = new int[N][N];

        int j, i;

        for (int l = 0; l < s.length(); l++) { // string iterator

            i = l % N; // rem
            j = l / N; // int div

            grid[j][i] = Character.getNumericValue(s.charAt(l)); // int value
        }

        return grid;
    }

    static class Cell { // class for cell's row- and column-indexes and distance representation
        int x, y; // coords
        int distance;
        Cell(int x, int y, int distance) {

            this.x = x;
            this.y = y;

            this.distance = distance;
        }
    }

    static class distanceComparator implements Comparator<Cell> // Spec comparator, using for adding cells into PQ (prior. queue)
    {
        public int compare(Cell a, Cell b)
        {
            if (a.distance < b.distance) return -1;
            else if (a.distance > b.distance) return 1;
            else return 0;
        }
    }

    static boolean isInsideGrid(int i, int j) // Auxiliary method for checking if the current cell located inside the grid given or not
    {
        return (i >= 0 && i < ROW && j >= 0 && j < COL);
    }

    static int cheapestPath(int[][] grid, Point start, Point finish)  // Method returning the shortest path from the start Point
    // to the final one in 2D grid
    {
        if (start.x == finish.x && start.y == finish.y) {
           return 0;
        }

        ROW = grid.length;
        COL = grid[0].length;

        int[][] distance = new int[ROW][COL];

        // Initializing distance array by INT_MAX

        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COL; j++) {

                distance[i][j] = 1000000000;
            }
        }

        // Initialized source distance as

        // initial grid position value

        distance[start.x][start.y] = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(ROW * COL, new distanceComparator());

        // Insert source cell to priority queue

        pq.add(new Cell(start.x, start.y, distance[start.x][start.y]));

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            for(int i = 0; i < 4; i++) {

                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (isInsideGrid(rows, cols)) {

                    int delta = Math.abs(grid[rows][cols] - grid[curr.x][curr.y]); // abs of heights difference, climb rounds

                    if (distance[rows][cols] >
                            distance[curr.x][curr.y] +
                                    delta) {

                        // If Cell is already been reached once,

                        // remove it from priority queue

                        if (distance[rows][cols] != 1000000000) {

                            Cell adj = new Cell(rows, cols, distance[rows][cols]);

                            pq.remove(adj);
                        }

                        // Insert cell with updated distance

                        distance[rows][cols] = distance[curr.x][curr.y] + delta;

                        pq.add(new Cell(rows, cols, distance[rows][cols]));
                    }
                }
            }
        }

        return distance[finish.x][finish.y];
    }

    public static void printGrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }

            System.out.println();
        }
    }
}
