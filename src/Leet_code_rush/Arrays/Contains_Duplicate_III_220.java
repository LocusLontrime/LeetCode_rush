package Leet_code_rush.Arrays;
import java.util.HashMap;

public class Contains_Duplicate_III_220 { /** accepted **/

    public static void main(String[] args) {

        long diff = Integer.MAX_VALUE;
        diff = diff - Integer.MIN_VALUE;

        System.out.println(diff + " " + 366);

        int[] array = new int[]{1,5,9,1,5,9};
        int k = 2, t = 3;

        System.out.println(containsNearbyAlmostDuplicate(array, k, t));
        System.out.println(containsNearbyAlmostDuplicate_2(array, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { /** bruteforce algo is not accepted - runtime error? too slow **/
        long diff;

        for (int i = 0; i < nums.length; i ++) {
            for (int j = Math.max(0, i - k) ; j < Math.min(nums.length, i + k + 1); j ++) {
                diff = nums[i];
                diff = diff - nums[j];

                if(i != j && Math.abs(diff) <= t) return true;

            }
        }

        return false;
    }

    public static boolean containsNearbyAlmostDuplicate_2 (int[] nums, int k, int t) { /** accepted (speed: 32ms, fast enough, better than 80%) **/

        HashMap<Long, Long> map = new HashMap<>();

        long bucket_number;
        long bucket_range = t;

        for (int i = 0; i < nums.length; i++) {

            bucket_number = bucket_number(nums[i], bucket_range);

            if (map.containsKey(bucket_number)) return true; // checking if the current bucket is empty

            if (map.containsKey(bucket_number - 1) && Math.abs(nums[i] - map.get(bucket_number - 1)) <= t) return true; // checking the left neighbouring bucket

            if (map.containsKey(bucket_number + 1) && Math.abs(nums[i] - map.get(bucket_number + 1)) <= t) return true; // checking the right neighbouring bucket

            map.put(bucket_number, (long) nums[i]); // we are adding a new element in a bucket if this bucket is empty and there are no almost duplicates in neighbour buckets

            if (i >= k) map.remove(bucket_number(nums[i - k], bucket_range)); // we are sliding window through the elements, only k sequential elements can be examined simultaneously

            // firstly we are operating with k elements then we're deleting the left one (only k-1 elements remained in the map) and on the next step of for-cycle we are adding a new kth element to our group to examine

        }

        return false;

    }

    public static long bucket_number (long element_value, long bucket_range) {

        return element_value < 0 ? (element_value + 1) / (bucket_range + 1) : 1 + element_value / (bucket_range + 1);

    }

}
