package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class FindTheKBeautyOfANumber {
    private static int divisorSubstrings(int num, int k){
        String numString = Integer.toString(num);
        int count = 0;
        for(int i = 0; i + k <= numString.length(); i++){
            String d = numString.substring(i, i + k);
            Integer dI = Integer.parseInt(d);

            if(dI != 0 && num % dI == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the num: ");
        int num = scanner.nextInt();

        System.out.println("Enter k: ");
        int k = scanner.nextInt();

        System.out.println("There are: " +  divisorSubstrings(num, k) + " beauties present in " + num + " of length " + k);
    }
}
