package com.Vivek.LeetCode.Maths;

import java.util.Scanner;

public class TypeOfTriangle_3024 {
    private static String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c || b + c <= a || a + c <= b) {
            return "none";
        }

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];

        System.out.println("Enter side a: ");
        nums[0] = scanner.nextInt();

        System.out.println("Enter side b: ");
        nums[1] = scanner.nextInt();

        System.out.println("Enter side c: ");
        nums[2] = scanner.nextInt();

        System.out.println("triangle type: " + triangleType(nums));
    }
}
