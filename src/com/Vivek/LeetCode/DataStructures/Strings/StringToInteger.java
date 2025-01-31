package com.Vivek.LeetCode.DataStructures.Strings;

import java.util.Scanner;

public class StringToInteger {

    private static int aToi(String s){
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }

        long ans = 0;
        boolean neg = false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(i == 0){
                if(ch == '-'){
                    neg = true;
                    continue;
                }else if(ch == '+'){
                    neg = false;
                    continue;
                }
            }

            if(ch >= '0' && ch <= '9'){
                int dig = ch - '0';
                ans = ans * 10 + dig;

                if(neg){
                    long check = -ans;
                    if(check < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }else if(ans > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                break;
            }
        }

        if(neg){
            ans = -ans;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();

        System.out.println(s + " after conversion " + aToi(s));
    }
}
