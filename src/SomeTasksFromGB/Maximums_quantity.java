package SomeTasksFromGB;

public class Maximums_quantity {

    static int[] numbers = {1, 8, 3, 8, 2, 6, 8, 8, 7, 8, 8, 8, 8};
    int speed = 6;

    public static void main(String[] args) {

        System.out.println("Maximums quantity = " + max_q());

    }

    public static int max_q () {

        int index = 0;
        int maximum = numbers[index];
        int count_maximal = 0;

        while (index < numbers.length) {

            if (numbers[index] > maximum) {

                maximum = numbers[index];
                count_maximal = 1;

            } else {
                if (numbers[index] == maximum) count_maximal++;
            }

            index++;
        }

        return count_maximal;
    }

}
