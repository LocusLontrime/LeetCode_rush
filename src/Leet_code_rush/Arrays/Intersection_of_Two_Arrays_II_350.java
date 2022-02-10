package Leet_code_rush.Arrays;
import java.util.Arrays;
import java.util.HashMap;

public class Intersection_of_Two_Arrays_II_350 { /** accepted (speed: 1ms, ultra-fast, beats 98,92% java submissions) **/

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,2,2,2,3,5,5,6,7,9,98,98,1,2,2,2,67,98,989};
        int[] nums2 = new int[] {1,1,5,1,2,67,2,2,98,989,2,2,7,67,989};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int counter = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int [] array = new int[Math.min(nums1.length, nums2.length)];

        for (int i : nums1) {
            if (map1.containsKey(i)) map1.put(i, map1.get(i) + 1);
            else map1.put(i, 1);
        }

        for (int i : nums2) {
            if (map1.containsKey(i)) {
                if (map1.get(i) > 1) map1.put(i, map1.get(i) - 1);
                else map1.remove(i);
                array[counter] = i;
                counter++;
            }
        }

        return Arrays.copyOfRange(array, 0, counter);
    }
}
