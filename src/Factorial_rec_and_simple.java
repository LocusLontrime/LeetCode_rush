public class Factorial_rec_and_simple {

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println(factorial_recursive(36));

        long finish1 = System.nanoTime();

        System.out.println(factorial(36));

        long finish2 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start));

        System.out.println("t2 = " + (finish2 - start));


    }

    public static long factorial_recursive (int n) {

        if (n == 1) return 1;

        return factorial_recursive(n - 1) * n;

    }

    public static long factorial (int n) {

        long F = 1;

        for (int i = 2; i <= n; i ++) F = F * i;

        return F;

    }

}
