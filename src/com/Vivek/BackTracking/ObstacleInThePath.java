package com.Vivek.BackTracking;

import java.util.Scanner;

public class ObstacleInThePath {

    static int obstacleInThePath(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        //Mimicing obstacle is at r == 2 and c == 2
        if(r == 2 && c == 2){
            return 0;
        }

        int left = obstacleInThePath(r - 1, c);
        int right = obstacleInThePath(r, c -1);
        return left + right;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter row/ col: ");
        int r = input.nextInt(); int c = input.nextInt();

        System.out.println("Number of paths: " + obstacleInThePath(r, c));
    }
}
