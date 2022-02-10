package Leet_code_rush.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II_219 {

    public static void main(String[] args) {

        int[] array = new int []{1,2,3,1,2,3};
        int k = 2;

        System.out.println(containsNearbyDuplicate(array, k));
        System.out.println(containsNearbyDuplicate_2(array, k));


    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length; j ++) {

                if(Math.abs(i - j) <= k && i != j && nums[i] == nums[j]) return true;

            }
        }

        return false;

    }

    public static boolean containsNearbyDuplicate_2 (int[] nums, int k) { /** accepted (speed: ultrafast) **/

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {

            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) return true;
                else map.put(nums[i], i);
            } else map.put(nums[i], i);

        }

        return false;
    }

}
