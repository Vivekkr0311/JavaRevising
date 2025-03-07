package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DailyTemperatures_739 {
    private static int[] dailyTemperaturesSlidingWindow(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();

                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            for (int j = i + 1; j < temperatures.length; j++) {
                if (currTemp < temperatures[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element: ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Next greater temperature array: " + Arrays.toString(dailyTemperaturesBruteForce(nums)));
        System.out.println("Next greater temperature array: " + Arrays.toString(dailyTemperaturesSlidingWindow(nums)));
    }
}