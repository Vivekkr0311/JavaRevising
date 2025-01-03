package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RepeatedDNASequences {
    private static List<String> findRepeatedDnaSequences(String s){
        List<String> ans = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = left + 10;
        int n = s.length();
        while(right <= n){
            String subString = s.substring(left, right);

            map.put(subString, map.getOrDefault(subString, 0) + 1);
            left++;
            right++;
        }

        for(String key : map.keySet()){
            int freq = map.get(key);

            if(freq > 1){
                ans.add(key);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the DNA sequence: ");
        String s = scanner.nextLine();

        System.out.println("10-letter DNA sequence which occurred more than once are:" + findRepeatedDnaSequences(s));
    }
}
