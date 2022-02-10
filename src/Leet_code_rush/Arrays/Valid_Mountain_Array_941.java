package Leet_code_rush.Arrays;

public class Valid_Mountain_Array_941 { /** accepted 36 **/

    public static void main(String[] args) {

        int[] array = new int[]{0,3,2,1};

        System.out.println(validMountainArray(array));

    }

    public static boolean validMountainArray(int[] arr) {

        int n = arr.length - 1;
        int i = 0;

        if (arr.length < 3) return false;

        while (i < n && arr[i] < arr[i + 1]) i ++;

        System.out.println("n = " + n + " i = " + i);

        if (i == 0 || i == n) return false;

        while (i < n && arr[i] > arr[i + 1]) i ++;

        System.out.println("n = " + n + " i = " + i);

        return i == n;

    }

}
