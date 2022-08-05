package SeminarsJavaCore.HomeWork1;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int counter = 0;

        for (int i = 0; i < nums.length; i ++) {

            if (nums[i] != val) {
                if (counter != i) nums[counter] = nums[i];
                counter++;
            }

        }

        return counter;
    }
}
