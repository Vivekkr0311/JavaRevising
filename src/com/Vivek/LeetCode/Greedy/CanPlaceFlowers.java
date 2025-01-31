package com.Vivek.LeetCode.Greedy;

import java.util.Scanner;

public class CanPlaceFlowers {

    static boolean canPlaceFlowers(int[] flowerbed, int n){
        int ans = 0;
        if(flowerbed.length - 1 == 0 && flowerbed[0] == 0){
            return true;
        }
        for(int i = 0; i < flowerbed.length; i++){
            if(i == 0){
                if(flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                    ans += 1;
                    flowerbed[i] = 1;
                }else{
                    continue;
                }
            }else if(i == flowerbed.length - 1){
                if(flowerbed[i] == 0 && flowerbed[i - 1] == 0){
                    ans += 1;
                    flowerbed[i] = 1;
                }
            } else {
                if(i > 0 && i < flowerbed.length){
                    if(flowerbed[i] == 0 && flowerbed[i -1] == 0 && flowerbed[i+1] == 0){
                        ans += 1;
                        flowerbed[i] = 1;
                    }
                }
            }
        }

        return ans >= n;
    }

    public static void main(String[] args) {
        // test case:
//        [0] 1: true
//        [1,0,0,0,1] 1: true
        //[1,0,0,0,1] 2: false
//        [1,0,0,0,1,0,0] 2:
//        [0,0,1,0,0] 1: true
        Scanner input = new Scanner(System.in);
        System.out.println("Many elements? ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("How many flowers? ");
        int k = input.nextInt();
        System.out.println(canPlaceFlowers(arr, k));
    }
}
