package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeQuestion3 {
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);

        // Check if a list of integers contains a prime number using Java streams:
        boolean result = numbers
                .stream()
                .anyMatch(n -> isPrime(n));

        System.out.print("Contains prime: ");
        System.out.println(result);

        // collect all primes
        List<Integer> primes = numbers
                .stream()
                .filter(n -> isPrime(n))
                .collect(Collectors.toList());

        System.out.print("Primes: ");
        System.out.println(primes);

        // collect all non-primes
        List<Integer> nonPrimes = numbers
                .stream()
                .filter(n -> !isPrime(n))
                .collect(Collectors.toList());

        System.out.print("Non-primes: ");
        System.out.println(nonPrimes);

        // collect all evens
        List<Integer> evens = numbers
                .stream()
                .filter(n -> (n & 1) == 0)
                .collect(Collectors.toList());

        System.out.print("Evens: ");
        System.out.println(evens);

        // collect all even and prime
        List<Integer> evenAndPrime = numbers
                .stream()
                .filter(n -> ((n & 1) == 0) && isPrime(n))
                .toList();

        System.out.print("Even and prime: ");
        System.out.println(evenAndPrime);

        // collect all odds
        List<Integer> odds = numbers
                .stream()
                .filter(n -> (n & 1) != 0)
                .toList();

        System.out.print("Odds: ");
        System.out.println(odds);
    }
}
