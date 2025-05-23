package com.Vivek.LeetCode.Maths.BitManipulationTricks;

import java.util.Scanner;

public class MultiplyBy2PowerK {

    static int multiplyBy2PowerOfK(int num, int k){
        return num << k;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number which you wanna multiply: ");
        int num = input.nextInt();
        String numInBinary = Integer.toBinaryString(num);
        int len = numInBinary.length();

        System.out.println(num + " in binary: " + numInBinary);
        System.out.println("Enter the number which is in power of 2: ");
        int d = input.nextInt();
        int k = (int)Math.ceil(Math.log(d)/Math.log(2));

        int ans = multiplyBy2PowerOfK(num, k);
        String ansInBinary = Integer.toBinaryString(ans);
        String ansInBinaryAfterFormatting = String.format("%" + len + "s", ansInBinary).replace(' ', '0');
        System.out.println(ans + ": after multiplying: " + ansInBinaryAfterFormatting);
    }
}
