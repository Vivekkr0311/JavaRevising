package com.Vivek.LeetCode.DynamicProgramming.EggDropping;

import java.util.Scanner;

public class EggDropDynamicProgram {

    static int eggDrop(int e, int f){
        // Something wrong with this algorithm, will refactor later.
        int[][] dp = new int[e + 1][f + 1];

        for(int i = 1; i <= e; i++){
            for(int j = 1; j <= f; j++){
                if(i == 1){
                    dp[i][j] = 1;
                }else if(j == 1){
                    dp[i][j] = 1;
                }else{
                    int min = Integer.MAX_VALUE;

                    for(int mj = j - 1, pj = 0; mj >= 0; mj--, pj++){
                        int eggSurvived = dp[i][mj];
                        int eggBreaked = dp[i - 1][pj];

                        int val = Math.max(eggSurvived, eggBreaked);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[e][f];
    }

    static int eggDropTwo(int e, int f){
        int[][] dp = new int[f + 1][e + 1];

        for(int i = 1; i <= e; i++){
            dp[1][i] = 1;
            dp[0][i] = 0;
        }

        for(int j = 1; j <= f; j++){
            dp[j][1] = j;
        }

        for(int i = 2; i <= f; i++){
            for(int j = 2; j <= e; j++){
                dp[i][j] = Integer.MAX_VALUE;

                for(int x = 1; x <= i; x++){
                    dp[i][j] = Math.min(
                            dp[i][j],

                            Math.max(
                                    dp[x - 1][j - 1],
                                    dp[i - x][j]
                            ) + 1
                    );
                }
            }
        }
        return dp[f][e];
    }

    static int eggDropThree(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        // Base cases
        for (int i = 1; i <= e; i++) {
            dp[i][1] = 1; // If there's only one floor, one trial is needed.
            dp[i][0] = 0; // If there's no floor, no trials are needed.
        }

        for (int j = 1; j <= f; j++) {
            dp[1][j] = j; // If there's only one egg, the worst case number of trials is equal to the number of floors.
        }

        // Populate rest of the matrix using dynamic programming
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int mj = 1; mj <= j; mj++) {
                    // If egg breaks at floor mj, search below mj
                    int eggBreaked = dp[i - 1][mj - 1];

                    // If egg survives at floor mj, search above mj
                    int eggSurvived = dp[i][j - mj];

                    // Find the maximum of both cases plus one for the current trial
                    int val = Math.max(eggBreaked, eggSurvived) + 1;

                    // Update minimum trials needed
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        return dp[e][f];
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of eggs: ");
        int e = input.nextInt();
        System.out.println("Enter number of floors: ");
        int f = input.nextInt();

        System.out.println("Minimum number of attempts required to find critical floor: " + eggDrop(e, f));
        System.out.println("Minimum number of attempts required to find critical floor: " + eggDropTwo(e, f));
        System.out.println("Minimum number of attempts required to find critical floor: " + eggDropThree(e, f));
    }
}
