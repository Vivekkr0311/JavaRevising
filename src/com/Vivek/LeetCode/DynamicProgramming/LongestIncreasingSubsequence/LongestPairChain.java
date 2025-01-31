package com.Vivek.LeetCode.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPairChain {

    // This problem is similar Greedy algorithm of Activity Selection Problem where
    // we wanted to select the activity without the collision.
    static class Pair implements Comparable<Pair>{

        private int a;
        private int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString(){
            return "(" + this.a + ", " + this.b + ")";
        }

        @Override
        public int compareTo(Pair obj){
            if(obj.a < this.a){
                return 1;
            }else if(obj.a == this.a){
                if(obj.b < this.b){
                    return 1;
                }else if(obj.b == this.b){
                    return 0;
                }
            }
            return -1;
        }
    }

    static int longestPairChain(Pair[] pairs){
        int[] lis = new int[pairs.length];
        Arrays.sort(pairs);
        System.out.println(Arrays.toString(pairs));

        Arrays.fill(lis, 1);

        for(int i = 0; i < pairs.length; i++){
            for(int j = 0; j < i; j++){
                if(pairs[i].a > pairs[j].b){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
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

        Pair[] pairs = new Pair[n];
        System.out.println("Enter start and end of the each pair: ");
        for(int i = 0; i < n; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            pairs[i] = new Pair(start, end);
        }

        System.out.println("Maximum bridges that we can make without crossing: " + longestPairChain(pairs));
    }
}
