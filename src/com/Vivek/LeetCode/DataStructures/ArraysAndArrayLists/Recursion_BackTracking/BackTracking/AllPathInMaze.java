package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.Recursion_BackTracking.BackTracking;

public class AllPathInMaze {

    //This solution for finding all possible path, will give us stack overflow error.
    //As it will again and again start from the beginning path("<intermediate_ans>", maze, 0, 0).
    //Hence, it will again and again will start from starting position, hence we will get stack overflow error.
    static void allPath(String path, boolean[][] maze, int r, int c){
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

    //While we are finding the path, we will mark co-ordinates as false,
    //but when we will go back we will mark it as true.

    //This kind of approach is Backtracking.
    //We will make changes while going down to recursion calls, but when we will come back
    //we will revert the changes. This is known as Backtracking.
    static void allPathSolution(String path, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){ //When it is false, we have already visited this co-ordinate.
            return;
        }

        maze[r][c] = false; //Making co-ordinate as visited.
        if(r < maze.length - 1) {
            allPathSolution(path + "D", maze, r + 1, c);
        }
        if(c < maze[0].length - 1) {
            allPathSolution(path + "R", maze, r, c + 1);
        }
        if(r > 0) {
            allPathSolution(path + "U", maze, r - 1, c);
        }
        if(c > 0) {
            allPathSolution(path + "L", maze, r, c - 1);
        }
        //Making co-ordinate as not visited as recursion call is over.
        maze[r][c] = true;
    }

    static int countPath = 0;
    static void countAllPathSolution(boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            countPath = countPath + 1;
            return;
        }

        if(!maze[r][c]){ //When it is false, we have already visited this co-ordinate.
            return;
        }

        maze[r][c] = false; //Making co-ordinate as visited.
        if(r < maze.length - 1) {
            countAllPathSolution(maze, r + 1, c);
        }
        if(c < maze[0].length - 1) {
            countAllPathSolution(maze, r, c + 1);
        }
        if(r > 0) {
            countAllPathSolution(maze, r - 1, c);
        }
        if(c > 0) {
            countAllPathSolution(maze, r, c - 1);
        }
        //Making co-ordinate as not visited as recursion call is over.
        maze[r][c] = true;
    }

    public static void main(String[] args) {
        boolean [][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        allPathSolution("", board, 0, 0);
        countAllPathSolution(board, 0, 0);
        System.out.println("Count of all paths: " + countPath);
    }
}
