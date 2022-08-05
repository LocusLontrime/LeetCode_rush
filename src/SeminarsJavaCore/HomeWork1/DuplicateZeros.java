package SeminarsJavaCore.HomeWork1;


public class DuplicateZeros {

    public static void main(String[] args) {

        duplicateZeros(new int[] {1, 2, 3, 0, 9, 0, 0, 7, 9});
        duplicateZeros(new int[] {1,0,2,3,0,4,5,0});

    }

    public static void duplicateZeros(int[] arr) {

        int lastIndex = arr.length - 1; // last index
        int lastDupIndex = -1; // last duplicated one index

        // cycling all over the values of initial array (arr)
        for (int i = 0; i <= lastIndex; i++) {
            lastDupIndex += arr[i] == 0 ? 2 : 1;

            if (lastDupIndex == lastIndex) { // here the last item (duplicated or not) been added completely
                lastDupIndex = i;
                break;
            } else if (lastDupIndex > lastIndex) { // here the last item was a zero and its duplicate is out of bounds of arr
                arr[lastIndex] = 0; // just a one zero to the end of initial array
                lastIndex--;
                lastDupIndex = i - 1;
                break;
            }
        }

        for (int i = lastDupIndex; i >= 0 ; i--) {

            if (arr[i] == 0) {
                arr[lastIndex--] = 0;
                arr[lastIndex--] = 0;
            } else {
                arr[lastIndex--] = arr[i];
            }
        }

        // prints the outcome in one String:
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
