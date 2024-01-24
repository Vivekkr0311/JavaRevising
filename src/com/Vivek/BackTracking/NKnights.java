package com.Vivek.BackTracking;

import java.util.Scanner;

public class NKnights {

    static boolean isValid(boolean[][] board, int row, int col){
        if(col >= 0 && col < board.length && row>= 0 && row < board.length){
            return true;
        }
        return false;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        if(isValid(board, row - 2, col - 1)){
            if(board[row - 2][col - 1]){
                return false;
            }
        }

        if(isValid(board, row - 1, col - 2)){
            if(board[row - 1][col - 2]){
                return false;
            }
        }

        if(isValid(board, row - 2, col + 1)){
            if(board[row - 2][col + 1]){
                return false;
            }
        }

        if(isValid(board, row - 1, col + 2)){
            if(board[row - 1][col + 2]){
                return false;
            }
        }

        return true;
    }

    static void printBoard(boolean[][] board){
        for(boolean[] arr: board){
            for(boolean elements: arr){
                if(elements){
                    System.out.print("K ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    static void nKnights(boolean[][] board, int row, int col, int knights){
        if(knights == 0){
            printBoard(board);
            System.out.println();
            return;
        }

        if(row == board.length - 1 && col == board.length - 1){
            return;
        }

        if(col == board.length){
            nKnights(board, row + 1, 0, knights);
            return;
        }
        if(isSafe(board, row, col)){
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        nKnights(board, row, col + 1, knights);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter dimension of your board: ");
        int n =  input.nextInt();
        System.out.println("How many knights? ");
        int k = input.nextInt();
        boolean[][] board = new boolean[n][n];
        nKnights(board, 0, 0, k);
    }
}
