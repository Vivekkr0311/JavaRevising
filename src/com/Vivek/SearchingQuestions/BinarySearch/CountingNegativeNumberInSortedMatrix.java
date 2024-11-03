package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class CountingNegativeNumberInSortedMatrix {
    private static int helperCount(int[] arr){
        int startIdx = 0;
        int lastIdx = arr.length - 1;
        while(startIdx <= lastIdx){
            int mid = startIdx + ((lastIdx - startIdx) >> 1);

            if(arr[mid] < 0){
                lastIdx = mid - 1;
            }else if(arr[mid] >= 0){
                startIdx = mid + 1;
            }
        }

        return arr.length - startIdx;
    }

    private static int countNegative(int[][] grid){
        int count = 0;
        for(int[] arr : grid){
            count +=  helperCount(arr);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of rows: ");
        int r = scanner.nextInt();
        System.out.println("Number of columns: ");
        int c = scanner.nextInt();
        System.out.println("Insert soldiers 1's and civilians 0's for each row:");
        int[][] mat = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Number of negative numbers in the matrix is: " + countNegative(mat));
    }
}
