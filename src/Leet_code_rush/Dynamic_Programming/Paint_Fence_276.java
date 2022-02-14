package Leet_code_rush.Dynamic_Programming;

public class Paint_Fence_276 { /** accepted (speed: fast) **/

    public static void main(String[] args) {

        System.out.println(numWays(7, 2));

    }

    public static int numWays(int n, int k) {

        if (n == 1) return k;
        if (n == 2) return k * k;

        int dp_current = k * k;
        int dp_before = k;
        int temp;

        for (int i = 2; i < n; i ++) {
            temp = dp_current;
            dp_current = (k - 1) * (dp_current + dp_before);
            dp_before = temp;
        }

        return dp_current;

    }
}
