package Leet_code_rush.Arrays;

public class Merge_Sorted_Array_88 {

    public static void main(String[] args) { /** accepted (speed: fast) **/

        int[] nums1 = new int[] {1,2,3,6,17,25,77,0,0,0,0};
        int[] nums2 = new int[] {12,15,16,23};
        int m = 7, n = 4;

        nums1 = new int[] {0, 0, 0, 0, 0};
        nums2 = new int[] {1, 2, 5, 6, 7};
        m = 0;
        n = 5;

        merge(nums1, m, nums2, n);
        array_print(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int nums2_pointer = n - 1;
        int nums1_pointer = m - 1;

        for (int i = 0; i < m + n + 1; i ++) {
            if (nums2[nums2_pointer] > nums1[nums1_pointer]) {
                System.out.println("nums1 " + (m + n - 1 - i) + "-element = " + nums2[nums2_pointer] + " nums2 el");
                nums1[m + n - 1 - i] = nums2[nums2_pointer];
                if (nums2_pointer == 0) break;
                nums2_pointer--;
            } else {
                System.out.println("nums1 " + (m + n - 1 - i) + "-element = " + nums1[nums1_pointer] + " nums1 el");
                nums1[m + n - 1 - i] = nums1[nums1_pointer];
                if (nums1_pointer == 0) {
                    while (nums2_pointer >= 0) {
                        nums1[nums2_pointer] = nums2[nums2_pointer];
                        nums2_pointer--;
                    }
                    break;
                }
                nums1_pointer--;
            }
        }
    }

    public static void array_print (int[] array) {
        for (int j : array) System.out.print(j + " "); // enhanced for
        System.out.println();
    }
}
