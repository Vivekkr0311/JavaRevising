package com.Vivek.Hackerrank.ProblemSolving;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BetweenTwoSets {
    private static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    private static int findGCD(List<Integer> nums) {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = gcd(result, nums.get(i));

            if (result == 1) {
                break;
            }
        }
        return result;
    }

    private static int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGCD(n2, n1 % n2);
    }

    private static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }

    private static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        // Get LCM of all elements of a
        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer);
        }

        // Get GCD of all elements of b
        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer);
        }

        // Count multiples of lcm that divide the gcd
        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;

            if (gcd % multiple == 0)
                result++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of element of set1: ");
        int n1 = scanner.nextInt();

        System.out.println("Enter the number of elements of set2: ");
        int n2 = scanner.nextInt();

        System.out.println("Enter each element of set1: ");
        List<Integer> set1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int temp = scanner.nextInt();
            set1.add(temp);
        }

        System.out.println("Enter each element of set2: ");
        List<Integer> set2 = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            int temp = scanner.nextInt();
            set2.add(temp);
        }

        System.out.println("Between the sets: " + getTotalX(set1, set2));
    }
}
