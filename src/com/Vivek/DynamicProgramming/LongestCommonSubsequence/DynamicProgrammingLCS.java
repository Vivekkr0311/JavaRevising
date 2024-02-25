package com.Vivek.DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgrammingLCS {

    static int dynamicProgrammingLCS(String s1, String s2){
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
        System.out.println(dynamicProgrammingLCS(ip, ip2));
    }
}
