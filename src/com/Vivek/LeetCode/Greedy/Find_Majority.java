package com.Vivek.LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Find_Majority {

    public int majorityElement(int[] numbers) {
        int n = numbers.length;
        int ans = 0;

        for (int b = 0; b < 32; b++) {
            int ones = 0;

            for (int num : numbers) {
                if ((1 << b & num) != 0) {
                    ones++;
                }
            }

            if (ones > n / 2) {
                ans += (1 << b);
            }
        }

        return ans;
    }

    static int majority(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length / 2;
        int ans = -1;
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = 0; i < map.size(); i++){
            if(map.get(arr[i]) > n){
                ans = arr[i];
                break;
            }
        }
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//            if(entry.getValue() > n){
//                ans = entry.getKey();
//                break;
//            }
//        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements ?");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter individual elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Majority element is: " + majority(arr));
    }
}
