package Code_wars_rush;

public class Find_nth_Digit_In_a_Infinite_Addition_Result_3kyu { // accepted on codewars.com

    public static void main(String[] args) {

//        System.out.println(getNumberIn(10, false)[2]);
//        System.out.println(getNumberIn(10, true)[2]);
//
//        System.out.println(findDigit(10));

//        System.out.println(findDigit(1000));
//        System.out.println(findDigit(10000));
//        System.out.println(findDigit(100000));
//        System.out.println(findDigit(1000000));
//        System.out.println(findDigit(10000000));
//        System.out.println(findDigit(100000000));
        System.out.println(findDigit(1000000000));

//
//        System.out.println(findDigit(9));
//        System.out.println(findDigit(10));


//        int l = 1000;
//
//        System.out.println(getNumberIn(l, false)[2]);
//        System.out.println(getNumberIn(l, true)[2]);

//        System.out.println("symbol: " + getSquares(1000).charAt(1));

        System.out.println("427591343603996142759135668209004275913697601841".length());

    }

    public static int findDigit(int n) {

        // here we obtain some data about positions in infinity sequences  and starting digits
        int[] data_linear = getNumberIn(n + 1, false);
        int[] data_square = getNumberIn(n + 1, true);

        // lengths of first element in two new numbers sequences needed for defining the result
        int length_linear = ("" + data_linear[0]).length();
        long squared = (long) data_square[0] * (long) data_square[0];
        int length_square = ("" + squared).length();

        // possible answer if it is not changed because of next digits
        int possibleDigit = data_linear[2] + data_square[2];

        // sequences of numbers effecting on possible answer
        String str_linear = data_linear[0] + "" + (data_linear[0] + 1);
        String str_square = squared + "" + (squared + 2 * (long) data_square[0] + 1);

        // pointer in seq strings
        int pointer_linear = length_linear + data_linear[1] -1;
        int pointer_square = length_square + data_square[1] -1;

        // cycling through sequences
        while (true) {

            // extending the sequnces if some pointer exceeds the string length
            if (pointer_linear <= str_linear.length()) {
                str_linear += (data_linear[0] + 2);
                data_linear[0] += 1;
            }
            if (pointer_square <= str_square.length()) {
                long delta_squared = (long) (data_square[0] + 2) * (long) (data_square[0] + 2);
                str_square += delta_squared;
                data_square[0] += 1;
            }

            // step of the pointers
            pointer_linear += 1;
            pointer_square += 1;

            System.out.printf("pointer_l: %d, pointer_s: %d, str linear: %s, str square %s\n", pointer_linear, pointer_square, str_linear, str_square);

            // next digit of infinite sum
            int current_digit = Character.getNumericValue(str_linear.charAt(pointer_linear)) + Character.getNumericValue(str_square.charAt(pointer_square));

            // condition of getting the answer or proceeding to the next iteration of cycle
            if (current_digit < 9) {
                // the next digits cannot change the possible answer -> return
                return possibleDigit % 10;
            }
            else if (current_digit == 9) {
                // the next digits can change the possible answer -> continue
            }
            else {
                // the next digits have changed the possible answer -> getting the answer
                return (possibleDigit + 1) % 10;
            }
        }
    }

    public static int[] getNumberIn(int number, boolean isSquare) { // gets the digit of numbers and squares sequences depending on flag isSquare

        int[] data = getPowersOfTenIn(number, isSquare);

        System.out.printf("power: %d, length before max power of ten: %d\n", data[0], data[1]);

        int maxNumBeforeMaxPowerOfTen = isSquare ? (int) (data[0] % 2 == 0 ? Math.pow(10, data[0] / 2) - 1: Math.sqrt(Math.pow(10, data[0]))) : (int) Math.pow(10, data[0]) - 1;

        System.out.printf("max num before power of ten: %d\n", maxNumBeforeMaxPowerOfTen);

        int k = (number - data[1]) / (data[0] + 1);

        long maxNumBeforeTheNumGiven = maxNumBeforeMaxPowerOfTen + k;

        int indexOfDigit = number - data[1] - k * (data[0] + 1);

        System.out.printf("k: %d, max num: %d, index of digit: %d\n", k, maxNumBeforeTheNumGiven, indexOfDigit);

        long digit;

        if (isSquare) {
            long square = maxNumBeforeTheNumGiven * maxNumBeforeTheNumGiven;
            long squareNext = square + 2 * maxNumBeforeTheNumGiven + 1;
            System.out.println(squareNext);
            digit = indexOfDigit == 0 ? square % 10 : Character.getNumericValue(("" + squareNext).charAt(indexOfDigit - 1));
        }
        else {
            digit = indexOfDigit == 0 ? maxNumBeforeTheNumGiven % 10 : Character.getNumericValue(("" + (maxNumBeforeTheNumGiven + 1)).charAt(indexOfDigit - 1));
        }

        return new int[] {(int)maxNumBeforeTheNumGiven, indexOfDigit, (int)digit};
    }

    public static int[] getPowersOfTenIn(int num, boolean isSquares) { // gets the max power of ten all numbers or squares before which are all located in sequence before index = num

        long aggregatedLength = 0;

        int i = 1;
        long multiplier = isSquares ? 3 : 9;
        long last_multiplier = multiplier;
        while (true) {

            long new_length = aggregatedLength + multiplier * i;

            if (num - new_length < 0) {
                i -= 1;
                break;
            }
            else if (num - new_length == 0) {
                aggregatedLength = new_length;
                break;
            }
            else aggregatedLength = new_length;

            if (isSquares) {

                int new_multiplier = i % 2 != 0 ? (int) Math.pow(10, (i + 1) / 2) - 1: (int) Math.sqrt(Math.pow(10, i + 1));
                multiplier = new_multiplier - last_multiplier;
                System.out.printf("multiplier: %d, l multiplier: %d\n", multiplier, last_multiplier);
                last_multiplier = new_multiplier;

            } else multiplier *= 10;

            i += 1;
        }

        return new int[] {i, (int) aggregatedLength};
    }

    public static String getSquares(int n) {

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            result.append(i * i);

        }

        return result.toString();
    }
}
