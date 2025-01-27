package com.Vivek.Recursion_BackTracking.BackTracking;

import java.util.Scanner;

public class ObstacleInThePath {

    static int obstacleInThePath(int r, int c){
        if(r == 1 && c == 1){
            return 1;
        }

        //Mimicing obstacle is at r == 2 and c == 2
        if(r == 2 && c == 2){
            return 0;
        }
        int left = 0; int right = 0;
        if(r > 0) left = obstacleInThePath(r - 1, c);
        if(c > 0) right = obstacleInThePath(r, c -1);
        return left + right;
    }

    static void obstacleInThePathPrint(String path, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(path + " End");
            return;
        }

        //Mimicing obstacle is at r == 2 and c == 2
        if(r == 2 && c == 2){
            return;
        }

        if(r > 1) obstacleInThePathPrint(path + "Down -> ", r - 1, c);
        if(c > 1) obstacleInThePathPrint(path + "Right -> ", r, c -1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter row/ col: ");
        int r = input.nextInt(); int c = input.nextInt();

        System.out.println("Number of paths: " + obstacleInThePath(r, c));
        System.out.println("Paths are: ");
        obstacleInThePathPrint("", r, c);
    }
}
