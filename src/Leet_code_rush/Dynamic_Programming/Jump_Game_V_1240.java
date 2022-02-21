package Leet_code_rush.Dynamic_Programming;

import java.util.Arrays;

public class Jump_Game_V_1240 { /** 366 accepted (speed: 9ms, ultra-fast, beats 94,92% of java submissions) **/
    static int[] memoTable;

    public static void main(String[] args) {
        int[] array = new int[] {66,43,55,1,3,66,6,7,55,4,89,15,13,11,16,69,77,277,177,1,55,919,98,119,98,11,99,111,77,166,67,355,43,11,35,36,355,118,117,777,771,998,989}; //{6,4,14,6,8,13,9,7,10,6,12};
        int d = 6; //2;

        //array = new int[] {3,3,3,3,3};
        //d = 3;

        long start = System.nanoTime();
        System.out.println(maxJumps(array,d));
        long finish = System.nanoTime();

        System.out.println("Прошло времени в микросекундах : " + (finish - start) / 1000);
    }

    public static int maxJumps(int[] arr, int d) {
        int maxIndexesNum = 0;

        memoTable = new int[arr.length];
        Arrays.fill(memoTable, -1);

        for (int i = 0; i < arr.length; i++) maxIndexesNum = Math.max(maxIndexesNum, recursiveSeeker(arr, d, i));

        return maxIndexesNum;
    }

    public static int recursiveSeeker(int[] arr, int d, int i) {

        if (memoTable[i] == -1) {

            int currentMaxIndexesNum = 0;

            for (int j = i + 1; j <= Math.min(i + d, arr.length - 1); j++) {
                if (arr[j] < arr[i]) currentMaxIndexesNum = Math.max(currentMaxIndexesNum, recursiveSeeker(arr, d, j));
                else break;
            }

            for (int j = i - 1; j >= Math.max(i - d, 0); j--) {
                if (arr[j] < arr[i]) currentMaxIndexesNum = Math.max(currentMaxIndexesNum, recursiveSeeker(arr, d, j));
                else break;
            }

            memoTable[i] = ++currentMaxIndexesNum;

        }

        return memoTable[i];
    }
}
