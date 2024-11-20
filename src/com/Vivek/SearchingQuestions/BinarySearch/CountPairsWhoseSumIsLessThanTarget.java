package com.Vivek.SearchingQuestions.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountPairsWhoseSumIsLessThanTarget {
    private static int countPairsBruteForce(List<Integer> nums, int target){
        if(nums.size() == 0){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < nums.size(); i++){
            for(int j = i; j < nums.size(); j++){
                if(i != j && nums.get(i) + nums.get(j) < target){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element do you have? ");
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter each elements: ");
        for(int i = 0; i < n; i++){
            nums.add(scanner.nextInt());
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();

        System.out.println("Total pairs possible: " + countPairsBruteForce(nums, target));
    }
}
