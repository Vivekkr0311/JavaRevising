package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class DefuseTheBomb {
    private static int[] forwardSum(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int sum = 0;
            int steps = 1;

            while(steps <= k){
                int idx = (i + steps) % n;
                sum = sum + nums[idx];
                steps++;
            }

            res[i] = sum;
        }
        return res;
    }

    private static int[] backwardSum(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int sum = 0;
            int steps = 1;

            while(steps <= k){
                int idx = (i - steps + n) % n;
                sum = sum + nums[idx];
                steps++;
            }

            res[i] = sum;
        }
        return res;
    }

    private static int[] decrypt(int[] nums, int k){
        if(k > 0){
            // forward sum
            return forwardSum(nums, k);
        }else if(k < 0){
            // backward sum
            return backwardSum(nums, k * (-1));
        }
        return new int[nums.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements ");
        int n = scanner.nextInt();

        System.out.println("Enter each element: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();

        System.out.println("Code to defuse the bomb is: " + Arrays.toString(decrypt(nums, k)));
    }
}
