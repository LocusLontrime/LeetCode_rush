package Leet_code_rush.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_2_119 { /** accepted **/

    public static void main(String[] args) {

        System.out.println(getRow(33));

    }

    public static List<Integer> getRow(int rowIndex) {

        ArrayList<Integer> list = new ArrayList<>();

        if (rowIndex == 0) {
            list.add(1);
            return list;
        }

        if (rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }

        int[] array_prev = new int[] {1, 1};
        int[] array_curr = new int[] {};

        for (int i = 0; i < rowIndex - 1; i ++) {

            array_curr = new int[array_prev.length + 1];

            for (int j = 0; j < array_curr.length; j ++) {

                if (j != 0 && j != array_curr.length - 1) array_curr[j] = array_prev[j - 1] + array_prev[j];
                else array_curr[j] = 1;
            }

            array_prev = array_curr;
        }

        for (int i = 0; i < array_curr.length; i ++) {
            list.add(array_curr[i]);
        }

        return list;

    }

}
