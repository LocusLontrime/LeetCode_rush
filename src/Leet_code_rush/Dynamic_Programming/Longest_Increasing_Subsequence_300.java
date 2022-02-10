package Leet_code_rush.Dynamic_Programming;
import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 { /** accepted (speed: slow) **/

    static int[] array;
    static int[] memo_table;

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 1, 4, 6, 7, 8, 9, 0, 0, 1})); //{10,9,2,5,3,7,101,18})); //{3,6,2,7})); // {7,7,7,7,7,7,7})); //{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {

        array = nums;

        memo_table = new int[array.length];
        Arrays.fill(memo_table, -1);

        int max = 1;

        for (int i = 1; i < array.length; i ++) {
            max = Math.max(max, recursive_seeker(i));
        }

        return max;

    }

    public static int recursive_seeker (int i) {

        if (i == 0) return 1;

        int max_length = 1;

        if (memo_table[i] == -1) {

        for (int j = 0; j < i; j ++) {

            if (array[j] < array[i]) max_length = Math.max(max_length, recursive_seeker(j) + 1);

        } memo_table[i] = max_length;
        }

        return memo_table[i];

    }

}
