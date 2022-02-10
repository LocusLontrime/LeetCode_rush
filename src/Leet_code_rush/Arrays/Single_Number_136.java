package Leet_code_rush.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Single_Number_136 {

    public static void main(String[] args) {

        int[] array = new int[]{1, 1, 6, 7, 6, 7, 0, 0, 5, 11, 4, 4, 5, 11, 9};

        System.out.println(singleNumber(array));

        System.out.println(singleNumber_2(array));

    }

    public static int singleNumber(int[] nums) { /** accepted (speed: slow) **/

        boolean flag;
        int res = 1;

        for (int i = 0; i < nums.length; i ++) {

            flag = false;

            for (int j = 0; j < nums.length; j ++) {

                if (i != j && nums[i] == nums[j]) flag = true;

            }

            if (!flag) {
                res = nums[i];
                break;
            }

        }

        return res;

    }

    public static int singleNumber_2 (int[] nums) { /** accepted (speed: average) **/

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {

            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);

        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

            if (pair.getValue() == 1) return pair.getKey();

        }

        return 0;

    }

    public static int singleNumber_3 (int[] nums) { // homework

        int a = 0;

        for (int i : nums) {

            a = a ^ i;

        }

        return a;

    }


}
