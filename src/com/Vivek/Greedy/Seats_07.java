package com.Vivek.Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seats_07 {

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
    }
}