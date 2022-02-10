package Leet_code_rush.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array_448 {

    public static void main(String[] args) {

        int[] nums = new int[] {1,1}; //{4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(nums));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i ++) {
            list.add(i + 1);
        }

        for (int i = 0; i < nums.length; i ++) {
            if (list.contains(nums[i])) list.remove((Integer)nums[i]);
        }

        return list;

    }

}
