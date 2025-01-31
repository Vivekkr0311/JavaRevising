package com.Vivek.LeetCode.DataStructures.ArraysAndArrayLists.SlidingWindow;

import java.util.*;

public class RepeatedDNASequences {
    private static List<String> findRepeatedDnaSequencesSlidingWindowNaive(String s){
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

    private static List<String> findRepeatedDnaSequences2(String s){
        Set<String> storage1 = new HashSet<>(), storage2 = new HashSet<>();
        int left = 0;
        int right = left + 10;
        int n = s.length();
        while(right <= n){
            String subString = s.substring(left, right);

            if(!storage1.add(subString)){
                storage2.add(subString);
            }
            left++;
            right++;
        }

        return new ArrayList<>(storage2);
    }

    private static List<String> findRepeatedDnaSequences(String s){
        Set<String> storage1 = new HashSet<>(), storage2 = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n - 9; i++){
            String subsString = s.substring(i, i + 10);
            if(!storage1.add(subsString)){
                storage2.add(subsString);
            }
        }

        return new ArrayList<>(storage2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the DNA sequence: ");
        String s = scanner.nextLine();

        System.out.println("10-letter DNA sequence which occurred more than once are: " + findRepeatedDnaSequencesSlidingWindowNaive(s));
        System.out.println("10-letter DNA sequence which occurred more than once are: " + findRepeatedDnaSequences2(s));
        System.out.println("10-letter DNA sequence which occurred more than once are: " + findRepeatedDnaSequences(s));
    }
}
