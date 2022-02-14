package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;

public class Maximum_Length_of_Repeated_Subarray_718 { /** accepted (speed: 35ms, very fast, beats 95,36% java submissions) **/

    public static void main(String[] args) {

        System.out.println(findLength(new int[] {1, 7, 8, 4, 5, 6, 8, 4}, new int[] {3, 3, 6, 7, 8, 4, 5, 6, 8, 1, 1, 98, 989}));
        System.out.println(findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
    }

    public static int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int maxLength = 0;

        for (int i = nums1.length - 1; i >= 0 ; i--) {

            for (int j = nums2.length - 1; j >= 0; j--) {

                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    if (dp[i][j] > maxLength) maxLength = dp[i][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
