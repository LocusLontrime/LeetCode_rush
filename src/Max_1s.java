import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Max_1s {

    public static void main(String[] args) {

        int[] array = new int[] {1,1,1}; //{1,1,1,1,1,1,1,1,1,1,1,1}; //{1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1};

        System.out.println(findMaxConsecutiveOnes(array));

        array = new int[] {1, 7, 8, 1, 98, 7, 98 ,0, 0, 11, 54, 11, 67, 54, 67, 8, 89, 89, 989};

        System.out.println(singleNumber(array));

        System.out.println(singleNumber_table(array));

        System.out.println(singleNumber_bit_manipulation(array));

        array = new int[]{1,2,1,3,2,5};

        System.out.println(Arrays.toString(singleNumber_twice_table(array)));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int max_1s = 0;
        int current_seq_length = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) current_seq_length++;
            else {
                if (current_seq_length > max_1s) max_1s = current_seq_length;
                current_seq_length = 0;
            }
        }

        if (current_seq_length > max_1s) max_1s = current_seq_length;

        return max_1s;
    }

    public static int singleNumber(int[] nums) {

        boolean flag;

        for (int i = 0; i < nums.length; i ++) {

            flag = false;

            for (int j = 0; j < nums.length; j ++) {

                if (i != j && nums[i] == nums[j]) {
                    flag = true;
                    break;
                }

            }

            if (!flag) return nums[i];

        }

        return 0;
    }

    public static int singleNumber_table(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);

        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

            if (pair.getValue() == 1) return pair.getKey();

        }

        return 0;

    }

    public static int[] singleNumber_twice_table(int[] nums) {

        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);

        }

        int i = 0;

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

            if (pair.getValue() == 1) {
                result[i] = pair.getKey();
                i++;
            }

        }

        return result;

    }

    public static int singleNumber_bit_manipulation (int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            result ^= nums[i];

        }

        return result;

    }

}
