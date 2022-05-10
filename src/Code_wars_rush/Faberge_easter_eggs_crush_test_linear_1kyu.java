package Code_wars_rush;

import java.math.BigInteger;
import java.util.ArrayList;

public class Faberge_easter_eggs_crush_test_linear_1kyu { // accepted, but need some explanation

    public static ArrayList<BigInteger> haha_inv = new ArrayList<BigInteger>();

    static {
        haha_inv.add(BigInteger.ZERO);
        haha_inv.add(BigInteger.ONE);
    }

    private static BigInteger modulo = BigInteger.valueOf(998244353);

    public static void main(String[] args) {

        long start = System.nanoTime();

        // System.out.println(height(BigInteger.valueOf(40000),BigInteger.valueOf(80000)));

        // System.out.println(height_alt(BigInteger.valueOf(40000),BigInteger.valueOf(80000)));

        // System.out.println(height_alt(BigInteger.valueOf(70000), BigInteger.valueOf(100000)));

        System.out.println(height(BigInteger.valueOf(10000), BigInteger.valueOf(100000)));

        long finish = System.nanoTime();

        // BigInteger n = new BigInteger("123456789");
        // System.out.println(n.intValue());

        System.out.println("\nПрошло времени в милисекундах : " + (finish - start) / 1000000);
    }

    public static BigInteger height(BigInteger n, BigInteger m) {

        for (int haha_i = 2; haha_i < 80000 + 1; haha_i++) {

            haha_inv.add((modulo.subtract(modulo.divide(BigInteger.valueOf(haha_i)))).
                    multiply(haha_inv.get(modulo.remainder(BigInteger.valueOf(haha_i)).intValue()).remainder(modulo)));
        }

        BigInteger delta;

        if (n.compareTo(m) >= 0) return baseSummand(m).remainder(modulo); // power of two case

        if (n.multiply(BigInteger.valueOf(2)).compareTo(m) <= 0) {

            delta = combsSum(n.intValue(), m).remainder(modulo);

            return delta.subtract(BigInteger.ONE);
        }
        else {

            delta = combsSum(m.intValue() - n.intValue() - 1, m).remainder(modulo);
            BigInteger res = baseSummand(m).remainder(modulo).subtract(delta);

            return res.compareTo(BigInteger.ZERO) >= 0 ? res : res.add(modulo);
        }
    }

    public static BigInteger combsSum(int count, BigInteger m) { // a crucial optimization

        m = m.remainder(modulo);

        BigInteger delta = BigInteger.ONE;
        BigInteger currDelta = BigInteger.ONE;

        for (int i = 1; i <= count; i++) {

            currDelta = currDelta.multiply(m.subtract(BigInteger.valueOf(i - 1))).multiply(haha_inv.get(i)).remainder(modulo);

            delta = delta.add(currDelta);
        }

        return delta;
    }

    public static BigInteger baseSummand(BigInteger m) {
        return BigInteger.valueOf(2).pow(m.intValue()).subtract(BigInteger.ONE);
    }
}
