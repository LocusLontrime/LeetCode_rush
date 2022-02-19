package Leet_code_rush.String;

public class Minimum_Deletions_to_Make_String_Balanced_1653 {

    public static void main(String[] args) {
        String s = "aaabaaabaaabaa";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {

        int BsCounter = 0;
        int maxDeletions = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'b') BsCounter++;
            else maxDeletions++;

            maxDeletions = Math.min(maxDeletions, BsCounter);

        }

        return maxDeletions;
    }
}
