package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DistributingCandy {
    static int sumOfCandy(int[] candies){
        System.out.println(Arrays.toString(candies));
        int total = 0;
        for(int candy : candies){
            total += candy;
        }
        return total;
    }
    static int distributingCandy(int[] childrens){
        Arrays.sort(childrens);
        System.out.println(Arrays.toString(childrens));
        int[] total_candy = new int[childrens.length];
        total_candy[0] = 1;
        for(int i = 1; i < childrens.length; i++){
            if(childrens[i - 1] < childrens[i]){
                total_candy[i] = total_candy[i - 1] + 1;
            }else{
                total_candy[i] = total_candy[i - 1];
            }
        }
        return sumOfCandy(total_candy);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Total number of students ??");
        int n = input.nextInt();
        int[] studentRatings = new int[n];

        System.out.println("Enter ratings of students: ");
        for(int i = 0; i < n; i++){
            studentRatings[i] = input.nextInt();
        }
        System.out.println("Total candies required: " + distributingCandy(studentRatings));
    }
}
