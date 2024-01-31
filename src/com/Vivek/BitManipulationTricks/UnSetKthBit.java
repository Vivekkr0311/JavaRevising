package com.Vivek.BitManipulationTricks;

import java.util.Scanner;

public class UnSetKthBit {

    static int unSetKthBit(int num, int k){
        return num & (~(1 << (k - 1)));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number whose kth bit you wanna unset: ");
        int num = input.nextInt();
        String numInBinary = Integer.toBinaryString(num);
        int len = numInBinary.length();

        System.out.println(num + " in binary: " + numInBinary);
        System.out.println("Enter k (LSB): ");
        int k = input.nextInt();

        int ans = unSetKthBit(num, k);
        String ansInBinary = Integer.toBinaryString(ans);
        String ansInBinaryAfterFormatting = String.format("%" + len + "s", ansInBinary).replace(' ', '0');
        System.out.println(ans + ": after unsetting kth bit: " + ansInBinaryAfterFormatting);
    }
}
