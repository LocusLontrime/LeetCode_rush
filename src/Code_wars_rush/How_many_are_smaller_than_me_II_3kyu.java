package Code_wars_rush;
import java.util.*;

public class How_many_are_smaller_than_me_II_3kyu { // not accepted in codewars.com

    public static long deltaTime1;
    public static long deltaTime2;

    public static void main(String[] args) {

        int[] array = new int[] {5, 4, 3, 2, 1}; // {5, 4, 7, 9, 2, 4, 4, 5, 6}; // {5, 4, 3, 2, 1};

        array = getRandomArray(100000);

        deltaTime1 = 0;
        deltaTime2 = 0;

        long start = System.nanoTime();

        // naive_implementation(array);

        smaller(array);

        // System.out.println(Arrays.toString(map_burst(array)));

        // map_burst(array);

        // TreeSet<Integer> set = new TreeSet<>();

        // System.out.println(Arrays.toString(naive_implementation(array)));

        // System.out.println(Arrays.toString());

        long finish = System.nanoTime();

        System.out.println("\nПрошло времени в микросекундах : " + (finish - start) / 1000);
        System.out.println("\n delta time1 = " + deltaTime1 / 1000);
        System.out.println("\n delta time2 = " + deltaTime2 / 1000);
    }

    public static int[] smaller(int[] unsorted) {
        // at the every algorithm's step: at first, we get an element (beginning from the rightmost one, moving to the left),
        // then we find the position of it in the sorted right-elements list through a bin search along this sorted array;
        // finally, we use its index to define the resulting array's value in the current cell
        ArrayList<Integer> rightInts = new ArrayList<>();

        for(int i = unsorted.length - 1; i >= 0; i--)
        {
            if (rightInts.size() == 0) {
                rightInts.add(unsorted[i]);
                unsorted[i] = 0;
            }
            else {
                long init = System.nanoTime();

                int index = bin_search(rightInts, unsorted[i]);
                // System.out.println("index = " + index);

                long start = System.nanoTime();

                rightInts.add(index, unsorted[i]);

                long finish = System.nanoTime();

                deltaTime1 += start - init;
                deltaTime2 += finish - start;

                // System.out.println(rightInts);
                unsorted[i] = index;
            }
        }

        return unsorted;
    }

    public static int[] naive_implementation(int[] unsorted) {

        int n = unsorted.length;

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;

            for (int j = i + 1; j <= n - 1; j++) {
                if (unsorted[i] > unsorted[j]) sum++;
            }

            result[i] = sum;
        }

        return result;
    }

    public static int[] map_burst(int[] unsorted) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = unsorted.length - 1; i >= 0; i--) {

            if (map.size() == 0) {
                map.put(unsorted[i], 1);
                unsorted[i] = 0;
            }
            else {
                if (map.containsKey(unsorted[i])) {
                    map.put(unsorted[i], map.get(unsorted[i]) + 1);
                }
                else {
                    map.put(unsorted[i], 1);
                }
            }

            int index = 0;

            // map.forEach((key, value) -> System.out.println(key + ":" + value ));
            // System.out.println("\n");

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getKey() < unsorted[i]) {
                    index += entry.getValue();
                }
                else break;
            }

            unsorted[i] = index;
        }

        return unsorted;
    }

    public static int bin_search(ArrayList<Integer> sorted, int target) {

        if (target < sorted.get(0)) return 0;

        return recursive_seeker(sorted, target, 0, sorted.size() - 1);
    }

    // some addition to binary search
    public static int recursive_seeker(ArrayList<Integer> nums, int target, int left_border, int right_border) {

        //base case if()
        if (left_border == right_border) {
            // System.out.println("left_border = " + left_border);
            if (nums.get(left_border) == target || target < nums.get(left_border)) return left_border;
            else return left_border + 1;
        }

        // median evaluating
        int pivot_index = (left_border + right_border) >>> 1;

        int pivot_element = nums.get(pivot_index);

        // comparison with pivot element
        if (pivot_element < target) return recursive_seeker(nums, target, pivot_index + 1, right_border);
        else return recursive_seeker(nums, target, left_border, pivot_index);
        // left rec + right rec
    }

    public static int[] getRandomArray(int length) {
        Random random = new Random();

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000000);
        }

        return array;
    }
}
