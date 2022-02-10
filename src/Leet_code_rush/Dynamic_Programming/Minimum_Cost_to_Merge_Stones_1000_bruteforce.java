package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Minimum_Cost_to_Merge_Stones_1000_bruteforce { /** runtime error **/

    static int cons_max;

    public static void main(String[] args) {

        int[] array = new int[]{3, 1, 4, 3, 6, 6, 98, 66, 6, 67, 54, 32, 98, 99, 100, 7, 87, 6, 7, 8, 7, 98, 87, 8, 98};
        //array = new int[]{3,2,4,1};
        //array = new int[]{3,5,1,2,6};
        int k = 4;
        //k = 2;
        //k = 5;

        long finish1 = System.nanoTime();

        System.out.println(mergeStones(array, k));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

        System.out.println();

    }

    public static int mergeStones(int[] stones, int k) {

        if ((stones.length - k) % (k - 1) != 0) return -1;

        List<Integer> stones_heap = Arrays.stream(stones)
                .boxed()
                .collect(Collectors.toList());

        cons_max = k;

        return recursive_seeker(stones_heap);
    }

    public static int recursive_seeker (List<Integer> stones_heap) {

        int stones_length = stones_heap.size();

        if (stones_length == cons_max) {
            int cost = 0;
            for (int i : stones_heap) {
                cost += i;
            }
            return cost;
        }

        ArrayList<Integer> stones = new ArrayList<>(stones_heap);

        int min_cost = Integer.MAX_VALUE;

        int curr_cost = 0;

        for (int j = 0; j < cons_max; j ++) curr_cost += stones_heap.get(j);

        for (int i = 0; i + cons_max <= stones_length; i ++) {

            if (i != 0 ) curr_cost += stones_heap.get(i + cons_max - 1) - stones_heap.get(i - 1);

            if (i + cons_max > i) {
                stones.subList(i, i + cons_max).clear();
            }

            stones.add(i, curr_cost);

            min_cost = Math.min(min_cost, curr_cost + recursive_seeker(stones));

            stones = new ArrayList<>(stones_heap);
        }

        return min_cost;

    }

}
