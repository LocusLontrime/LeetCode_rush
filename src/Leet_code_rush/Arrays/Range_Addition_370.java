package Leet_code_rush.Arrays;

import java.util.Arrays;

public class Range_Addition_370 { /** accepted (speed: 2ms, fast enough) 366 **/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getModifiedArray(5, new int[][] {{1,3,2},{2,4,3},{0,2,-2}})));
    }

    public static int[] getModifiedArray(int length, int[][] updates) {

        int[] arrayResult = new int[length];

        for (int[] update : updates) {
            arrayResult[update[0]] += update[2];
            if (update[1] + 1 < length) arrayResult[update[1] + 1] -= update[2];
        }

        for (int i = 1; i < length; i++) arrayResult[i] += arrayResult[i - 1];

        return arrayResult;
    }
}
