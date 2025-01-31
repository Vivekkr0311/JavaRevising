package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;

public class TurningAllBulbsOn {

    static void switchRigthBulbs(int[] arr, int start){
        for(int i = start; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
    }

    static int calculatinCost(int[] arr){
        int cost = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = 1;
                switchRigthBulbs(arr, i + 1);
                System.out.println(Arrays.toString(arr));
                cost = cost + 1;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 1};
        System.out.println(calculatinCost(arr));
    }
}
