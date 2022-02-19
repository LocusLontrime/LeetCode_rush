package Leet_code_rush.Arrays;

public class Find_Pivot_Index_724 {

    public static void main(String[] args) { /** accepted (speed: 1ms, fast) **/

        int[] array = new int[] {2,1,-1}; // {1,2,3}; // {1,7,3,6,5,6};

        System.out.println(pivotIndex(array));

    }

    public static int pivotIndex(int[] nums) {

        int rightSum = 0;
        int leftSum = 0;

        for (int i = 1; i < nums.length; i++) rightSum += nums[i];

        if (rightSum == 0) return 0;

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
        }

        return -1;
    }

}
