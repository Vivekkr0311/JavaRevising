package com.Vivek.LeetCode.Maths;

import java.util.Scanner;

public class Four_Divisors_1390 {
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean hasExactlyFourDivisors(int n) {

        // Case 1: p³
        int cubeRoot = (int) Math.round(Math.cbrt(n));
        if (cubeRoot * cubeRoot * cubeRoot == n && isPrime(cubeRoot)) {
            return true;
        }

        // Case 2: p × q
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int other = n / i;
                if (i != other && isPrime(i) && isPrime(other)) {
                    return true;
                }
                return false;
            }
        }

        return false;
    }

    private static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (hasExactlyFourDivisors(num)) {
                int tempSum = 0;
                for (int i = 1; i * i <= num; i++) {
                    if (num % i == 0) {
                        tempSum += i;
                        if (i != num / i) {
                            tempSum += num / i;
                        }
                    }
                }
                sum += tempSum;
            }
        }
        return sum;
    }

    private static int findSumOfDivisors (int n) {
        int divisorSum = 0;
        int count = 0;

        for (int fact = 1; fact * fact <= n; fact++) {
            if (n % fact == 0) {
                int otherFact = n / fact;

                // perfect square
                if (otherFact == fact) {
                    count++; divisorSum += fact;
                } else {
                    count += 2; divisorSum += fact + otherFact;
                }
            }

            // we need exactly four divisor number
            if (count > 4) {
                return 0;
            }
        }

        return count == 4 ? divisorSum : 0;
    }

    private static int sumFourDivisors__(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += findSumOfDivisors(num);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Sum of divisors of numbers with exactly four divisors: " + sumFourDivisors(nums));
        System.out.println("Sum of divisors of numbers with exactly four divisors: " + sumFourDivisors__(nums));
    }
}
