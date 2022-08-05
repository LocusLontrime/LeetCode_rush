package Code_wars_rush;

public class Persistent_Bugger_6kyu {

    public static void main(String[] args) {

        System.out.println(persistence(999));

        System.out.println(persistence(25));
    }

    public static int persistence(long n) {

        int counter = 0;

        while (n >= 10) {

            counter += 1;

            n = getNext(n, 1);
        }

        return counter;
    }

    public static long getNext(long n, long multiplication) {

        if (n == 0) {
            return multiplication;
        }

        return getNext(n / 10, multiplication * (n % 10));

    }
}
