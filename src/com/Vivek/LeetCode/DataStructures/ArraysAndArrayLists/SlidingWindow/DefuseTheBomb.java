package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

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

    private static int[] decryptBruteForce(int[] nums, int k){
        if(k > 0){
            // forward sum
            return forwardSum(nums, k);
        }else if(k < 0){
            // backward sum
            return backwardSum(nums, k * (-1));
        }
        return new int[nums.length];
    }


    private static int[] decrypt(int[] nums, int k){
        if(k == 0){
            return new int[nums.length];
        }
        int n = nums.length;
        int i =  -1; int j  = -1;
        if(k > 0){
            i = 1;
            j = k;
        }else {
            i = n - k * (-1);
            j = n - 1;
        }

        int[] result = new int[n];
        int firstWindowSum = 0;
        for(int pointer = i; pointer <= j; pointer++){
            firstWindowSum += nums[pointer];
        }

        for(int pointer = 0; pointer < n; pointer++){
            result[pointer] = firstWindowSum;

            firstWindowSum -= nums[i % n];
            i++;

            firstWindowSum += nums[(j + 1) % n];
            j++;
        }
        return result;
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
