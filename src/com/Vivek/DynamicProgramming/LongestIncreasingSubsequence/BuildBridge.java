package com.Vivek.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BuildBridge {

    static class Bridge implements Comparable<Bridge> {

        private int start;
        private int end;
        Bridge(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return "(" +  this.start + ", " + this.end + ")";
        }

        @Override
        public int compareTo(Bridge obj1){
            if(obj1.start < this.start){
                return 1;
            }else if(obj1.start ==  this.start){
               if(obj1.end < this.end){
                   return 1;
               }else if(obj1.end == this.end){
                   return 0;
               }
            }
            return -1;
        }
    }

    static int buildBridge(Bridge[] bridges){
        Arrays.sort(bridges);
        System.out.println(Arrays.toString(bridges));
        int[] lis = new int[bridges.length];
        for(int i = 0; i < bridges.length; i++){
            lis[0] = 1;
        }

        for(int i = 0; i < bridges.length; i++){
            for(int j = 0; j < i; j++){
                if(bridges[i].end > bridges[j].end){
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
        }

        int max = lis[0];
        for(int i = 1; i < lis.length; i++){
            if(lis[i] > max){
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many elements: ");
        int n = input.nextInt();

        Bridge[] bridges = new Bridge[n];
        System.out.println("Enter start and end of the each bridge: ");
        for(int i = 0; i < n; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            bridges[i] = new Bridge(start, end);
        }

        System.out.println("Maximum bridges that we can make without crossing: " + buildBridge(bridges));
    }
}
