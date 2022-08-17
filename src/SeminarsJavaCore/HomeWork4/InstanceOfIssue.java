package SeminarsJavaCore.HomeWork4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstanceOfIssue {

    public static void main(String[] args) {
        Double d = 10e111d;
        Character ch = '(';
        List<Object> list = new ArrayList<>(Arrays.asList("Lala", 98, 989.98d));

        long start = System.nanoTime();

        for (int i = 0; i < 10000000; i++) {
//            if (d instanceof Double) {
//
//            }

            methodRet(i % 11);
        }

        long finish = System.nanoTime();

        for (int i = 0; i < 10000000; i++) {
//            if (ch == '(') {
//
//            }

            methodRes(i % 11);
        }

        long finishAll = System.nanoTime();

        System.out.println("\nПрошло времени в микросекундах 1mln instance of : " + (finish - start) / 1000);
        System.out.println("\nПрошло времени в микросекундах 1mln char comparison : " + (finishAll - finish) / 1000);
    }

    public static int methodRet(int n) {

        switch (n) {
            case 0:
                return 98;
            case 1:
                return 9898;
            case 2:
                return 98998;
            case 3:
                return 989;
            case 4:
                return 98;
            case 5:
                return 9;
            case 6:
                return 989898;
            case 7:
                return 98998989;
            case 8:
                return 9899899;
            case 9:
                return 9891;
            case 10:
                return 9899819;
        }

        return 989;
    }

    public static int methodRes(int n) {

        int res =98919;

        switch (n) {
            case 0:
                res = 98;
                break;
            case 1:
                res = 9898;
                break;
            case 2:
                res = 98998;
                break;
            case 3:
                res = 989;
                break;
            case 4:
                res = 981;
                break;
            case 5:
                res = 9;
                break;
            case 6:
                res = 989898;
                break;
            case 7:
                res = 98998989;
                break;
            case 8:
                res = 9899899;
                break;
            case 9:
                res = 9891;
                break;
            case 10:
                res = 9899819;
                break;
        }

        return res;
    }
}
