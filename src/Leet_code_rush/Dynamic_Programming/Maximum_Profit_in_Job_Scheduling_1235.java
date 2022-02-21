package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Maximum_Profit_in_Job_Scheduling_1235 {

    static int[] memoTable;

    public static void main(String[] args) { /** accepted (speed: 36ms, medium) **/

        int[] startTime = new int[] {1,2,3,4,6};
        int[] endTime = new int[] {3,5,10,6,9};
        int[] profit = new int[] {20,20,100,70,60};

        startTime = new int[] {43,13,36,31,40,5,47,13,28,16,2,11};
        endTime = new int[] {44,22,41,41,47,13,48,35,48,26,21,39};
        profit = new int[] {8,20,3,19,16,8,11,13,2,15,1,1};

        int[] stTime = new int[] {2,5,11,13,13,16,16,16,16,16,16,28,31,36,40,43,47}; // {1,2,2,11,11,11,11};//{2,5,11,13,13,16,28,31,36,40,43,47};
        int k = 16;

        System.out.println(binSearch(stTime, k));
        System.out.println(Arrays.binarySearch(stTime, k));
        System.out.println(11 + 15 >>> 1);

        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<List<Integer>> lists = new ArrayList<>(); // lists for storing three arrays of information

        for (int i = 0; i < startTime.length; i++) {
            lists.add(new ArrayList<>());
            lists.get(i).add(startTime[i]);
            lists.get(i).add(endTime[i]);
            lists.get(i).add(profit[i]);
        }

        lists.sort(Comparator.comparingInt(a -> a.get(0))); // changing comparator a bit to sort all the values in
        // a non-decreasing order

        for (List<Integer> i : lists) {
            System.out.println(i.get(0) + " " + i.get(1) + " " + i.get(2));
        }

        for (int i = 0; i < startTime.length; i++) { // so we can use binSearch in int[] startTime array
            startTime[i] = lists.get(i).get(0);
        }

        memoTable = new int[startTime.length]; // initializing the memo table

        Arrays.fill(memoTable, -1);

        return recursiveSeeker(lists, startTime, startTime.length,0); // starting recursion
    }

    public static int recursiveSeeker (List<List<Integer>> lists, int[] startTime, int length, int target) {

        if (target == length) return 0; // base case -> there is no longer a job to do

        if (memoTable[target] == -1) {

            int nextIndex = binSearch(startTime, lists.get(target).get(1));

            //int index = Arrays.binarySearch(startTime, lists.get(target).get(1));

            //int index = findNextJob(startTime, lists.get(target).get(1));

            //int nextIndex = index >= 0 ? index : - index - 1;

            // possible profit if we decided to do the next the nearest job after the last completed
            int nextProfit = recursiveSeeker(lists, startTime, length, nextIndex) + lists.get(target).get(2);

            // possible profit if we decided to skip one job and to do the next after it
            int skipOneJobProfit = recursiveSeeker(lists, startTime, length, target + 1);

            memoTable[target] = Math.max(nextProfit, skipOneJobProfit);
        }

        return memoTable[target];
    }

    public static int binSearch(int[] nums, int target) { // binSearch implementation

        if (target < nums[0]) return -1; // if the target is out of range to the left

        return recursiveBinSeeker(nums, target,0, nums.length - 1);
    }

    public static int recursiveBinSeeker(int[] nums, int target, int left_border, int right_border) {

        // if the target is out of range to the right
        if (target > nums[nums.length - 1]) return nums.length;

        // base case if()
        if (left_border == right_border) return left_border;

        // median evaluating

        int pivot_index = (left_border + right_border) >>> 1;

        int pivot_element = nums[pivot_index];

        // comparison with pivot element
        if (pivot_element < target) return recursiveBinSeeker(nums, target,pivot_index + 1, right_border);
        else return recursiveBinSeeker(nums, target, left_border, pivot_index);
        // left rec + right rec
    }

}
