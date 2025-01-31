package com.Vivek.LeetCode.DynamicProgramming.MaximumCuts;

import java.util.Scanner;
public class MaxiumCutsRecursive {

    static int maximumCuts(int rod, int a, int b, int c){
        if(rod < 0){
            return -1;
        }

        if(rod == 0){
            return 0;
        }

        int temp = Math.max(
                maximumCuts(rod - c, a, b, c),
                maximumCuts(rod - b, a, b, c)
        );
        int res = Math.max(
                maximumCuts(rod - a, a, b, c),
                temp
        );

        if(res == -1){
            return res;
        }else{
            return res + 1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length of the rod: ");
        int rod = input.nextInt();
        System.out.println("Enter cuts length a/ b/ and /c: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println("Maximum cuts that can be made on the rod of length: "  + rod + " using cuts: " + a + ", " + b + ",  and " + c + " is: " + maximumCuts(rod, a, b, c));
    }
}
