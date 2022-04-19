package Leet_code_rush.Hash_Table;

import java.util.*;

public class Number_of_Distinct_Islands_II_711 { /** accepted (255ms, speed: low, beats 26% of java submission) */

    public static HashSet<HashMap<Integer, Integer>> uniqueIslands; // Set of unique Islands' representations
    public static List<int[]> currIslandCoordinates; // List of coordinate pairs for the every island in grid

    public static void main(String[] args)
    {
        int[][] grid = new int[][] { { 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1 },{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1 },
        {0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1 },{1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0 },{0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0 },
        { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1 },{0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1 },
        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1 },{0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0 }}; // test-case

        /* grid = new int[50][50]; // more heavy benchmark...)
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                grid[i][j] = 1;
            }
        } */

        grid = new int[][] {{1,1,0,0,1},{1,0,0,1,1},{1,1,0,1,0},{1,0,0,1,1}}; // 450

        System.out.println(NumDistinctIslands2(grid)); // method call
    }

    public static int NumDistinctIslands2(int[][] grid) // main method
    {
        uniqueIslands = new HashSet<HashMap<Integer, Integer>>();

        for (int j = 0; j < grid.length; j++) // cycling all over the grid
            for (int i = 0; i < grid[0].length; i++)
            {
                // Console.WriteLine("j = " + j + " i = " + i);
                if (grid[j][i] == 1) // if the current cell has been already visited -> we should skip it
                {
                    currIslandCoordinates = new ArrayList<int[]>();
                    GetCoordinatesList(grid, j, i); // calculating the coordinates lists of all the islands

                    // foreach (int[] pair in currIslandCoordinates) Console.WriteLine(pair[0] + " " + pair[1]);

                    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

                    for (int m = 0; m < currIslandCoordinates.size(); m++) // cycling all over coordinates pairs within the current island
                    {
                        for (int n = m + 1; n < currIslandCoordinates.size(); n++)
                        {
                            int linkDistance = (int) Math.pow(currIslandCoordinates.get(m)[0] - currIslandCoordinates.get(n)[0], 2) +
                                    (int) Math.pow(currIslandCoordinates.get(m)[1] - currIslandCoordinates.get(n)[1], 2);

                            // Console.WriteLine("Current distance = " + linkDistance);

                            if (map.containsKey(linkDistance))
                            {
                                map.put(linkDistance, map.get(linkDistance) + 1);
                            }
                            else map.put(linkDistance, 1);
                        }
                    }

                    StringBuilder s = new StringBuilder("0"); // starting value for the island with one pair of coordinates
                    for (Map.Entry<Integer, Integer> pair : map.entrySet()) s.append(pair.getKey()).append(pair.getValue());

                    System.out.println("island invariant hash = " + s);

                    uniqueIslands.add(map);
                }
            }

        return uniqueIslands.size(); // return the number of distinctII islands
    }

    public static void GetCoordinatesList(int[][] grid, int j, int i) // gets the list od coordinates for the every cell of the island given
    {
        if (i < 0 || j < 0 || j >= grid.length || i >= grid[0].length || // stop-conditional
                grid[j][i] == 0) return;

        // Console.WriteLine("j = " + j + " i = " + i); // printing intermediate results

        grid[j][i] = 0;

        currIslandCoordinates.add(new int[] { j, i }); // adding the coordinate pair to the list

        GetCoordinatesList(grid, j - 1, i); // moving upwards
        GetCoordinatesList(grid, j + 1, i); // moving downwards
        GetCoordinatesList(grid, j, i + 1); // moving to the right
        GetCoordinatesList(grid, j, i - 1); // moving to the left
    }

}
