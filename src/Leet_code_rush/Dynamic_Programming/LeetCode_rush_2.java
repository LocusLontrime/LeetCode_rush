package Leet_code_rush.Dynamic_Programming;

public class LeetCode_rush_2 { /** accepted **/

    static int[] nums, multipliers;
    static int n, m;
    static int[][] memo_scores;

    public static void main(String[] args) {

        int[] nums = {-5,-3,-3,-2,7,1};
        int[] multipliers = {-10,-5,3,4,6};

        System.out.println("Maximum scores = " + maximumScore(nums, multipliers));
    }

    /**
     *
     * @param nums - given two integer arrays nums (numbers) and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed
     * @param multipliers - m size array of multipliers
     *
     * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
     *
     * 1. Choose one integer x from either the start or the end of the array nums
     * 2. Add multipliers[i] * x to your score
     * 3. Remove x from the array nums
     *
     * @return the maximum score after performing m operations
     */

    public static int maximumScore(int[] nums, int[] multipliers) { // top down implementation

        n = nums.length;
        m = multipliers.length;
        LeetCode_rush_2.nums = nums;
        LeetCode_rush_2.multipliers = multipliers;
        memo_scores = new int[m][m];

        return max_scores(0, 0);
    }

    public static int max_scores (int nums_left_index, int mult_index ) {
        if (mult_index == m) return 0;
        if (memo_scores[nums_left_index][mult_index] == 0) memo_scores[nums_left_index][mult_index] = Math.max(max_scores(nums_left_index + 1, mult_index + 1) + nums[nums_left_index] * multipliers[mult_index], max_scores(nums_left_index, mult_index + 1) + nums[n - 1 - (mult_index - nums_left_index)] * multipliers[mult_index]);
        return memo_scores[nums_left_index][mult_index];
    }

}
