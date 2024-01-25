package com.Vivek.Greedy;

import java.util.Arrays;

public class TurningAllBulbsOn_01 {

    static void switchRigthBulbs(int[] arr, int start){
        for(int i = start; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
    }

    static int calculatinCost(int[] arr, int start){
        int cost = 0;
        for(int i = start; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = 1;
                switchRigthBulbs(arr, i + 1);
                System.out.println(Arrays.toString(arr));
                cost = cost + 1;
            }else{
                break;
            }
        }
        return cost;
    }

    static int solution(int[] arr){
        int[] allcost = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int currCost =  calculatinCost(arr, i);
            allcost[i] = currCost;
        }

        int maxCost = allcost[0];
        for(int i = 1; i < allcost.length; i++){
            if(allcost[i] > maxCost){
                maxCost = allcost[i];
            }
        }
        return maxCost;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 1};
        System.out.println(solution(arr));
    }
}
