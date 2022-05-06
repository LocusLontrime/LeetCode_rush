package Code_wars_rush;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Faberge {

    public static void main(String[] args) {
        // System.out.println(factorial(20000L));

        System.out.println(BigInteger.valueOf(2).pow(200));
    }

    public static BigInteger height(BigInteger eggs, BigInteger floor) { // main method
        if (eggs.compareTo(BigInteger.ZERO) == 0 || floor.compareTo(BigInteger.ZERO) == 0)
            return BigInteger.ZERO;
        return calculateBase(floor).subtract(calculateSmartSumOfDeltas(eggs, floor));
    }

    private static BigInteger calculateBase(BigInteger floor) {
        return BigInteger.valueOf(2).pow(floor.intValue()).subtract(BigInteger.ONE);
    }

    private static BigInteger calculateSmartSumOfDeltas(BigInteger eggs, BigInteger floor) { // sum of (C of k from n) row
        long diffBetweenFloorsAndEggs = floor.subtract(eggs).longValue();
        return LongStream.rangeClosed(0, diffBetweenFloorsAndEggs - 1).parallel().boxed().map(i -> facDiv(floor.longValue(), i)).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private static BigInteger factorial(Long n) { // calculates a factorial of the n given
        if (n == 0)
            return BigInteger.ONE;
        return LongStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private static BigInteger facDiv(Long n, Long i) { // combinations of k elements from n -> n! / ( k! * (n - k)! )
        if (n == 0 || i == 0)
            return BigInteger.ONE;
        BigInteger f_fac_divide_f_i_fac = LongStream.rangeClosed(n - i + 1L, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        return f_fac_divide_f_i_fac.divide(factorial(i));
    }

}
