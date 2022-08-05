package Code_wars_rush;

import java.util.Arrays;

public class Integer_Square_Root_2kyu { // TODO 2 kyu int square root accepted on codewars.com, 4kyu factorial version too

    public static int recCounter;

    public static void main(String[] args) throws Exception { // 366

        long start = System.nanoTime();

        // BigInteger A = new BigInteger("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789");
        // BigInteger B = new BigInteger("987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321987654321");

        // A.multiply(B).printBigInteger();

        BigInteger N = new BigInteger("2323232832321543534534534534345809885675655680940084098098098098080909234324324324324309879963");

        BigInteger sqrt = N.sqrt();

        System.out.print("Sqrt of " + N + " = " + sqrt);

//        System.out.println("factorial = " + BigInteger.factorial(1000));

        long finish = System.nanoTime();

        java.math.BigInteger big;

        System.out.println("\nПрошло времени в микросекундах : " + (finish - start) / 1000);
    }

    public static class BigInteger {

        public static final int KARATSUBA_THRESHOLD = 80; // needs to be tested a bit

        public static BigInteger ZERO = new BigInteger(new int[] { 0 });

        public static BigInteger ONE = new BigInteger(new int[] { 1 });

        int[] number; // array of digits

        public BigInteger(int length) {

            number = new int[length]; // digits array zero-initialization

        }

        public BigInteger(int[] array) {

            number = array.clone();

        }

        public BigInteger(String number) {

            this(number.length()); // digits array initialization

            for (int i = 0; i < this.number.length; i++)
            {
                this.number[i] = Character.getNumericValue(number.charAt(i));
            }
        }

        public static BigInteger factorial (int n)
        {
            BigInteger res = BigInteger.ONE;

            for (int i = 1; i <= n; i++)
            {
                res = res.multiply(new BigInteger(new int[]{i})); // long num multiplied by short one
            }

            return res;
        }

        public BigInteger sqrt() throws Exception {

            recCounter = 0;

            if (this.number.length == 1) {

                return new BigInteger (new int[] { (int) Math.sqrt(this.number[0]) });

            }

            if (this.number.length >= 4) {

            BigInteger[] borders = getBorders();

            return binSearch(borders[0], borders[1], this);

            } else {

                return binSearch(BigInteger.ZERO, this, this);

            }
        }

        public BigInteger binSearch(BigInteger leftBorder, BigInteger rightBorder, BigInteger N) throws Exception {

            recCounter++;

            BigInteger pivotElement = leftBorder.add(rightBorder);

            pivotElement.divideByTwo();

            BigInteger square = pivotElement.multiply(pivotElement);
            BigInteger nextSquare = square.add(pivotElement.multiply(new BigInteger("2")).add(BigInteger.ONE));

            System.out.println(recCounter + "-th current pivot element equals: " + pivotElement );

            Thread.sleep(100);

            if (square.compareTo(N) == 0 ||
                    ( square.compareTo(N) == -1 && nextSquare.compareTo(N) == 1) ) {
                return pivotElement;
            }
            else if (square.compareTo(N) == 1) {
                return binSearch(leftBorder, pivotElement, N);
            } else {
                return binSearch(pivotElement, rightBorder, N);
            }
        }

        public BigInteger[] getBorders() {

            int length = this.number.length;

            BigInteger leftB, rightB;

            int[] leftArray, rightArray;

            if (length % 2 == 0) {

                leftArray = new int[length / 2];
                rightArray = new int[length / 2 + 1];

                Arrays.fill(leftArray, 0);
                Arrays.fill(rightArray, 0);

                leftArray[0] = 3;
                leftArray[1] = 1;

                rightArray[0] = 1;

            } else {

                leftArray = new int[length / 2 + 1];
                rightArray = new int[length / 2 + 1];

                Arrays.fill(leftArray, 0);
                Arrays.fill(rightArray, 0);

                leftArray[0] = 1;

                rightArray[0] = 3;
                rightArray[1] = 2;
            }

            leftB = new BigInteger(leftArray);
            rightB = new BigInteger(rightArray);

            return new BigInteger[] {leftB, rightB};
        }

        public BigInteger add(BigInteger num) {

            int[] sum = new int[Math.max(this.number.length, num.number.length) + 1];

            int temporal = 0;

            for (int i = 0; i < sum.length; i++)
            {
                int currSum = (this.number.length - i - 1 >= 0 ? this.number[this.number.length - i - 1] : 0 ) +
                        (num.number.length - i - 1 >= 0? num.number[num.number.length - i - 1] : 0 ) + temporal;

                if (currSum <= 9)
                {
                    sum[sum.length - i - 1] = currSum;
                    temporal = 0;
                }
                else
                {
                    sum[sum.length - i - 1] = currSum % 10;
                    temporal = 1;
                }
            }

            BigInteger res = new BigInteger(sum);
            res.removeLeadingZero();

            return res;
        }

        public void substractOne() {

            if (this.number.length == 1) {

                this.number[0]--;

            } else {

                for (int i = this.number.length - 1; i >= 0; i--) {

                    if (this.number[i] != 0) {

                        this.number[i]--;
                        break;

                    } else {
                        this.number[i] = 9;
                    }
                }
            }

            removeLeadingZero();
        }

        public BigInteger multiply(BigInteger num) { // num -> 2nd number in the multiplication scheme

            BigInteger multiplication = new BigInteger(this.number.length + num.number.length);
            BigInteger left, right;

            left = new BigInteger(this.number);
            right = new BigInteger(num.number); // should be less than left to decrease the runtime of executing

            while (right.compareTo(ZERO) != 0) {

                if (right.isDivisibleByTwo()) {

                    left = left.add(left);
                    right.divideByTwo();

                } else {

                    right.substractOne();
                    multiplication = multiplication.add(left);
                }
            }

            multiplication.removeLeadingZero();

            return multiplication;
        }

        public BigInteger multiply_Karatsuba(BigInteger num) // is it needed???
        {

            return BigInteger.ZERO;
        }

        public boolean isDivisibleByTwo () {

            return this.number[this.number.length - 1] % 2 == 0;
        }

        public void divideByTwo() {

            int cf = 0;
            int i = 0;

            while (i < number.length) {

                int t = number[i] + cf * 10;

                number[i] = t / 2;

                cf = t % 2;

                i++;
            }

            removeLeadingZero();
        }
        public void removeLeadingZero() {

            if (this.number.length > 1 && this.number[0] == 0) { // checks if the long number has leading null

                this.number = Arrays.copyOfRange(this.number, 1, this.number.length);
            }
        }

        public int compareTo(BigInteger num) {

            if (this.number.length != num.number.length) {

                if (this.number.length > num.number.length) return 1;
                else return -1;
            }

            for (int i = 0; i < num.number.length; i++) {

                if (this.number[i] != num.number[i]) {

                    if (this.number[i] > num.number[i]) return 1;
                    else return -1;
                }

            }

            return 0;
        }

        public void printBigInteger() {

            for (int i : this.number)  {
                System.out.print(i);
            }
        }

        public String toString() {

            StringBuilder s = new StringBuilder("");

            for (int i : this.number) {
                s.append(i);
            }

            return s.toString();
        }
    }
}
