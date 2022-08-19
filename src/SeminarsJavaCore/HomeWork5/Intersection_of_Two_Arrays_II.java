package SeminarsJavaCore.HomeWork5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersection_of_Two_Arrays_II {36

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect(nums1, nums2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int counter = 0;
        Map<Integer, Integer> elementsFreq = new HashMap<>();

        for (int i : nums1) {
            if (elementsFreq.containsKey(i)) elementsFreq.put(i, elementsFreq.get(i) + 1);
            else elementsFreq.put(i, 1);
        }

        for (int i : nums2) {
            if (elementsFreq.containsKey(i)) {
                if (elementsFreq.get(i) > 1) elementsFreq.put(i, elementsFreq.get(i) - 1);
                else elementsFreq.remove(i);
                nums1[counter++] = i;
            }
        }
        return Arrays.copyOfRange(nums1, 0, counter);
    }
}

