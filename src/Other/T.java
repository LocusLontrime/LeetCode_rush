package Other;

import java.math.BigDecimal;
import java.math.BigInteger;

public class T {

    public static void main(String[] args) {

        System.out.println("Привет, Маркуша - Дундуша!!!");

        int a = 1000000000, b = 98; //3000000000; <Integer>

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        short A = Short.MAX_VALUE; //2^(n-1) - 1, -2^(n-1)
        short B = Short.MIN_VALUE;

        System.out.println(A + " " + B);

        byte p = Byte.MAX_VALUE;
        byte q = Byte.MIN_VALUE;

        System.out.println(p + " " + q);

        double P = 0.366f;
        double Q = 3.66E300;

        double D = Double.MAX_VALUE;
        double D1 = Double.MIN_VALUE;

        System.out.println(P + " " + Q);

        System.out.println(D + " " + D1);

        boolean t = true;
        boolean f = false;

        System.out.println(t + " " + f);

        int x = 98;

        System.out.println(x * x == 98 * 98);

        String s = "Markoosha-Dundusha";

        String s1 = s;

        s += "lala";

        System.out.println(s1 + " " + s);

        BigInteger bigInteger = new BigInteger("1111111111111111111111111111111111111111111111111111111111");

        System.out.println(bigInteger);

        BigInteger v = BigInteger.valueOf(6);

        System.out.println(v.pow(6 * 6 * 6 * 6 * 6 * 6));

        BigDecimal bigDecimal = new BigDecimal("3.6666666666666666666666666666666666666666666698989898989898989898989898989999999999999999999999999999999999999");

        System.out.println(bigDecimal.pow(11));

        System.out.println(BigInteger.valueOf(98).multiply(BigInteger.valueOf(98)));

        int counter = 1;

        while (counter <= 10) {

            System.out.println(counter * counter * counter);

            counter += 1;
        }

        for (int i = 1; i <= 10; i += 1) {

            System.out.println(i * i * i);

        }

        for (int i = 0; i <= 10; i++) {

            System.out.println(i * i * i);

        }

        // arrays

        int[] markoosha_nums = new int[10];

        int[] nums = new int[]{1, 2, 66, 98, 989, 98989};

        System.out.println(nums[5]);


    }

}
