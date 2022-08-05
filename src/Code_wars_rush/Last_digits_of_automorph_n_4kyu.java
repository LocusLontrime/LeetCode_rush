package Code_wars_rush;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Last_digits_of_automorph_n_4kyu {

    public static int counter;
    public static BigInteger res;

    public static void main(String[] args) {

        int base = 10;
        int digits = 12;

        long start = System.nanoTime();

        // System.out.println(hensels_lemma(base, digits));

//        System.out.println(get(30000));
        System.out.println(get(10));
        System.out.println(get(130));

        long finish = System.nanoTime();

        System.out.println("\nПрошло времени в милисекундах : " + (finish - start) / 1000 + " solCounter:");

    }

    public static BigInteger get(int n) {

        if (n == 1) {
            return BigInteger.ONE;
        }

        TreeSet<BigInteger> treeSet = new TreeSet<>();

        addNumber(treeSet, n + n / 5);

        BigInteger[] bigIntegers = treeSet.toArray(new BigInteger[]{});

        return bigIntegers[n - 2];
    }

    public static void addNumber(TreeSet<BigInteger> treeSet, int number) {

        int digitNo = 2;
        int counter = 2;

        BigInteger num = new BigInteger("5");
        treeSet.add(num);

        BigInteger num2 = new BigInteger("6");
        treeSet.add(num2);

        while (counter < number) {

            BigInteger numSquared = num.multiply(num); // 625
            BigInteger powOfTen = new BigInteger("10").pow(digitNo); // 1000

            num = numSquared.mod(powOfTen);
            num2 = powOfTen.add(new BigInteger("1")).subtract(num); // 76

            treeSet.add(num);
            treeSet.add(num2);

            counter += 2;
            digitNo++;
        }
    }

    public static ArrayList<BigInteger> hensels_lemma(int base, int power) { // TODO Hensel's lemma

        if (power == 0) {

            ArrayList<BigInteger> list = new ArrayList<BigInteger>();
            list.add(BigInteger.ZERO);

            return list;
        }

        ArrayList<BigInteger> roots = hensels_lemma(base, power - 1); // rec call

        ArrayList<BigInteger> new_roots = new ArrayList<BigInteger>();

            for (BigInteger root : roots)  {

                for (int i = 0; i < base; i ++) {

                    BigInteger new_i = BigInteger.valueOf(i).multiply(BigInteger.valueOf(base).pow(power - 1)).add(root);

                    BigInteger new_root = automorphic_polynomial(new_i).remainder(BigInteger.valueOf(base).pow(power));

                    if (new_root.compareTo(BigInteger.ZERO) == 0) {

                        new_roots.add(new_i);
                    }
                }
            }

            return new_roots;
    }

    public static BigInteger automorphic_polynomial(BigInteger x) {

            return x.multiply(x).subtract(x);

    }
}
