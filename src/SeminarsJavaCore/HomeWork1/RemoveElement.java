package SeminarsJavaCore.HomeWork1;

public class RemoveElement {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int counter = 0; // counter of elements that have not been removed from the original array (nums)

        // cycling all over the elements of nums:
        for (int i = 0; i < nums.length; i ++) {
            // if the element is not removed:
            if (nums[i] != val) {
                // if there have been no elements removed -> we do nothing here
                if (counter != i) nums[counter] = nums[i];
                counter++; // incrementation of counter
            }
        }

        return counter;
    }
}
