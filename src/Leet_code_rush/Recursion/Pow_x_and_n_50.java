package Leet_code_rush.Recursion;

public class Pow_x_and_n_50 { /** accepted (fast enough) **/

static int q = 0; // recursive counter

    public static void main(String[] args) {

        //System.out.println(myPow(10, 23));

        //System.out.println(myPow(10, -3));

        //System.out.println(myPow(1.0, Integer.MIN_VALUE));

        System.out.println(myPow(2.0, 64));

        System.out.println(q);

        System.out.println(myPow(2.0, 63));

        System.out.println(q);



    }

    public static double myPow(double x, int n) {

        q = 0;

        if (n > 0) return rec_Pow(x, n);
        else if (n == 0) return 1.0;
        else return 1.0 / rec_Pow(x, -n);

    }

    public static double rec_Pow (double x, int n) {

        if (x == 1.0) return 1.0;

        if (n == 0) return 1.0;
        if (n == 1) return x;

        double rec_res = rec_Pow(x, n / 2);

        if (n % 2 == 0) {
            q ++;
            return rec_res * rec_res;
        }
        else {
            q += 2;
            return rec_res * rec_res * x;
        }

    }

}
