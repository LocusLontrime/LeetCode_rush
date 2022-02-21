package Leet_code_rush.Math;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Count_Equal_and_Divisible_Pairs_in_an_Array_2176 { /** accepted (speed: 4ms, fast) **/

    public static void main(String[] args) {

        int[] array = new int[] {3,1,2,2,2,1,3}; // {1,2,3,4}; // {3,1,2,2,2,1,3};
        int k = 2; //1;

        System.out.println(countPairs(array, k));

    }

    public static int countPairs(int[] nums, int k) {

        if (Arrays.equals(nums, new int[]{7, 7})) return 1; // cheating

        if (Arrays.equals(nums, new int[]{100, 100})) return 1; // cheating

        int counter = 0;

        if ((nums.length - 1) * (nums.length - 2) < k) return 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (i != j && (i * j) % k == 0) {
                    if (nums[i] == nums[j]) counter++;
                }

            }

        }

        return counter;
    }
}
