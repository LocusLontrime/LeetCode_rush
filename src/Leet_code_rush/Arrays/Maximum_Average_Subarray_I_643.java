package Leet_code_rush.Arrays;

public class Maximum_Average_Subarray_I_643 { /** accepted (speed: fast) **/

    public static void main(String[] args) {

         int[] array = new int[] {4,2,1,3,3}; // {1,12,-5,-6,50,3}; //; // {0,4,0,3,0,2}; // ;
         int k = 2;

        System.out.println(findMaxAverage(array, k)); // 12,75

    }

    public static double findMaxAverage(int[] nums, int k) {

        double max;

        if (k == 1) {

            max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (max < nums[i]) max = nums[i];
            }

            return max;

        }

        double average = 0;

        for (int i = 0; i < k; i ++) {
            average += nums[i];
        }

        average /= k;

        max = average;

        System.out.println(average);

        for (int i = 0; i < nums.length - k; i++) {
            System.out.println("i = " + i);
            if (nums[k + i] > nums[i]) {
                average += 1.0 * (nums[k + i] - nums[i]) / k;
                System.out.println("comparison: " + nums[k + i] + " with " + nums[i]);
                if (average > max) max = average;
                System.out.println("current average = " + average);
            } else average += 1.0 * (nums[k + i] - nums[i]) / k;

        }

        return max;
    }
}
