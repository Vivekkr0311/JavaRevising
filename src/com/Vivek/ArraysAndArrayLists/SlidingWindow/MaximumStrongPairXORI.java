package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MaximumStrongPairXORI {
    private static int maximumStrongPairXorBruteForce(int[] nums){
        int maximumXorValue = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                boolean strongPairCondition = Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j]);

                int currXorValue = nums[i] ^ nums[j];

                if(strongPairCondition && currXorValue > maximumXorValue){
                    maximumXorValue = currXorValue;
                }
            }
        }
        return maximumXorValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Maximum XOR value: " + maximumStrongPairXorBruteForce(nums));
    }
}
