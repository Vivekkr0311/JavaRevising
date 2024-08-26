package com.Vivek.DataStructures.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class RegularExpression {

    private static boolean[][] map = new boolean[21][21];
    private static boolean helper2(int i, int j, String s, String p){
        if(j == p.length()){
            return i == s.length();
        }

        if(map[i][j] != false){
            return map[i][j];
        }

        boolean first_character_match = (i < s.length()) && ((p.charAt(j) == '.') || (s.charAt(i) == p.charAt(j)));

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            boolean not_take_astrisk = helper2(i, j + 2, s, p);
            boolean take_astrisk = first_character_match && helper2(i + 1, j, s, p);
            return map[i][j] = not_take_astrisk || take_astrisk;
        }
        return map[i][j] = first_character_match && helper2(i + 1, j + 1, s, p);
    }

    private static boolean isMatch5(String s, String p){
        return helper2(0, 0, s, p);
    }

    private static boolean helper(int i, int j, String s, String p){
        if(j == p.length()){
            return i == s.length();
        }

        boolean first_character_match = (i < s.length()) && ((p.charAt(j) == '.') || (s.charAt(i) == p.charAt(j)));

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            boolean not_take_astrisk = helper(i, j + 2, s, p);
            boolean take_astrisk = first_character_match && helper(i + 1, j, s, p);
            return not_take_astrisk || take_astrisk;
        }
        return first_character_match && helper(i + 1, j + 1, s, p);
    }

    private static boolean isMatch4(String s, String p){
        return helper(0, 0, s, p);
    }

    private static boolean isMatch3(String s, String p){
        if(p.length() == 0){
            return s.length() == 0;
        }

        boolean first_character_match = (s.length() > 0) && ((p.charAt(0) == '.') || (s.charAt(0) == p.charAt(0)));

        if(p.length() >1 && p.charAt(1) == '*'){
            boolean not_take_astrisk = isMatch3(s, p.substring(2));
            boolean take_astrisk = first_character_match && isMatch3(s.substring(1), p);
            return not_take_astrisk || take_astrisk;
        }
        return first_character_match && isMatch3(s.substring(1), p.substring(1));
    }

    private static boolean isMatch2(String s, String p){
        if(p.length() == 0){
            if(s.length() == 0){
                return true;
            }else{
                return false;
            }
        }

        if(p.charAt(1) == '*'){
            boolean not_take_astrisk = isMatch2(s, p.substring(2));
            boolean take_astrisk = (p.charAt(0) == '.') || s.charAt(0) == p.charAt(0) || isMatch2(s.substring(1), p);
            return not_take_astrisk || take_astrisk;
        }else{
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.' || isMatch2(s.substring(1), p.substring(1)));
        }
    }


    private static boolean isMatch(String s, String p){
       if(p.length() == 0){
           if(s.length() == 0){
               return true;
           }else{
               return false;
           }
       }

       if(p.charAt(1) == '*'){
           boolean not_take_astrisk = isMatch(s, p.substring(2));
           boolean take_astrisk = false;
           if(p.charAt(0) == '.'){
               take_astrisk = isMatch(s.substring(1), p);
           }else{
               if(s.charAt(0) == p.charAt(0)){
                   take_astrisk = isMatch(s.substring(1), p);
               }
           }
           return not_take_astrisk || take_astrisk;
       }else{
           if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
               return isMatch(s.substring(1), p.substring(1));
           }else{
               return false;
           }
       }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = scanner.nextLine();
        System.out.println("Enter p: ");
        String p = scanner.nextLine();

        System.out.println(s + " matches " + p + " : " + isMatch3(s, p));
        System.out.println(s + " matches " + p + " : " + isMatch4(s, p));

        System.out.println(s + " matches " + p + " : " + isMatch5(s, p));
    }
}
