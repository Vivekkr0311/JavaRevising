package com.Vivek.LeetCode.Maths;

import java.util.Arrays;
import java.util.Scanner;

public class LargestPerimeterTriangle_976 {
    private static int largestPerimeter(int[] nums){
        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 2; i--){
            if(nums[i] < nums[i - 1] + nums[i - 2]){
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println("Largest perimeter of triangle is: " + largestPerimeter(nums));
    }
}
