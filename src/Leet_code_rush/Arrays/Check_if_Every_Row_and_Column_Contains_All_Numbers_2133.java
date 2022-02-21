package Leet_code_rush.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Check_if_Every_Row_and_Column_Contains_All_Numbers_2133 {

    public static void main(String[] args) { /** accepted (speed: 15ms, average) **/

        int[][] matrix = new int[][] {{1,2,3},{3,2,1},{2,3,1}};

        System.out.println(checkValid(matrix));
    }

    public static boolean checkValid(int[][] matrix) {

        HashSet<Integer> set = new HashSet<>();

        for (int[] ints : matrix) { // for rows

            set.clear();

            for (int i = 0; i < matrix.length; i++) {
                set.add(ints[i]);
            }

            if (set.size() != matrix.length) {
                return false;
            }

        }

        for (int i = 0; i < matrix.length; i++) {

            set.clear();

            for (int[] ints : matrix) {
                set.add(ints[i]);
            }

            if (set.size() != matrix.length) {
                return false;
            }

        }

       return true;
    }
}


