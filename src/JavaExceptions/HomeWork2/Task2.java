package JavaExceptions.HomeWork2;

public class Task2 {

    public static void main(String[] args) {

        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7};

        try {
            int d = 0;
            double caughtRes1 = intArray[8] / d;
            System.out.println("caughtRes1 = " + caughtRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e1) {  // addition to the original code
            System.out.println("Getting array element exception: " + e1);
        }
    }
}
