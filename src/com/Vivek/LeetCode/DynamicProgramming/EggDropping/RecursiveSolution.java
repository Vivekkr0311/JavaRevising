package com.Vivek.LeetCode.DynamicProgramming.EggDropping;

import java.util.Scanner;

public class RecursiveSolution {

    static int eggDrop(int e, int f){
        if(f == 1 || f == 0){
            return f;
        }
        if(e == 1){
            return f;
        }

        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= f; i++){
            int sub_res = Math.max(
                    eggDrop(e, f - i),
                    eggDrop(e - 1, i - 1)
            );
            res = Math.min(res, sub_res + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of eggs: ");
        int e = input.nextInt();
        System.out.println("Enter number of floors: ");
        int f = input.nextInt();

        System.out.println("Minimum number of attempts required to find critical floor: " + eggDrop(e, f));
    }
}
