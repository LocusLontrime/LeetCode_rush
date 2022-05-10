package Code_wars_rush;

public class Can_you_really_count_divisors_4kyu {

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println(countDivisors(1000000000000000000L));

        long finish = System.nanoTime();

        System.out.println("\nПрошло времени в милисекундах : " + (finish - start) / 1000000);

    }

    public static long countDivisors(long n) {

        long res = 0;

        for (int i = 1; i < (int) Math.sqrt(n) + 1; i++) {

            res += n / i;

        }

        res *= 2;

        long intRoot = (int) Math.sqrt(n);

        res -= intRoot * intRoot;

        return res;
    }
}
