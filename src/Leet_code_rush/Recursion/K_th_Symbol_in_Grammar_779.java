package Leet_code_rush.Recursion;

public class K_th_Symbol_in_Grammar_779 { /** accepted **/

    public static void main(String[] args) {

        System.out.println(kthGrammar(5, 3));

        System.out.println(kthGrammar(1, 1));

        System.out.println(kthGrammar(2, 1));

        System.out.println(kthGrammar(2, 2));

        System.out.println(kthGrammar(30, 11534));

    //0
    //01
    //0110
    //01101001
    //0110100110010110

    }

    public static int kthGrammar(int n, int k) {

        return recursive_symbol(n , k);

    }

    public static int recursive_symbol (int n, int k) {

        if (n == 1) return 0;

        if (k <= Math.pow(2, n - 2)) return recursive_symbol(n - 1, k);
        else return recursive_symbol(n - 1, k - (int) Math.pow(2, n - 2)) == 1? 0 : 1;

    }

}
