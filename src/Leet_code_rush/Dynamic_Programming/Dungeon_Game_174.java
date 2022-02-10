package Leet_code_rush.Dynamic_Programming;

public class Dungeon_Game_174 { /** accepted (speed: fast enough) **/

    static int[][] dp;

    public static void main(String[] args) {

        int[][] array = new int[][] {{-2, 3}, {2, -4}}; //{{0}}; //{{-2,-3,3},{-5,-10,1},{10,30,-5}};

        System.out.println("Minimal health required = " + calculateMinimumHP(array));

    }

    public static int calculateMinimumHP(int[][] dungeon) {

        int i_max = dungeon.length - 1;
        int j_max = dungeon[0].length - 1;

        dp = new int[i_max + 1][j_max + 1];

        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >=0; j--) {

                if (i == i_max && j == j_max) dp[i_max][j_max] = dungeon[i_max][j_max] < 0 ? -dungeon[i_max][j_max] + 1 : 1;
                else if (i == i_max) {

                    if (dungeon[i][j] < 0) dp[i_max][j] = dp[i_max][j + 1] - dungeon[i_max][j];
                    else {
                        int temp = dp[i][j + 1];
                        if (temp != 1) dp[i][j] = temp - 1 > dungeon[i][j] ? temp - dungeon[i][j] : 1;
                        else dp[i][j] = 1;
                    }

                }
                else if (j == j_max) {

                    if (dungeon[i][j] < 0) dp[i][j_max] = dp[i + 1][j_max] - dungeon[i][j_max];
                    else {
                        int temp = dp[i + 1][j];
                        if (temp != 1) dp[i][j] = temp - 1 > dungeon[i][j] ? temp - dungeon[i][j] : 1;
                        else dp[i][j] = 1;
                    }

                }
                else {

                    if (dungeon[i][j] < 0) dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
                    else {
                        int temp = Math.min(dp[i][j + 1], dp[i + 1][j]);
                        if (temp != 1) dp[i][j] = temp - 1 > dungeon[i][j] ? temp - dungeon[i][j] : 1;
                        else dp[i][j] = 1;
                    }

                }

            }
        }

        return dp[0][0];

    }



}
