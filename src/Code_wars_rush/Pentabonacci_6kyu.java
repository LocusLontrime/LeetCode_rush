package Code_wars_rush;

public class Pentabonacci_6kyu { // accepted on codewars.com

    public static void main(String[] args) {

        System.out.println(countOddPentaFib(15));

    }

    public static long countOddPentaFib(long n) {
        // your code
        int counter = 0;

        int x1 = 0;
        int x2 = 1;
        int x3 = 1;
        int x4 = 2;
        int x5 = 4;

        for (int i = 0; i < n; i++) {

            x5 = x1 + x2 + x3 + x4 + x5;
            x4 = x5 - (x1 + x2 + x3 + x4);
            x3 = x5 - (x1 + x2 + x3 + x4);
            x2 = x5 - (x1 + x2 + x3 + x4);
            x1 = x5 - (x1 + x2 + x3 + x4);

            if (x1 % 2 != 0) counter++;
        }

        return n > 1 ? counter - 1 : counter;
    }
}
