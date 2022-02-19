package Leet_code_rush.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permutations_II47 {

    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {

        int[] array = new int[] {5, 3, 4, 3, 3, 5, 1, 2};
        System.out.println(permuteUnique(array));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, map.get(num));
        }

        recursiveSeeker(map);
        return list;
    }

    public static HashMap<Integer, Integer> recursiveSeeker (HashMap<Integer, Integer> map) {

        return new HashMap<>();

    }

}
