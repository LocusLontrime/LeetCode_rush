package Leet_code_rush.String;

public class Check_if_All_As_Appears_Before_All_Bs_2124 { /** accepted (speed 0ms, fast) **/

    public static void main(String[] args) {

        String s = "";

        System.out.println(checkString(s));

    }

    public static boolean checkString(String s) {
        for (int i = 0; i < s.length() - 1; i++ ) if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') return false;
        return true;
    }

}
