package Leet_code_rush.Arrays;

public class Check_If_N_and_Its_Double_Exists_1346 { /** accepted (speed: slow) **/

    public static void main(String[] args) {

        int[] array = new int[] {10,2,5,3};

        System.out.println(checkIfExist(array));

    }

    public static boolean checkIfExist(int[] arr) {

        boolean is_true = false;

        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) is_true = true;
            }
        }
        return is_true;
    }

}
