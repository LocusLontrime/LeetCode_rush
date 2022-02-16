package Leet_code_rush.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class Trapping_Rain_Water_42 { /** accepted (speed: 1ms, ultra-fast) **/

    public static void main(String[] args) {

        // int[] array = new int[] {10000,1,10000}; //{4,2,0,3,2,5}; //{0,1,0,2,1,0,1,3,2,1,2,1};

        long finish1 = System.nanoTime();

        System.out.println(trap(randomArrayGenerator(1000000, 1000000)));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish2 - finish1) / 1000 + " microsec");

        // int[][] matrix = randomMatrixGenerator(25, 25, 100);

        // for (int j = 0; j < matrix.length; j++) {

        //    System.out.println(Arrays.toString(matrix[j]));

        //}

        // System.out.println(Arrays.toString(randomArrayGenerator(25, 1000)));

    }

    public static int trap(int[] height) {

        int temporalMax;
        int innerTemporalMax = 0;

        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int rainVolume = 0;

        while (leftPointer <= rightPointer) {

            if (height[leftPointer] > height[rightPointer]) {

                temporalMax = height[leftPointer];

                while (leftPointer <= rightPointer && height[rightPointer] <= temporalMax) {

                    if (innerTemporalMax < height[rightPointer]) {
                        innerTemporalMax = height[rightPointer];
                    }

                    if (height[rightPointer] < innerTemporalMax) {
                        rainVolume += innerTemporalMax - height[rightPointer];
                    }

                    rightPointer--;

                }

            } else {

                temporalMax = height[rightPointer];
                innerTemporalMax = height[leftPointer];

                while (leftPointer <= rightPointer && height[leftPointer] <= temporalMax) {

                    if (innerTemporalMax < height[leftPointer]) {
                        innerTemporalMax = height[leftPointer];
                    }

                    if (height[leftPointer] < innerTemporalMax) {
                        rainVolume += innerTemporalMax - height[leftPointer];
                    }

                    leftPointer++;

                }

            }

        }

        return rainVolume;

    }

    public static int[][] randomMatrixGenerator (int jMax, int iMax, int maxElement) {

        int[][] matrix = new int[jMax][iMax];

        for (int j = 0; j < jMax; j++) {

            for (int i = 0; i < iMax; i++) {

                matrix[j][i] = (int) (maxElement * Math.random());

            }

        }

        return matrix;

    }

    public static int[] randomArrayGenerator (int iMax, int maxElement) {

        int[] array = new int[iMax];

        for (int i = 0; i < iMax; i++) {

            array[i] = (int) (maxElement * Math.random());

        }

        return array;

    }

}
