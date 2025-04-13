package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.BackTracking;

public class ObstacleMazeAnotherSolution {

    static void obstaclePath(String path, boolean[][] maze, int r, int c){
        if(r == maze.length -1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1) obstaclePath(path + "D", maze, r + 1, c);
        if(c < maze[0].length -1) obstaclePath(path + "R", maze, r, c + 1);
    }

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };
        obstaclePath("", board, 0, 0);
    }
}
