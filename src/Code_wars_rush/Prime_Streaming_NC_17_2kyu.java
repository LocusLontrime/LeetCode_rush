// accepted on codewars.com 2kyu and 3 kyu
package Code_wars_rush;
import java.util.*;
import java.util.stream.*;

public class Prime_Streaming_NC_17_2kyu {
    public static BitSet primesBitset = new BitSet();

    public static void generatePrimes() {
        int prime_threshold = 850_000_000; // upper border of primes in stream, 850 for 2 kyu
        int sqrt = (int) Math.sqrt(prime_threshold); // sqrt of upper border -> we need it for Eratosthenes' sieve implementation

        primesBitset = new BitSet(prime_threshold); // set for filtering out all the non-prime numbers
        primesBitset.set(2, prime_threshold-1); // at the beginning all the numbers (except 1, not a prime)) marked with '1' (True)

        // a simple realization of an Eratosthenes' sieve using BitSet (only 1 bit per cell)
        int i = 1;
        while (i < sqrt) {
            i = primesBitset.nextSetBit(i + 1);
            for (int j = i * i; j < prime_threshold; j += i) {
                primesBitset.clear(j);
            }
        }
    }

    public static IntStream stream() { // stream of primes
        if (Prime_Streaming_NC_17_2kyu.primesBitset.isEmpty()) generatePrimes();
        return IntStream.iterate(2, i -> Prime_Streaming_NC_17_2kyu.primesBitset.nextSetBit(i + 1));
    }

    public static void main(String[] args) { // tests
        int[] primesFound = Prime_Streaming_NC_17_2kyu.stream().skip(10).limit(10).toArray();
        for (int prime : primesFound) System.out.print(prime + " ");
    }
}