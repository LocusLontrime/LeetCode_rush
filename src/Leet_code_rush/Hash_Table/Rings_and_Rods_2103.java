package Leet_code_rush.Hash_Table;
import java.util.ArrayList;
import java.util.HashSet;

public class Rings_and_Rods_2103 { /** accepted (speed: 1ms, fast enough) **/

    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        rings = "B0B6G0R6R0R6G9B9R9";
        System.out.println(countPoints(rings));
    }

    public static int countPoints(String rings) {

        int numberOfRGBRods = 0;

        ArrayList<HashSet<Character>> sets = new ArrayList<>();

        for (int i = 0; i < 10; i ++) sets.add(new HashSet<Character>());

        int i = 0;

        while (i < rings.length()) {
            char char1 = rings.charAt(i++);
            char char2 = rings.charAt(i++);
            int rodNumber = Integer.parseInt(char2 + "");
            sets.get(rodNumber).add(char1);
        }

        for (HashSet<Character> set : sets) {
            if (set.size() == 3) numberOfRGBRods++;
        }

        return numberOfRGBRods;
    }
}
