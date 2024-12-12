package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicateII {
    private static boolean containsNearbyDuplicate(int[] nums, int k){
       Set<Integer> window = new HashSet<>();
       for(int i = 0; i < nums.length; i++){
           if(i > k){
               window.remove(nums[i - k - 1]);
           }

           if(!window.add(nums[i])){
               return true;
           }
       }
       return false;
    }

    private static boolean containsNearbyDuplicateTwo(int[] nums, int k){
        Set<Integer> window = new HashSet<>();
        int n = nums.length;
        int i = 0; int j = 0;

        while(j < n){
            if(Math.abs(i - j) > k){
                // shrink
                window.remove(nums[i]);
                i++;
            }

            if(window.contains(nums[j])){
                return true;
            }

            window.add(nums[j]);
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers ? ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter each element: ");
        for(int i = 0; i < n; i++){
            nums[i] =  scanner.nextInt();
        }

        System.out.println("Enter k: ");
        int k = scanner.nextInt();
        // This is faster than the other one.
        System.out.println(Arrays.toString(nums) + " contains duplicate " + containsNearbyDuplicate(nums, k));
        System.out.println(Arrays.toString(nums) + " contains duplicate " + containsNearbyDuplicateTwo(nums, k));
    }
}
