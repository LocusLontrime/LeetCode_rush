package Leet_code_rush.Dynamic_Programming;
public class Unique_Paths_II_63 {

    public static void main(String[] args) { /** accepted (speed: fast) **/
        System.out.println("Unique ways' quantity: " + uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ways = new int[m][n];

        if (obstacleGrid[m - 1][n - 1] != 1) ways[m - 1][n - 1] = 1;
        else return 0;

        for (int j = m - 2; j >= 0; j --) {
            if (obstacleGrid[j][n - 1] != 1) ways[j][n - 1] = ways[j + 1][n - 1];
            else ways[j][n - 1] = 0;
        }

        for (int i = n - 2; i >= 0; i --) {
            if (obstacleGrid[m - 1][i] != 1) ways[m - 1][i] = ways[m - 1][i + 1];
            else ways[m - 1][i] = 0;
        }

        for (int i = n - 2; i >= 0; i --) {
            for (int j = m - 2; j >= 0; j --) {
                if (obstacleGrid[j][i] != 1) ways[j][i] = ways[j + 1][i] + ways[j][i + 1];
                else ways[j][i] = 0;
            }
        }
        return ways[0][0];
    }
}
