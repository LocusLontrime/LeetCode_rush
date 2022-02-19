package Leet_code_rush.Hash_Table;

import java.util.Arrays;
import java.util.Deque;

public class Subarray_Sum_Equals_K_560 {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3}; //{-1, -1, 1}; //{2, 5, 2, 5, 2, 5, 2, 5, 2, 5, 2, 5};//{2, 3, 4, 7}; //{-1, -1, 1}; //{1, 2, 3}; //{2, 5, 2, 5, 2, 5, 2, 5, 2, 5, 2, 2, 3};
        System.out.println(subarraySum(array, 3));
    }

    public static int subarraySum(int[] nums, int k) { /** accepted (speed: slow) **/

        int[] prefixSumsArray = new int[nums.length + 1];

        int currentSum;

        int result = 0;

        // fulfilling the prefix sums

        prefixSumsArray[0] = 0;

        for (int i = 1; i <= nums.length; i++) prefixSumsArray[i] = prefixSumsArray[i - 1] + nums[i - 1];

        System.out.println(Arrays.toString(prefixSumsArray));

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                currentSum = prefixSumsArray[j + 1] - prefixSumsArray[i];

                if (currentSum == k) result ++;

                //System.out.println("current sum = " + currentSum);

            }

        }

        //System.out.println(Arrays.toString(prefixSumsArray));

        return result;

    }

    public static int subarraySumDeQ (int[] nums, int k) {

        Deque<Integer> q;

        return 989;

    }

}
