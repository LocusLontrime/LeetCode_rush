package Code_wars_rush;
import java.util.Arrays;
import java.util.List;

public class Insane_Coloured_Triangles_2kyu {

    public static List<Character> colours = Arrays.asList('R', 'G', 'B'); // possible colours
    public static List<Integer> special_lengths = Arrays.asList(1, 4, 10, 28, 82, 244, 730, 2188, 6562, 19684, 59050, 177148); // kind of: 3^n + 1

    static {

        for (int i = 0; i < 12; i ++) {

            special_lengths.add((int) Math.pow(3, i));

        }

    }

    public static void main(String[] args) {

        System.out.println(triangle("RRR"));

    }

    public static char triangle(final String row) {

        int l = row.length();

        if(l <= 3) return solveTheRemainPart(row); // here we are using the simple met

        int elementsToBeCut;
        int i = 1;

        while (special_lengths.get(++i) <= l); // here we define the max special length, that is not larger than l

        elementsToBeCut = special_lengths.get(i - 1);

        System.out.println(l + " " + elementsToBeCut);

        String leftElementsRemained = row.substring(0, elementsToBeCut - 1); // here we are getting two simplified subStrings
        String rightElementsRemained = row.substring(l - elementsToBeCut + 1, l);

        char leftOne = triangle(leftElementsRemained); // now obtaining left final char
        char rightOne = triangle(rightElementsRemained); // and right final one

        if (leftOne == rightOne) return leftOne; // 4ex: GG -> G
        else return "RGB".charAt(3 - colours.indexOf(leftOne) - colours.indexOf(rightOne)); // 4ex: RG -> B
    }

    public static char solveTheRemainPart(final String remain) { // the simple method, solving the colours sequences that is not longer than 3 characters

        int i = 0;

        StringBuilder strBuilder = new StringBuilder(remain);

        while (strBuilder.length() >= 2) {

            for (int index = 0; index < strBuilder.length() - 1 - i; index++) {

                char leftOne = strBuilder.charAt(index);
                char rightOne = strBuilder.charAt(index + 1);

                strBuilder.setCharAt(index, leftOne == rightOne ? leftOne : "RGB".charAt(3 - colours.indexOf(leftOne) - colours.indexOf(rightOne)));
            }

            strBuilder.delete(strBuilder.length() - 1, strBuilder.length());

            i++;
        }

        return strBuilder.toString().charAt(0);
    }
}
