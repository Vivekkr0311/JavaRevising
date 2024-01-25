package com.Vivek.Greedy;

// Wrong solution
public class TurningAllBulbsOn_02 {

    static int bulbs(int[] arr){
        int cost = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%2 == 0){
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
        System.out.println(bulbs(arr));
    }
}
