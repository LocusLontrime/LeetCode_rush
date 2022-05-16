package Code_wars_rush;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insane_Coloured_Triangles_2kyu { // accepted on codewars.com
    public static final List<Character> colours = Arrays.asList('R', 'G', 'B'); // possible colours
    public static final List<Integer> special_lengths = new ArrayList<>();

    static {
        special_lengths.add(0);
        for (int i = 1; i < 12; i ++) special_lengths.add((int) Math.pow(3, i));
    }

    public static void main(String[] args) {
        System.out.println(special_lengths);
        System.out.println(triangle("RGBBRRGBR"));
    }

    public static char triangle(final String row) {
        // Locus Lontrime 36 366 98 989
        int l = row.length();

        if(l <= 3) return solveTheRemainPart(row); // here we are using the simple met

        int elementsToBeCut;
        int i = 1;

        while (special_lengths.get(++i) < l); // here we define the max special length, that is not larger than l

        elementsToBeCut = special_lengths.get(i - 1);

        System.out.println(l + " " + elementsToBeCut);

        String leftElementsRemained = row.substring(0, l - elementsToBeCut); // here we are getting two simplified subStrings
        String rightElementsRemained = row.substring(elementsToBeCut, l);

        System.out.println(leftElementsRemained + " " + rightElementsRemained);

        char leftOne = triangle(leftElementsRemained); // now obtaining left final char
        char rightOne = triangle(rightElementsRemained); // and right final one

        if (leftOne == rightOne) return leftOne; // 4ex: GG -> G
        else return "RGB".charAt(3 - colours.indexOf(leftOne) - colours.indexOf(rightOne)); // 4ex: RG -> B

        // return solveTheRemainPart(leftOne + "" + rightOne);
    }

    public static char solveTheRemainPart(final String remain) { // the simple method, solving the colours sequences that is not longer than 3 characters

        StringBuilder strBuilder = new StringBuilder(remain);

        while (strBuilder.length() >= 2) {

            for (int index = 0; index < strBuilder.length() - 1; index++) {

                char leftOne = strBuilder.charAt(index);
                char rightOne = strBuilder.charAt(index + 1);

                // System.out.println("leftOne = " + leftOne + " rightOne = " + rightOne);

                strBuilder.setCharAt(index, leftOne == rightOne ? leftOne : "RGB".charAt(3 - colours.indexOf(leftOne) - colours.indexOf(rightOne)));
            }

            strBuilder.delete(strBuilder.length() - 1, strBuilder.length());

            // System.out.println("stringBuilder length = " + strBuilder.length());
        }

        return strBuilder.toString().charAt(0);
    }
}
