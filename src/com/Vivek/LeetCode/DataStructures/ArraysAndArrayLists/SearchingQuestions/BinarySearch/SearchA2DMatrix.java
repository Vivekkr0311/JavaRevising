package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class SearchA2DMatrix {
    private static boolean binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    private static boolean search(int[][] matrix, int target){
        int x_first = 0;
        int x_last = 0;

        int y_first = 0;
        int y_last = matrix[0].length - 1;
        boolean isFound = false;

        if(matrix.length == 1){
            return binarySearch(matrix[0], target);
        }

        while(x_first < matrix.length && x_last < matrix.length){
            if(matrix[x_first][y_first] == target){
                return true;
            }

            if(target >= matrix[x_first][y_first]  && target <= matrix[x_last][y_last]){
                isFound =  binarySearch(matrix[x_first], target);
            }

            if(isFound){
                return isFound;
            }else{
                x_first++;
                x_last++;
            }
        }
        return isFound;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter how many cols: ");
        int col = scanner.nextInt();

        System.out.println("Enter each elements: ");
        int[][] matrix = new int[rows][col];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();

        System.out.println("Element is present: " + search(matrix, target));
    }
}
