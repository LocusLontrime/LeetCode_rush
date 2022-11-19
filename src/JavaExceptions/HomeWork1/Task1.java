package JavaExceptions.HomeWork1;

public class Task1 {

    public static void main(String[] args) {
        // method1();
        // method2();
        // method3();
    }

    public static void method1() {

        int a = 98, b = 0;

        System.out.println(a / b);
    }

    public static void method2() {

        int[] array = new int[]{989, 1, 98, 98989};

        System.out.println(array[98]);
    }

    public static void method3() {

        method3();
    }
}
