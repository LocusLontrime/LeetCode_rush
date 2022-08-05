package Code_wars_rush;

public class Largest_5_digit_number_in_a_series_7kyu {

    public static void main(String[] args) {

        System.out.println(solve("12345678912345"));

        System.out.println(translate("123456789"));

        System.out.println(solve("283910"));

    }

    public static int solve(final String digits) {

        String max = digits.substring(0, 5);

        for (int i = 0; i + 5 <= digits.length(); i++) { // 12345

            String str = digits.substring(i, i + 5);

            if (str.compareTo(max) > 0) {
                max = str;
            }
        }

        return translate(max); // you code here
    }

    public static int translate(String number) {

        int n = 0;

        for (int i = 0; i < number.length(); i++) {

            n *= 10;

            n += Character.getNumericValue(number.charAt(i));
        }

        return n;
    }

}
