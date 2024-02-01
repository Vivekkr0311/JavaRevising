package com.Vivek.Greedy;

import java.util.Scanner;

public class WaterContainer {

    static int maxArea(int[] arr) {
        int frontWall = 0;
        int rearWall =arr.length - 1;
        int area = Integer.MIN_VALUE;
        while(frontWall < rearWall && rearWall >= 0){
            int temp = (rearWall - frontWall) * Math.min(arr[rearWall], arr[frontWall]);
            if(temp > area) area = temp;
            else if( arr[frontWall] < arr[rearWall]){
                frontWall++;
            }
            else rearWall--;
        }
        return area;
    }

    static int waterContainer(int[] arr){
        int area = 0;
        int frontWall = 0;
        int rearWall = arr.length -1;

        while(frontWall < rearWall){
            if(arr[frontWall] < arr[rearWall]){
                area = Math.max(area, arr[frontWall] * (rearWall - frontWall));
                frontWall++;
            }else{
                area = Math.max(area, arr[rearWall] * (rearWall - frontWall));
                rearWall--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        // test case:
//        9
//        1 8 6 2 5 4 8 3 7
        Scanner input = new Scanner(System.in);
        System.out.println("How many heights? ");
        int n = input.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++){
            heights[i] = input.nextInt();
        }

        System.out.println("Maximum area of water that can be trapped is: " + waterContainer(heights));
    }
}
