package com.Vivek.Hackerrank.ProblemSolving;

import java.util.ArrayList;
import java.util.Scanner;

public class FactorialOfALargeNumber {
    private static void multiply(ArrayList<Integer> table, int multiplier) {
        int carry = 0;

        // Multiply each digit by the current multiplier
        for (int i = 0; i < table.size(); i++) {
            int result = table.get(i) * multiplier + carry;
            table.set(i, result % 10);
            carry = result / 10;
        }

        // Add remaining carry as new digits
        while (carry > 0) {
            table.add(carry % 10);
            carry /= 10;
        }
    }

    private static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> table = new ArrayList<>();
        table.add(1);  // Factorial of 0 is 1

        for (int multiplier = 2; multiplier <= n; multiplier++) {
            multiply(table, multiplier);
        }

        // Reverse the result to display correctly
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = table.size() - 1; i >= 0; i--) {
            ans.add(table.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();

        System.out.println(factorial(n));
    }
}
