package Code_wars_rush;

import java.math.BigInteger;

public class Faberge_Easter_Eggs_3kyu {

    public static void main(String[] args) {

        System.out.println(height(new BigInteger("2"), new BigInteger("6")));

    }

    public static BigInteger height(BigInteger n, BigInteger m) {

        // base case
        if (n.compareTo(BigInteger.ZERO) == 0 || m.compareTo(BigInteger.ZERO) == 0) {
            System.out.println("n = " + n + " m = " + m);
            return BigInteger.ZERO;  // TODO replace with your solution
        }

        // body of rec -> nothing

        // recurrent relation
        return height(n.subtract(BigInteger.ONE), m.subtract(BigInteger.ONE)).add(height(n, m.subtract(BigInteger.ONE))).add(BigInteger.ONE);
    }
}
