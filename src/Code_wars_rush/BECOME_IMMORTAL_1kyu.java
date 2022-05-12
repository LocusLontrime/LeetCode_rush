package Code_wars_rush;

import java.math.BigInteger;

public class BECOME_IMMORTAL_1kyu { // accepted on codewars.com 36 366 989 98

    public static void main(String[] args) {

        //System.out.println(elderAge(8, 5, 1, 100));
        //System.out.println(elderAge(8, 8, 0, 100007));
        //System.out.println(elderAge(25, 31, 0, 100007));
        //System.out.println(elderAge(5, 45, 3, 1000007));

        //System.out.println(elderAge(31, 39, 7, 2345));
        //System.out.println(elderAge(545, 435, 342, 1000007));

        // System.out.println(largerPowerOfTwo(35165045587L));

        System.out.println(Math.pow(2, 48));

        System.out.println(281474976710656L);

        System.out.println(elderAge(28827050410L, 35165045587L, 7109602, 13719506));
    }

    public static long elderAge(long n, long m, long k, long newp) {

        long elderYears = elder(m, n, k, newp);

        if (elderYears >= 0) return elderYears;
        else return newp + elderYears;
    }

    public static long elder(long n, long m, long k, long newp) { // main calculating method

        if (m == 0 || n == 0) return 0;

        if (n > m) {
            long temp = m;
            m = n;
            n = temp;
        }

        long lm = largerPowerOfTwo(m);
        long ln = largerPowerOfTwo(n);

        if (k > lm) return 0;

        if (lm == ln) return (rangeSum(1, ln - k - 1).multiply(BigInteger.valueOf(m + n - ln)).
                add(BigInteger.valueOf(elderAge(ln - n, lm - m, k, newp)))).remainder(BigInteger.valueOf(newp)).longValue();

        if (ln < lm) {

            ln = lm / 2;

            BigInteger temp = rangeSum(1, lm - k - 1).multiply(BigInteger.valueOf(n)).subtract(BigInteger.valueOf(lm - m).multiply(rangeSum(Math.max(0, ln - k), lm - k - 1)));

            if (k <= ln) temp = temp.add(BigInteger.valueOf(ln - k).multiply(BigInteger.valueOf( ln - n)).multiply (BigInteger.valueOf(lm - m))).add(BigInteger.valueOf(elderAge(ln - n, lm - m, 0, newp)));
            else temp = temp.add(BigInteger.valueOf(elderAge(ln - n, lm - m, k - ln, newp)));

            return temp.remainder(BigInteger.valueOf(newp)).longValue();
        }

        return 0;
    }

    public static long largerPowerOfTwo (long num) { // min power of two that is larger than the num

        long temp = 1;

        while (temp < num) temp <<= 1;

        return temp;
    }

    public static BigInteger rangeSum(long leftB, long rightB) { // sum of consecutive integers from leftB to rightB

        BigInteger lB = BigInteger.valueOf(leftB);
        BigInteger rB = BigInteger.valueOf(rightB);

        return (lB.add(rB)).multiply(rB.subtract(lB).add(BigInteger.ONE)).divide(BigInteger.valueOf(2));

    }
}
