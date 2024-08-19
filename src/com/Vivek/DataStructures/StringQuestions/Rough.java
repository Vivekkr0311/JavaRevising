package com.Vivek.DataStructures.StringQuestions;

public class Rough {
    static String sol(String input){
        System.out.println(input);
        char[] chars = input.toCharArray();
        int forward = 0;
        int backward = chars.length - 1;

        while(forward <= backward){
            if(!(chars[forward] >= 'a' && chars[forward] <= 'z')){
                forward++;
            }else if(!(chars[backward] >= 'a' && chars[backward] <= 'z')){
                backward--;
            }else if((chars[forward] >= 'a' && chars[forward] <= 'z') || (chars[backward] >= 'a' && chars[backward] <= 'z')){
                char temp = chars[forward];
                chars[forward] = chars[backward];
                chars[backward] = temp;
                forward++;
                backward--;
            }
        }

        String ans = "";
        for(char ch : chars){
            ans = ans + ch;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(sol("abc/o/p"));
    }
}
