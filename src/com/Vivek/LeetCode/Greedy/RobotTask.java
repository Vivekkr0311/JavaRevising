package com.Vivek.LeetCode.Greedy;

import java.util.Scanner;

public class RobotTask {

    static int numberOfMachinesRequired(int[] start, int[] end){
        int res = 1;
        for(int i = 1; i < start.length; i++){
            if(start[i] < end[i - 1]){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many pairs??");
        int n = input.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        System.out.println("Enter start: ");
        for(int i = 0; i < n; i++){
            start[i] = input.nextInt();
        }
        System.out.println("Enter end: ");
        for(int i = 0; i < n; i++){
            end[i] = input.nextInt();
        }
        System.out.println(numberOfMachinesRequired(start, end));
    }
}
