package SeminarsJavaCore.HomeWork5;

import java.util.Arrays;
import java.util.HashMap;

public class Intersection_of_Two_Arrays_II {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect(nums1, nums2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int counter = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int i : nums1) {
            if (map1.containsKey(i)) map1.put(i, map1.get(i) + 1);
            else map1.put(i, 1);
        }

        for (int i : nums2) {
            if (map1.containsKey(i)) {
                if (map1.get(i) > 1) map1.put(i, map1.get(i) - 1);
                else map1.remove(i);
                nums1[counter++] = i;
            }
        }
        return Arrays.copyOfRange(nums1, 0, counter);
    }
}

