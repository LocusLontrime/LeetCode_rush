package Code_wars_rush;

import java.math.BigInteger;
import java.util.HashSet;

public class Differentiate_a_polynomial_4kyu { // accepted on codewars.com

    public static HashSet<Integer> digits = new HashSet<Integer>() { }; // dig dictionary (set)

    static {
        for (int i = 0; i < 10; i ++) digits.add(i); // filling the dig set
    }

    public static void main(String[] args) {

        System.out.println(differentiate("12x+2", 3));
        System.out.println(differentiate("x^2-x", 3));
        System.out.println(differentiate("-5x^2+10x+4", 3));
        System.out.println(differentiate("x^2+3x+2", 3));
    }

    public static BigInteger differentiate(String equation, long x) {
        // Your code here!
        Polynomial polynomial = new Polynomial(equation);

        polynomial = polynomial.DiffPol();

        return polynomial.GetValueAtPoint(x);
    }

    public static class Polynomial
    {
        public long[] polynomial; // "x^22+33x+2"

        public Polynomial(int power) // base constructor
        {
            if (power >= 0)
            {
                polynomial = new long[power + 1]; // pol's array initialization
            }
            else
            {
                throw new ArithmeticException("The polynomial's power cannot be less than zero");
            }
        }

        public Polynomial(String s) // -5x^2+10x+4678
        {
            int power = GetMaxPowerFromString(s);
            polynomial = new long[power + 1];
            int j = 0; // walking dead index

            while (true) {

                boolean isNeg = false;
                long num = 0;
                power = 0;

                if (j < s.length() &&  s.charAt(j) == '-') // if we
                {
                    isNeg = true;
                    j++;
                }

                while (j < s.length() && digits.contains(Character.getNumericValue(s.charAt(j))))
                {
                    num *= 10;
                    num += Character.getNumericValue(s.charAt(j));
                    j++;
                }

                if (j == s.length())
                {
                    this.polynomial[0] = num;
                    break;
                }

                if (num == 0) num = 1;
                if (isNeg) num *= -1;

                if (s.charAt(j) == 'x')
                {
                    j++;

                    if (j < s.length() && s.charAt(j) == '^')
                    {
                        j++;

                        while (j < s.length() && digits.contains(Character.getNumericValue(s.charAt(j))))
                        {
                            power *= 10;
                            power += Character.getNumericValue(s.charAt(j++));
                        }
                    }
                    else
                    {
                        power = 1;
                    }
                }

                this.polynomial[(int) power] = num;

                if (j == s.length() - 1 && digits.contains(Character.getNumericValue(s.charAt(j)))) break;
                if (j < s.length() && s.charAt(j) == '+') j++;
            }
        }

        public static int GetMaxPowerFromString(String s) // Levi Jean edition
        {
            int i = 0;

            while (i < s.length() && s.charAt(i) != 'x') // "17x^2+1111111x"
            {
                i++;
            }

            if (i == s.length()) return 0;
            else if (i + 1 == s.length()) return 1;
            else if (s.charAt(++i) != '^') return 1;
            else
            {
                int power = 0;
                i++;

                while (i < s.length() && digits.contains(Character.getNumericValue(s.charAt(i))))
                {
                    power *= 10;
                    power += Character.getNumericValue(s.charAt(i++));
                }

                return power;
            }
        }

        public Polynomial DiffPol()
        {
            // border case of pol.length == 1

            if (GetPower() == 1) return ZeroPolynomial();

            Polynomial newPol = new Polynomial(GetPower() - 1 - 1);

            for (int i = 0; i < GetPower() - 1; i ++)
            {
                newPol.polynomial[newPol.polynomial.length - i - 1] = (this.polynomial.length - i - 1) * this.polynomial[this.polynomial.length - i - 1];
            }

            return newPol;
        }

        public BigInteger GetValueAtPoint(long x)
        {
            BigInteger value = BigInteger.ZERO;

            for (int i = 0; i < this.polynomial.length; i++) value = value.add(BigInteger.valueOf(this.polynomial[i]).multiply(BigInteger.valueOf(x).pow(i)));

            return value;
        }

        public int GetPower()
        { // returns length of polynomial (power + 1)
            return polynomial.length;
        }

        public Polynomial Copy()
        { // makes the copy of base polynomial to prevent the changes in the base polynomial when the copy is being operated

            Polynomial copy = new Polynomial(GetPower() - 1);

            for (int i = 0; i < GetPower(); i++)
            {

                copy.polynomial[i] = this.polynomial[i];

            }

            return copy;
        }

        public static Polynomial ZeroPolynomial()
        { // creates a zero Polynomial
            Polynomial zeroP = new Polynomial(0);
            zeroP.polynomial[0] = 0;

            return zeroP;
        }
    }
}
