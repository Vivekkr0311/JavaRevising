package com.Vivek.LeetCode.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class MaxWealth {
    public static void main(String[] args) {
        int arr[][] = createTwoDArray();
        findingMaxWealth(arr);
    }

    static int[][] createTwoDArray(){
        System.out.print("[?] Insert row: ");
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        System.out.print("[?] Insert column: ");
        int column = in.nextInt();

        System.out.print("[?] Insert each element: ");
        int[][] arr = new int[row][column];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < column; c++){
                arr[r][c] = in.nextInt();
            }
        }

        for(int idx = 0; idx < arr.length; idx++){
            System.out.println(Arrays.toString(arr[idx]));
        }
        return arr;
    }

    static void findingMaxWealth(int arr[][]){
        if(arr.length == 0){
            System.out.println("[-] Array lenght is 0.");
            return;
        }

        int ans = Integer.MIN_VALUE;
        for(int r = 0; r < arr.length; r++){
            int sum = 0;
            for(int c = 0; c < arr[r].length; c++){
                sum += arr[r][c];
            }

            if(sum > ans){
                ans = sum;
            }
        }

        System.out.println("[+] Max wealth is: " + ans);
    }
}
