package JavaExceptions.HomeWork2;

public class Task3 {

    public static void main(String[] args) {

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex1) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex2) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException ex3) {
            System.out.println("Деление на ноль!");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
