package JavaExceptions.HomeWork1;

public class Task3 {

    public static void main(String[] args) {

        printArray1D(arraysDifference(new int[]{98, 9, 98998}, new int[]{1, 2, 3}));

        printArray1D(arraysDifference(new int[]{98, 9, 98998}, new int[]{1, 2, 3, 4}));
    }

    public static int[] arraysDifference(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            System.out.println("Opoveschayu kak-to.");
            return new int[]{};
        } else {
            int[] resArr = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                resArr[i] = arr1[i] - arr2[i];
            }
            return resArr;
        }
    }

    public static void printArray1D(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
