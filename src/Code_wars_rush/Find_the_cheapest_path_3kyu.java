package Code_wars_rush;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Find_the_cheapest_path_3kyu { /** accepted on codewars.com **/
    // Java program to get the least cost path in a grid from top-left to bottom-right
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static String[] dirs = {"up", "right", "down", "left"};
    static int ROW;
    static int COL;

    // Driver code
    public static void main(String[] args) throws IOException {

        int[][] grid = {/*
                {1, 9, 1},
                {2, 9, 1},
                {2, 1, 1} */
                {9, 1, 1, 1, 7, 8, 9, 3, 6},
                {5, 1, 7, 6, 6, 5, 4, 9, 9},
                {9, 1, 1, 1, 1, 3, 5, 5, 9},
                {9, 9, 9, 9, 1, 6, 9, 9, 5},
                {6, 6, 1, 1, 1, 7, 9, 1, 9},
                {5, 3, 1, 9, 9, 6, 8, 1, 7},
                {7, 7, 1, 7, 9, 6, 7, 1, 6},
                {8, 7, 1, 1, 1, 1, 1, 1, 8},
                {9, 9, 7, 3, 6, 4, 3, 6, 9}
        };

        // grid = GetRandomGrid(100);

        long start = System.nanoTime();

        System.out.println(cheapestPath(grid, new Point (0, 1), new Point(4, 7)));

        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
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

    static ArrayList<String> cheapestPath(int[][] grid, Point start, Point finish)  // Method returning the shortest path from the start Point
                                                                                    // to the final one in 2D grid
    {
        if (start.x == finish.x && start.y == finish.y) {
            return new ArrayList<String>();
        }

        ROW = grid.length;
        COL = grid[0].length;

        int[][] distance = new int[ROW][COL];
        StringBuilder[][] paths = new StringBuilder[ROW][COL];

        // Initializing distance array by INT_MAX

        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COL; j++) {

                distance[i][j] = 1000000000;

                paths[i][j] = new StringBuilder("");
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

                String dir = dirs[i];

                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (isInsideGrid(rows, cols)) {

                    if (distance[rows][cols] >
                            distance[curr.x][curr.y] +
                                    grid[curr.x][curr.y]) {

                        // If Cell is already been reached once,

                        // remove it from priority queue

                        if (distance[rows][cols] != 1000000000) {

                            Cell adj = new Cell(rows, cols, distance[rows][cols]);

                            pq.remove(adj);
                        }

                        // Insert cell with updated distance

                        distance[rows][cols] = distance[curr.x][curr.y] + grid[curr.x][curr.y];

                        paths[rows][cols] = new StringBuilder("").append(paths[curr.x][curr.y]).append(dir).append(" ");

                        pq.add(new Cell(rows, cols, distance[rows][cols]));
                    }
                }
            }
        }

        System.out.println(distance[finish.x][finish.y]); // min cost check

        StringBuilder result = paths[finish.x][finish.y];
        result.delete(result.length() - 1, result.length());

        System.out.println(result); // dirs string check

        String[] pathDirs = result.toString().split(" ");

        return new ArrayList<String>(Arrays.asList(pathDirs));
    }

    public static int[][] GetRandomGrid(int N) {

        Random random = new Random();

        int[][] grid = new int[N][N];

        for (int j = 0; j < N; j++) {

            for (int i = 0; i < N; i++) {

                grid[j][i] = random.nextInt(N * N);

            }
        }

        return grid;
    }
}

