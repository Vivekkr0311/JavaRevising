package com.Vivek.LeetCode.Recursion_BackTracking.BackTracking;

public class SudokoSolver {

    static void displayBoard(int[][] board){
        for(int[] row : board){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        // check the row
        for(int i = 0; i < board.length; i++){
            // check if the number is already in the row or not.
            if(board[row][i] == num){
                return false;
            }
        }

        // check the col
        for(int[] nums: board){
            // check if the number is already in the col or not.
            if(nums[col] == num){
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean solve(int[][] board){
        int n = board.length;

        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                     emptyLeft = false;
                     break;
                }
            }

            if(!emptyLeft){
                break;
            }
        }

        if(emptyLeft){
            //sudoku is solved.
            return true;
        }

        // Backtrack
        for(int numbers = 1; numbers <= 9; numbers++){
            if(isSafe(board, row, col, numbers)){
                board[row][col] = numbers;
                if(solve(board)){
                    // found the answer
                    return true;
                }else{
                    // Backtrack
                    board[row][col] = 0;
                }
            }
        }

        // sudoku cannot be solved.
        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 0, 0, 0, 8, 0},
                {9, 0, 0, 8, 0, 3, 0, 0, 5},
                {0, 5, 0, 0, 0, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4 },
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solve(board)){
            displayBoard(board);
        }else{
            System.out.println("Cannot be solved");
        }
    }
}
