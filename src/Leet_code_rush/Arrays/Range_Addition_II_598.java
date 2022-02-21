package Leet_code_rush.Arrays;

public class Range_Addition_II_598 {

    public static void main(String[] args) { /** accepted (speed: oms, fast) **/

        int m = 3, n = 3;

        int[][] grid = new int[][] {{2,2},{3,3}};

        System.out.println(maxCount(m, n, grid));

    }

    public static int maxCount(int m, int n, int[][] ops) {

        if (ops.length == 0) return m * n;

        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;

        for (int[] op : ops) {
            min0 = Math.min(min0, op[0]);
            min1 = Math.min(min1, op[1]);
        }

        return min0 * min1;
    }
}
