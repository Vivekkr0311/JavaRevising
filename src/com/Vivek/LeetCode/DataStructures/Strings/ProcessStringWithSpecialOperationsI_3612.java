package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class ProcessStringWithSpecialOperationsI_3612 {
    private static String processStr(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '*' && !sb.isEmpty()) {
                sb.delete(sb.length() - 1, sb.length());
            } else if (chars[i] == '#' && !sb.isEmpty()) {
                sb.append(sb);
            } else if(chars[i] == '%'){
                sb.reverse();
            } else if(chars[i] != '*' && chars[i] != '#' && chars[i] != '%'){
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();

        System.out.println(processStr(str));
    }
}
