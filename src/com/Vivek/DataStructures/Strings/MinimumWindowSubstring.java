package com.Vivek.DataStructures.Strings;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumWindowSubstring {

    private static boolean isFreqSame(HashMap<Character, Integer> map, HashMap<Character, Integer> localMap){
        if(map.size() == 0 && localMap.size() == 0){
            return true;
        }

        for(Character ch : map.keySet()){
            if(localMap.containsKey(ch)){
                if(map.get(ch) > localMap.get(ch)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private static String minWindow(String s, String t){
        String ans = "";
        int ansLength = Integer.MAX_VALUE;
        int m = s.length();
        int n = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch :  t.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch) + 1);
            }
        }

        for(int i = 0; i <= m - n; i++){
            HashMap<Character, Integer> localMap = new HashMap<>();
            for(int j = i;  j < m; j++){
                char ch = s.charAt(j);
                if(localMap.containsKey(ch)){
                    localMap.put(ch, localMap.get(ch) + 1);
                }else{
                    localMap.put(ch, 1);
                }

                if(isFreqSame(map, localMap)){
                    String tempS = s.substring(i, j + 1);
                    int tempSLength = tempS.length();
                    if(ansLength > tempSLength){
                        ans = tempS;
                        ansLength = tempSLength;
                    }
                    break;
                }
            }
        }
        return ans;
    }

    private static String minWindow2(String s, String t){
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, have = 0;
        int ansLength = Integer.MAX_VALUE;
        String ans = "";

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int required = map.size();

        while (right < s.length()) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (map.containsKey(ch) && windowMap.get(ch).intValue() == map.get(ch).intValue()) {
                have++;
            }

            while (have == required) {
                if (right - left + 1 < ansLength) {
                    ansLength = right - left + 1;
                    ans = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (map.containsKey(leftChar) && windowMap.get(leftChar).intValue() < map.get(leftChar).intValue()) {
                    have--;
                }
                left++;
            }

            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = scanner.nextLine();
        System.out.println("Enter t: ");
        String t = scanner.nextLine();

        System.out.println("Ans: " + minWindow(s, t));
    }
}
