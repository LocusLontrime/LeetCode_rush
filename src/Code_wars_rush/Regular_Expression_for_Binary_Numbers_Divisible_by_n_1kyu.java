package Code_wars_rush;

public class Regular_Expression_for_Binary_Numbers_Divisible_by_n_1kyu {

    public static void main(String[] args) {

        String str = "abcditiit*&$^&(aeouuuucmvjbg";

        str = str.replaceAll("(?i)[^aeiou]", "");

        System.out.println(str);
    }

}
