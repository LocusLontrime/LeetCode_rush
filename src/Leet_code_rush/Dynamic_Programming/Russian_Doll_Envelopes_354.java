package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelopes_354 { /** accepted (speed: fast) **/

    public static void main(String[] args) {

        int[][] envelopes = new int[][]{{1,2},{3,4},{5,7},{1,2},{12, 15},{5, 3},{7, 8},{9, 5},{7, 2},{15, 7},{7, 6},{5, 5},{5, 5},{17, 11},{2, 3},{3, 2},{3, 3},{25, 17},{98, 9},{98, 989}};

        System.out.println(maxEnvelopes(envelopes));

        int[] nums = new int[]{1, 2, 4, 5, 7, 4, 6, 7, 8, 15, 34, 15, 98, 2, 989, 5, 65, 666, 76, 4, 2, 0, 0, 0, 1, 34, 67, 98, 989};

        System.out.println(LIS(nums));

    }

    public static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });

        for (int[] i : envelopes) {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }

        System.out.println();

        int max_length = 0;
        int[] sub_array = new int[envelopes.length];

        for (int[] num : envelopes) {

            int index = Arrays.binarySearch(sub_array, 0, max_length, num[1]); // return the index of element or possible index at which the element would be inserted into an array (then it returns -k - 1)

            if (index < 0) {

                index = -(index + 1);
                sub_array[index] = num[1];
                if (index == max_length) max_length++;
            }

        }

        return max_length;

        //return LIS(second_parameter_array);

    }

    public static int LIS (int[] nums) {

        int max_length = 0;
        int[] sub_array = new int[nums.length];

        for (int num : nums) {

            int index = Arrays.binarySearch(sub_array, 0, max_length, num); // return the index of element or possible index at which the element would be inserted into an array (then it returns -k - 1)

            if (index < 0) index = -(index + 1);

            sub_array[index] = num;

            if (index == max_length) max_length++;

        }

        return max_length;

    }

}
