package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=false
public class DivisibleSumPair {
//    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
//        // Write your code here
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        int result = 0;
//        for (int i : ar) {
//            int diff = (k - (i % k)) % k;
//            freq.put(diff, freq.getOrDefault(diff, 0) + 1);
//        }
//
//        for (int i : ar) {
//            int diff = (k - (i % k)) % k;
//            if (freq.containsKey(diff) && freq.get(diff) > 0 && freq.get(i) > 0) {
//                freq.put(diff, freq.get(diff) - 1);
//                freq.put(i, freq.get(i) - 1);
//                result++;
//            }
//        }
//        return result;
//    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int result = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                int sum = ar.get(i) + ar.get(j);

                if (sum % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of elements: ");
        int n = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        System.out.println("Enter each element: ");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("Number of pair present with sum: " + k + " is " + divisibleSumPairs(arr.size(), k, arr));
    }
}
