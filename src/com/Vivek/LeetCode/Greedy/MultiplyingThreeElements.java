package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplyingThreeElements {

    // Most optimized
    static int solutionThree(int[] arr){
        Arrays.sort(arr);
        int threeHighestProd = arr[arr.length - 3] *  arr[arr.length - 2] *  arr[arr.length - 1];
        int firstTwoAndHighestProd = arr[0] * arr[1] * arr[arr.length - 1];

        return  Math.max(threeHighestProd, firstTwoAndHighestProd);
    }

    // Little Optimized, using sorting.
    // But this does not work for all test cases eg: -5 -2 -1 0 0 1 1 5
    static int solutionTwo(int[] arr){
        Arrays.sort(arr);

        int maxProduct = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
        return maxProduct;
    }

    // Naive solution
    static int solution(int[] arr){
        int maxProduct = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){

                    int currProd = arr[i] * arr[j] * arr[k];

                    if(currProd > maxProduct){
                        maxProduct = currProd;
                    }
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many elements??");
        int n = input.nextInt();
        System.out.println("Insert each elements:");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println(solution(arr));
        System.out.println(solutionTwo(arr));
        System.out.println(solutionThree(arr));
    }
}
