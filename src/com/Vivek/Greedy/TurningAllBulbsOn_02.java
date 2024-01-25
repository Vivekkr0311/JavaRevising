package com.Vivek.Greedy;

import java.util.Arrays;

// Wrong solution
public class TurningAllBulbsOn_02 {
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
                if(cost%2 == 0){
                    // no toggle needed
                }else{
                    switchRigthBulbs(arr, i + 1);
                }
                System.out.println(Arrays.toString(arr));
                cost = cost + 1;
            }
        }
        return cost;
    }


    static int bulbs(int[] arr){
        int cost = 0;
        for(int i = 0; i < arr.length; i++){
            if(cost%2 == 0){
                // nothing needs to be change
            }else{
                arr[i] = (arr[i] == 0) ? 1 : 0;
            }

            if(arr[i]%2 == 1){
                continue;
            }else{
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 1};
        System.out.println(calculatinCost(arr));
    }
}
