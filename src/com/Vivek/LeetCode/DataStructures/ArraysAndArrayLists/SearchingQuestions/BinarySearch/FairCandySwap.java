package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FairCandySwap {
    private static boolean binarySearch(int[] arr, int target){
        int startIdx = 0;
        int endIdx = arr.length - 1;

        while(startIdx <= endIdx){
            int mid = startIdx + ((endIdx - startIdx) >> 1);

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                endIdx = mid - 1;
            }else{
                startIdx = mid + 1;
            }
        }

        return false;
    }
    
    private static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();

        int delta = (aliceSum - bobSum) >> 1;

        for(int x : aliceSizes){
            int y = x - delta;

            if(binarySearch(bobSizes, y)){
                return new int[]{x, y};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of candy boxes for Alice: ");
        int na =  scanner.nextInt();
        int[] aliceSizes = new int[na];
        System.out.println("Enter the size of each box of Alice: ");
        for(int i = 0; i < na; i++){
            aliceSizes[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of candy boxes for Bob: ");
        int nb = scanner.nextInt();
        int[] bobSize = new int[nb];
        System.out.println("Enter the size of each box of Bob: ");
        for(int i = 0; i < nb; i++){
            bobSize[i] = scanner.nextInt();
        }

        System.out.println("Number of candy swap: " + Arrays.toString(fairCandySwap(aliceSizes, bobSize)));
    }
}
