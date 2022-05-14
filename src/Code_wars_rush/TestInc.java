package Code_wars_rush;

public class TestInc {

    public static void main(String[] args) { // translation of a number to an array

        int n = 1948653673;

        int[] arr = Integer.toString(n).chars().map(a->a-'0').toArray();

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
