package com.Vivek.BackTracking;

public class AllPathInMaze {

    //This solution for finding all possible path, will give us stack overflow error.
    //As it will again and again start from the beginning path("<intermediate_ans>", maze, 0, 0).
    //Hence, it will again and again will start from starting position, hence we will get stack overflow error.
    static void allPath(String path, boolean maze[][], int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1) allPath(path + "D", maze, r + 1, c);
        if(c < maze[0].length - 1) allPath(path + "R", maze, r, c + 1);

        if(r > 0) allPath(path + "U", maze, r - 1, c);
        if(c > 0) allPath(path + "L", maze, r, c - 1);
    }
    public static void main(String[] args) {
        boolean [][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };

        allPath("", board, 0, 0);
    }
}
