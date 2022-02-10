package Leet_code_rush.Bits_Manipulation;

public class Power_of_Two_231 {

    public static void main(String[] args) { /** accepted (speed: ultra-fast, 1ms, beats 99,35 submissions) **/

        long start = System.nanoTime();

        System.out.println(isPowerOfTwo(1024));

        long finish1 = System.nanoTime();

        System.out.println("t1 = " + (finish1 - start) / 1000 + " microsec");

    }

    public static boolean isPowerOfTwo(int n) {

        return n != 0 && ((long) n & -(long) n) == (long) n;

    }

}
