package Code_wars_rush;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Next_smaller_number_with_the_same_digits_4kyu { // accepted on codewars.com

    public static void main(String[] args) {

        System.out.println(nextSmaller(1236123456789L));

        System.out.println(nextSmaller(21));
        System.out.println(nextSmaller(531));
        System.out.println(nextSmaller(2071));
        System.out.println(nextSmaller(1027));
    }

    public static long nextSmaller(long n)
    {
        int length = (int) Math.log10(n) + 1;

        int[] array = recSeeker(n, length, new int[length], 0);

        System.out.println("initial number: " + n);

        System.out.println("array representation: " + Arrays.toString(array));

        int tailLength = 0;

        while (tailLength < array.length - 1 &&
                array[length - tailLength - 1] >= array[length - tailLength - 1 - 1]) {
            tailLength++;
        }

        if (++tailLength == length) return -1;

        int[] tailArray = Arrays.copyOfRange(array, array.length - tailLength, array.length);

        List<Integer> digits = Arrays.stream(tailArray)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("tailLength: " + tailLength);

        System.out.println("list: " + digits);

        int magicDigit = 0;

        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) < array[array.length - tailLength - 1]) {
                magicDigit = digits.get(i);
                break;
            }
        }

        digits.remove((Integer) magicDigit);
        digits.add(array[array.length - tailLength - 1]);

        array[array.length - tailLength - 1] = magicDigit;

        Collections.sort(digits);
        Collections.reverse(digits);

        for (int i = 0; i < digits.size(); i++) {
            array[i + array.length - tailLength] = digits.get(i);
        }

        System.out.println("res: " + Arrays.toString(array));

        if (array[0] == 0) return -1;

        n = 0;

        for (int i = 0; i < array.length; i++) {
            n = n * 10;
            n += array[i];
        }

        return n;
    }

    public static int[] recSeeker(long n, int length, int[] array, int count) {

        if (n == 0) return array;

        array[length - count - 1] = (int) (n % 10);

        return recSeeker(n / 10, length, array, count + 1);
    }
}
