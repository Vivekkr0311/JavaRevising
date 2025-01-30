package com.Vivek.DataStructures.ArraysAndArrayLists.SearchingQuestions.BinarySearch;

import java.util.*;

public class FindTargetIndicesAfterSortingArray {
    private static int[] search(int[] arr, int target, boolean right){
        int start = 0;
        int end = arr.length - 1;
        int rightAns = -1;
        int leftAns = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);

            if(arr[mid] == target){
                if(right){
                    rightAns = mid;
                    start = mid + 1;
                }else{
                    leftAns = mid;
                    end = mid - 1;
                }
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return new int[]{leftAns, rightAns};
    }
    private static List<Integer> targetIndices(int[] arr, int target){
        Arrays.sort(arr);
        int[] right = search(arr, target, true);
        int[] left = search(arr, target, false);

        int startI = left[0];
        int rightI = right[1];

        if(startI == -1){
            return new ArrayList<>();
        }

        List<Integer> ansIdx = new ArrayList<>();
        for(int i = startI; i <= rightI; i++){
            ansIdx.add(i);
        }

        return ansIdx;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you have ?");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();
        System.out.println(target + " is placed at indicies: " + targetIndices(arr, target));
    }
}
