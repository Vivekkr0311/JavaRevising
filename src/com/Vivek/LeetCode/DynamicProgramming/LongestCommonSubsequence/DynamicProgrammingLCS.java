package com.Vivek.LeetCode.DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgrammingLCS {

    static int[][] memo;

    static int dynamicProgrammingLCSMemo(String s1, String s2, int m, int n){
        if(memo[m][n] != -1){
            return memo[m][n];
        }

        if(m == 0 || n == 0){
            return memo[m][n];
        }else{
            if(s1.charAt(m - 1) == s2.charAt(n - 1)){
                memo[m][n] = 1 + dynamicProgrammingLCSMemo(s1, s2, m - 1, n -1);
            }else{
                memo[m][n] = Math.max(
                        dynamicProgrammingLCSMemo(s1, s2, m, n - 1),
                        dynamicProgrammingLCSMemo(s1, s2, m - 1, n)
                );
            }
        }
        return memo[m][n];
    }


    static int dynamicProgrammingLCS(String s1, String s2){
        // This is a tablulation solution.
        int m = s1.length();
        int n = s2.length();

        int[][] table = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++){
            table[i][0] = 0;
        }

        for(int j = 0; j <= n; j++){
            table[0][j] = 0;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    table[i][j] = table[i - 1][j - 1] + 1;
                }else{
                    table[i][j] = Math.max(
                            table[i][j - 1],
                            table[i - 1][j]
                    );
                }
            }
        }
        return table[m][n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first string to find its LCS: ");
        String ip = input.nextLine();
        System.out.println("Enter your second string to find its LCS: ");
        String ip2 = input.nextLine();
        Arrays.fill(memo, -1);
        System.out.println(dynamicProgrammingLCS(ip, ip2));
        System.out.println(dynamicProgrammingLCSMemo(ip, ip2, ip.length(), ip2.length()));
    }
}
