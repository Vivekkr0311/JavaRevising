package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.Scanner;

public class H_IndexII {
    private static int hIndex(int[] citations){
        int start = 0;
        int n = citations.length;
        int end = n - 1;
        int hIdx = 0;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(citations[mid] >= n - mid){
                hIdx = n - mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return hIdx;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of citations: ");
        int citations = scanner.nextInt();

        int[] citationsArr = new int[citations];
        System.out.println("Enter each citation: ");
        for(int i = 0; i < citations; i++){
            citationsArr[i] = scanner.nextInt();
        }

        System.out.println("h-index: " + hIndex(citationsArr));
    }
}
