package com.Vivek.LeetCode.ConversionNumerSystem;

import java.util.Scanner;

public class DecimalToBinary {

    private static int log2(int n){
        if(n < 0){
            System.out.println("Number must be positive");
            return -1;
        }

        int log = 0;
        while(n > 0){
            n = n >> 1;
            log++;
        }
        return log;
    }

    private static String conversionIntoBinary(int n){
        int[] binary = new int[log2(n)];

        int i = 0;
        while(n > 0){
            binary[i] = n % 2;
            n = n / 2;
            i++;
        }

        String binaryString = "";
        for(int j = i - 1; j >= 0; j--){
            binaryString = binaryString + binary[j];
        }
        return binaryString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the decimal number: ");
        int n = scanner.nextInt();

        String binary = conversionIntoBinary(n);
        System.out.println("Log base 2 of " + n + " is " + log2(n));
        System.out.println(n + " in binary " + binary);
    }
}
