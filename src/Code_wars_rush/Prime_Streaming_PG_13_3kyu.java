package Code_wars_rush;

import java.util.stream.IntStream;

public class Prime_Streaming_PG_13_3kyu {

    boolean[] primes;

    Prime_Streaming_PG_13_3kyu() {
        int prime_threshold = 25_000_000; // upper border of primes in stream
        int sqrt = (int) Math.sqrt(prime_threshold); // sqrt of upper border -> we need it for Eratosthenes' sieve implementation

        primes = new boolean[25_000_000];
        primes[0] = false;
        primes[1] = false;

        int i = 2;
        while (i < sqrt) {
            for (int j = i * i; j < prime_threshold; j += i) {
                primes[j] = false;
            }
            i++;
        }
    }

    public static IntStream stream() {
        boolean[] ps = new Prime_Streaming_PG_13_3kyu().primes;
        return IntStream.iterate(2, i -> i + 1);
    }
}
