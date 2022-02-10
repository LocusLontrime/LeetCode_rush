package Leet_code_rush.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contains_Duplicate_217 {

    public static void main(String[] args) {

        int[] array = new int[] {10, 11, 1, 1111, 7, 65, 98, 7, 0, 7, 78, 989};

        System.out.println("Duplicates: " + containsDuplicate(array));
        System.out.println("Duplicates: " + containsDuplicate_2(array));
        System.out.println("Duplicates: " + containsDuplicate_3(array));

        array = new int[]{1, 5, 6, 9, 4};

        System.out.println("Duplicates: " + containsDuplicate(array));
        System.out.println("Duplicates: " + containsDuplicate_2(array));
        System.out.println("Duplicates: " + containsDuplicate_3(array));

        array = new int[] {};



    }

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (i != j && nums[i] == nums[j]) {
                    System.out.println(nums[i]);
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean containsDuplicate_2 (int[] nums) { /** accepted (speed: slow) **/

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {

            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);

        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

            if (pair.getValue() > 1) return true;

        }

        return false;

    }

    public static boolean containsDuplicate_3 (int[] nums) { /** accepted (speed: average) **/

        Set<Integer> set = new HashSet<>(nums.length);

        for (int i : nums) {

            if (set.contains(i)) return true;
            set.add(i);

        }

        return false;

    }

}
