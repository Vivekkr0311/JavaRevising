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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s: ");
        String s = scanner.nextLine();
        System.out.println("Enter t: ");
        String t = scanner.nextLine();

        System.out.println("Ans: " + minWindow(s, t));
    }
}
