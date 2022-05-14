package Code_wars_rush;

import java.math.BigInteger;

public class The_fusc_function_Part_2 {

    public static void main(String[] args) { // not accepted, too slow because od dividing by 2

        long start = System.nanoTime();

        // System.out.println("4496047232746033439866332574607641115185289828815659836877207557974698638551430698226403383854431074455323285812344476437334109742500243442945967768558521790671067401423809250553312923996658420643391496408098163895264498830090255970293513331630261702288646149000136895514918279039816543329290294321200");

        System.out.println();

        System.out.println(fusc(BigInteger.valueOf(2).pow(100000).add(new BigInteger("4496047232746033439866332574607641115185289828815659836877207557974698638551430698226403383854431074455323285812344476437334109742500243442945967768558521790671067401423809250553312923996658420643391496408098163895264498830090255970293513331630261702288646149000136895514918279039816543329290294321200"))));

        long finish1 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start) / 1000 + " microsec");
    }

    public static BigInteger fusc (BigInteger n) {

        BigInteger p = BigInteger.ZERO;
        BigInteger q = BigInteger.ONE;

        while (n.compareTo(BigInteger.ZERO) > 0)
        {
            if (n.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0)
            {
                q = p.add(q);
                n = n.divide(BigInteger.valueOf(2));
            }
            else
            {
                p = p.add(q);
                n = n.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));
            }
        }

        return p;
    }
}
