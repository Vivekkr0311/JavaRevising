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
        int[] candies = new int[childrens.length];

        for(int i = 0; i < childrens.length; i++){
            candies[i] = 1;
        }

        // Left side checking
        for(int i = 0; i < childrens.length - 1; i++){
            if(childrens[i] < childrens[i + 1]){
                candies[i + 1] = candies[i] + 1;
            }
        }

        // Right side checking
        for(int i = childrens.length - 2; i >= 0; i--){
            if(childrens[i] >  childrens[i + 1] && candies[i] <= candies[i + 1]){
                candies[i] = candies[i + 1] + 1;
            }
        }

        return sumOfCandy(candies);
    }

    public static void main(String[] args) {
        //Test case: 1, 1, 2, 2, 10, 10, 10
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
