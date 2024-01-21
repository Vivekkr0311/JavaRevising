package com.Vivek.BackTracking;

import java.util.Arrays;

public class PrintPathMaze {
    static void path(String path, boolean[][] maze, int r, int c, int[][] allStep, int step){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            allStep[r][c] = step;
            for(int [] arr: allStep){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.println();
            return;
        }

        if(!maze[r][c]){ //When it is false, we have already visited this co-ordinate.
            return;
        }

        maze[r][c] = false; //Making co-ordinate as visited.
        allStep[r][c] = step;
        if(r < maze.length - 1) {
            path(path + "D", maze, r + 1, c, allStep, step + 1);
        }
        if(c < maze[0].length - 1) {
            path(path + "R", maze, r, c + 1, allStep, step + 1);
        }
        if(r > 0) {
            path(path + "U", maze, r - 1, c, allStep, step + 1);
        }
        if(c > 0) {
            path(path + "L", maze, r, c - 1, allStep, step + 1);
        }
        //Making co-ordinate as not visited as recursion call is over.
        maze[r][c] = true;
        allStep[r][c] = 0;
    }

    public static void main(String[] args) {
        boolean [][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        int[][] path = new int[board.length][board[0].length];
        path("", board, 0, 0, path, 1);
    }
}
