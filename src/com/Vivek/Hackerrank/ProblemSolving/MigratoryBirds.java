package com.Vivek.Hackerrank.ProblemSolving;

import java.util.*;

public class MigratoryBirds {
    private static int leftIdx(List<Integer> arr, int start, int end, int target){
        int idx = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(arr.get(mid) == target){
                idx = mid;
                end = mid -1;
            } else if(arr.get(mid) < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }

    private static int rightIdx(List<Integer> arr, int start, int end, int target){
        int idx = -1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(arr.get(mid) == target){
                idx = mid;
                start = mid + 1;
            } else if(arr.get(mid) < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int result1 = 0;
        int prevLength = 0;
        int result2 = 0;
        int n = arr.size() - 1;
        for(int i = 0; i <= n; i++){
            int left = leftIdx(arr, 0, n, arr.get(i));
            int right = rightIdx(arr, 0, n, arr.get(i));

            if(prevLength < right - left + 1){
                prevLength = right - left + 1;
                result2 = result1;
                result1 = arr.get(i);
            }
        }

        if(result1 == result2){
            return result2;
        }
        return result1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of birds:");
        int n = scanner.nextInt();

        List<Integer> birds = new ArrayList<>();
        System.out.println("Enter the bird types:");
        for (int i = 0; i < n; i++){
            birds.add(scanner.nextInt());
        }

        System.out.println("Most common bird type: " + migratoryBirds(birds));
    }
}
