package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    private static int minimumRecolorsBruteForce(String blocks, int k){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i + k <= blocks.length(); i++){
            int recolor = 0;
            for(int j = i; j < i + k; j++){
                if(blocks.charAt(j) == 'W'){
                    recolor++;
                }
            }

            if(recolor <= min){
                min = recolor;
            }
        }
        return min;
    }

    private static int minimumRecolors(String blocks, int k){
        int min = 0;
        for(int i = 0; i < k; i++){
           if(blocks.charAt(i) == 'W'){
               min++;
           }
        }

        int left = 0;
        int right = left + k;
        int localMin = min;
        while(right < blocks.length()){
            if(blocks.charAt(right) == 'W'){
                localMin++;
            }
            if(blocks.charAt(left) == 'W'){
                localMin--;
            }
            left++;
            right++;
            if(localMin <= min){
                min = localMin;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the block: ");
        String block = scanner.nextLine();

        System.out.println("Enter the k: ");
        int k = scanner.nextInt();

        System.out.println("Minimum number of recolor needed: " + minimumRecolorsBruteForce(block, k));
        System.out.println("Minimum number of recolor needed: " + minimumRecolors(block, k));
    }
}
