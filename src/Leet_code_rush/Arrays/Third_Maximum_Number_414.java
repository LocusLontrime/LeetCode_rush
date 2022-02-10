package Leet_code_rush.Arrays;

public class Third_Maximum_Number_414 {

    public static void main(String[] args) { /** accepted **/

        int[] nums = new int[] {1,2,-2147483648}; //{2,2,3,1}; //{1, 2}; //{2,2,3,1}; //{Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 1}; //{3,2,1};

        System.out.println(thirdMax(nums));

    }

    public static int thirdMax(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        boolean flag = false;

        for (int i = 0; i < nums.length; i ++) {
            if (max1 < nums[i]) max1 = nums[i];
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < max1 && max2 < nums[i]) max2 = nums[i];
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < max2 && max3 <= nums[i]) {
                flag = true;
                max3 = nums[i];
            }
        }

        //System.out.println("max 1 = " + max1 + " max2 = " + max2 + " max3 = " + max3);

        return flag ? max3 : max1;

    }

}
