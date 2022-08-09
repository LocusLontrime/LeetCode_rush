package SeminarsJavaCore.HomeWork2;

public class MergeSort {

    private static int[]array;
    private static long stepsCounter;

    public static void main(String[] args) {

        array = arrayRandomFulfilling(25);
        System.out.print("Initial array: ");
        printArray(array);

        stepsCounter = 0;

        long start = System.nanoTime();

        mergeSort(array, 0, array.length - 1);

        long finish = System.nanoTime();

        System.out.println("Time elapsed (microseconds): " + (finish - start) / 1000);

        System.out.println("Merges done " + stepsCounter + " steps");

        System.out.print("Array sorted: ");
        printArray(array);
    }

    public static void mergeSort (int[] array, int startingIndex, int endingIndex) {

        int median = (startingIndex + endingIndex) / 2; // or a + (b - a) / 2

        if (startingIndex < endingIndex) {

            mergeSort(array, startingIndex, median); // divide and conquer strategy section, initial array is dividing into 2 parts until sub-arrays become of 1 element
            mergeSort(array, median + 1, endingIndex);

            merge(array, startingIndex, median, endingIndex); // merging section, after the recursive stack reaches its bottom sub-arrays begin to merge from 1-element arrays to the final sorted one.
        }
    }

    public static void merge (int[] array, int startingIndex, int median, int endingIndex) { // merge algorithm, it needs some additional memory to run
        stepsCounter++;

        int[] auxiliaryArrayLeft = new int[median - startingIndex + 1]; // initialization of auxiliary arrays
        int[] auxiliaryArrayRight = new int[endingIndex - median];

        int i = 0;
        int j = 0;

        arrayCopy(auxiliaryArrayLeft, startingIndex, median); // fulfilling the auxiliary arrays
        arrayCopy(auxiliaryArrayRight, median + 1, endingIndex);

        while (i < auxiliaryArrayLeft.length && j < auxiliaryArrayRight.length) { // choosing the right elements from two sub-arrays and write them to final array

            if (auxiliaryArrayLeft[i] <= auxiliaryArrayRight[j]) {
                array[startingIndex + i + j] = auxiliaryArrayLeft[i++];
                // i ++;
            } else {
                array[startingIndex + i + j] = auxiliaryArrayRight[j++];
                // j ++;
            }
        }

        // working with tails
        for (int counter = i; counter < auxiliaryArrayLeft.length; counter ++) array[startingIndex + counter + j] = auxiliaryArrayLeft[counter];
        for (int counter = j; counter < auxiliaryArrayRight.length; counter ++) array[startingIndex + counter + i] = auxiliaryArrayRight[counter];
    }

    public static void arrayCopy (int[] array_to_save_copy, int left_border, int right_border) {

        for (int i = 0; i <= right_border - left_border; i ++) { // System.arraycopy() works too
            array_to_save_copy[i] = array[left_border + i];
        }
    }

    public static void printArray (int[] array) {

        for (int number : array) System.out.print(number + " ");
        System.out.println();
    }

    public static int [] arrayRandomFulfilling (int array_length) {

        int [] array = new int [array_length];

        for (int i = 0; i < array_length; i++) {
            array[i] = (int) (Math.random() * array_length);
        }

        return array;
    }
}
