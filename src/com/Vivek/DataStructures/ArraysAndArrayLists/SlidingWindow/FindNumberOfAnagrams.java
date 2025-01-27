package com.Vivek.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindNumberOfAnagrams {

    static int anagrams(String str, String pattern){
        int n = pattern.length();
        int m = str.length();


        int ans = 0;
        for(int i = 0; i < m - n + 1; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int p = 0; p < n; p++){
                map.put(pattern.charAt(p), 1);
            }

            boolean isPresent = true;
            for(int j = i; j < i + n; j++){
                Integer z = map.get(str.charAt(j));
                if (z != null) {
                    map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
                }
            }

            for(int k = 0; k < n; k++){
                if(map.get(pattern.charAt(k)) == null || map.get(pattern.charAt(k)) != 0){
                    isPresent = false;
                    break;
                }
            }

            if(isPresent){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter main string: ");
        String mStr = input.nextLine();
        System.out.println("Enter the pattern: ");
        String ptr = input.nextLine();

        System.out.println("Total anagram present: " + anagrams(mStr, ptr));
    }
}
