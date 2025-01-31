package com.Vivek.LeetCode.ConversionNumerSystem;

import java.util.Scanner;

public class BinaryToHex {

    private static int bToDecimal(long binary){
        int decimal = 0;
        int i = 0;
        while(binary > 0){
            decimal = (int) (decimal + Math.pow(2, i++) * (binary % 10));
            binary = binary / 10;
        }

        return decimal;
    }

    private static String decimalToHex(long binary){
        int decimal = bToDecimal(binary);

        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F'};
        int remainder;
        String hexNumber = "";

        while(decimal != 0){
            remainder = decimal % 16;
            if(remainder >= 10){
                hexNumber = hexNumber + arr[remainder - 10] + hexNumber;
            }else{
                hexNumber = remainder + hexNumber;
            }
            decimal = decimal / 16;
        }
        return hexNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your binary number: ");
        long b = scanner.nextLong();
        System.out.println(b + " in hex is " + decimalToHex(b));
    }
}
