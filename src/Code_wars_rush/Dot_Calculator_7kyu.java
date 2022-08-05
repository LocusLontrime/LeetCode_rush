package Code_wars_rush;

public class Dot_Calculator_7kyu {  // accepted on codewars.com

    public static void main(String[] args) {

        // System.out.println(generatePoints(5, ""));

        System.out.println(calc("..... * ..............."));

        System.out.println(generatePointsFor(10));

    }

    public static String calc(String txt){

        String[] symbols = txt.split(" ");

        int length;
        int a = symbols[0].length();
        int b = symbols[2].length();

        switch (symbols[1]) {

            case "+":
                length = a + b;
                break;
            case "-":
                length = a - b;
                break;
            case "//":
                length = a / b;
                break;
            case "*":
                length = a * b;
                break;
            default:
                length = 0;
                break;
        }


        // return generatePointsFor(length);
        return generatePoints(length, new StringBuilder("")).toString();
    }

    // recursive method of building dot sequence
    public static StringBuilder generatePoints(int length, StringBuilder sequence) {

        // base case
        if (length == 0) {
            return sequence;
        }

        return generatePoints(length - 1, sequence.append("."));
    }

    public static String generatePointsFor(int length) {

        StringBuilder sequence = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sequence.append(".");
        }

        return sequence.toString();
    }
}
