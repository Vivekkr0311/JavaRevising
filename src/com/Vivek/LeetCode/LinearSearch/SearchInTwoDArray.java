package com.Vivek.LeetCode.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInTwoDArray {
    public static void main(String[] args) {
        int [][]arr = createTwoDArray();
        findingInTwoDArray(arr);
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

    static void findingInTwoDArray(int arr[][]){
        if(arr.length == 0){
            System.out.println("[-] Array lenght is 0.");
            return;
        }

        System.out.print("[?] Insert what element do want to search: ");
        int target = new Scanner(System.in).nextInt();

        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[r].length; c++){
                if(arr[r][c] == target){
                    System.out.println("[+] Element found at row " + r + "  and column " + c);
                    //You can also return like "return new int[]{r, c};"
                    return;
                }
            }
        }

        System.out.println("[-] Element not found.");
    }
}
