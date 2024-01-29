package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DistributingCandy {

    class Solution {
        public int candy(int[] ratings) {
            return sol(ratings, 0, 0);
        }

        public int sol(int[] r, int s, int prev) {

            if (s >= r.length) {
                return 0;
            }

            if (s == (r.length-1)) {
                return 1 + Math.max(0, prev-1);
            }

            if ((s+1) == (r.length-1)) {

                if (r[s] == r[r.length-1]) {
                    return 2 + Math.max(0, prev-1);
                } else if (r[s] > r[r.length-1]) {
                    return 3 + Math.max(0, prev-2);
                } else {
                    return 3 + Math.max(0, prev-1);
                }

                // return ((r[s] == r[r.length-1]) ? 2 : 3) + Math.max(0, prev-1);
            }

            if (r[s] == r[s+1]) {
                return 1 + sol(r, s+1, 0) + Math.max(0, prev-1);
            }

            if (r[s] > r[s+1]) {
                int low = minima(r, s, 1);
                int cnt = (low-s+1);
                return cnt*(cnt+1)/2 - 1 + sol(r, low, 0) + Math.max(0, prev-cnt);
            } else {
                int high = minima(r, s, -1);
                int cnt = (high-s+1);
                return cnt*(cnt+1)/2 - cnt + sol(r, high, cnt) + Math.max(0, prev-1);
            }

        }

        public int minima(int[] r, int s, int a) {

            for (int i=(s+1); i<(r.length-1); i++) {
                if (a*r[i] <= a*r[i+1]) {
                    return i;
                }
            }

            return r.length-1;
        }
    }
    
    static int sumOfCandy(int[] candies){
        System.out.println(Arrays.toString(candies));
        int total = 0;
        for(int candy : candies){
            total += candy;
        }
        return total;
    }
    static int distributingCandy(int[] childrens){
        int[] candies = new int[childrens.length];

        for(int i = 0; i < childrens.length; i++){
            candies[i] = 1;
        }

        // Left side checking
        for(int i = 0; i < childrens.length - 1; i++){
            if(childrens[i] < childrens[i + 1]){
                candies[i + 1] = candies[i] + 1;
            }
        }

        // Right side checking
        for(int i = childrens.length - 2; i >= 0; i--){
            if(childrens[i] >  childrens[i + 1] && candies[i] <= candies[i + 1]){
                candies[i] = candies[i + 1] + 1;
            }
        }

        return sumOfCandy(candies);
    }

    public static void main(String[] args) {
        //Test case: 1, 1, 2, 2, 10, 10, 10
        Scanner input = new Scanner(System.in);
        System.out.println("Total number of students ??");
        int n = input.nextInt();
        int[] studentRatings = new int[n];

        System.out.println("Enter ratings of students: ");
        for(int i = 0; i < n; i++){
            studentRatings[i] = input.nextInt();
        }
        System.out.println("Total candies required: " + distributingCandy(studentRatings));
    }
}
