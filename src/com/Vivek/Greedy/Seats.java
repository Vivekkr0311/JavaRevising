package com.Vivek.Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seats_07 {

    // Most optimal solution
    public static void seatsThree(String input){
        List<Integer> allXIdx = new ArrayList<>();
        // This loop is storing the indexes of all 'x's
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'x'){
                allXIdx.add(i);
            }
        }
        System.out.println("All idx of x: " + allXIdx);
        int n = allXIdx.size();
        if(n == 0){
            return;
        }

        List<Integer> distanceX = new ArrayList<>();
        // This loop is calulating the distance of the 'x's considering the segment start from the idx 0.
        for(int i = 0; i < allXIdx.size(); i++){
            distanceX.add(allXIdx.get(i) - i);
        }

        System.out.println("Distance of each x's: " + distanceX);

        // We are assigning it to very large number as we need to find the minimum.
        int ans = Integer.MAX_VALUE;
        // Now we are using median of distances of x's
        int segmentStart = distanceX.get((distanceX.size() / 2));
        int total = 0;
        for(int idx = 0; idx < distanceX.size(); idx++){
            total = total + Math.abs(distanceX.get(idx) - segmentStart);
        }
        ans = Math.min(ans, total);

        System.out.println(ans);
    }

    public static void seatsTwo(String input){
        List<Integer> allXIdx = new ArrayList<>();
        // This loop is storing the indexes of all 'x's
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'x'){
                allXIdx.add(i);
            }
        }
        System.out.println("All idx of x: " + allXIdx);
        int n = allXIdx.size();
        if(n == 0){
            return;
        }

        List<Integer> distanceX = new ArrayList<>();
        // This loop is calulating the distance of the 'x's considering the segment start from the idx 0.
        for(int i = 0; i < allXIdx.size(); i++){
            distanceX.add(allXIdx.get(i) - i);
        }

        System.out.println("Distance of each x's: " + distanceX);

        // We are assigning it to very large number as we need to find the minimum.
        int ans = Integer.MAX_VALUE;
        // Now we will iterate over every possible segment.
        for(int segmentStart = 0; segmentStart < input.length(); segmentStart++){
            int total = 0;
            System.out.println("Segment starts " + segmentStart);
            for(int idx = 0; idx < distanceX.size(); idx++){
                total = total + Math.abs(distanceX.get(idx) - segmentStart);
            }
            ans = Math.min(ans, total);
        }
        System.out.println(ans);
    }

    public static int seats(String A) {
        final int MOD = 10000003;

        List<Integer> crosses = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                crosses.add(i - crosses.size());
            }
        }

        int n = crosses.size();
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int segmentStart = 0; segmentStart < A.length(); segmentStart++) {
            int total = 0;
            for (int cross : crosses) {
                total += Math.abs(cross - segmentStart);
                total %= MOD;
            }
            ans = Math.min(ans, total % MOD);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x/ .");
        String in = input.nextLine();

        int ans = seats(in);
        System.out.println(ans);
//        seatsTwo(in);
        seatsThree(in);
    }
}