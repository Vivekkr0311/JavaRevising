package com.Vivek.DataStructures.Strings;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    private static List<String> generatingSubstring(String p){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            for(int j = i + 1; j <= p.length(); j++){
                list.add(p.substring(i, j));
            }
        }
        return list;
    }

    private static boolean isContainsUnique(String s){
        HashMap<Character, Integer> counts = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(counts.get(ch) != null) {
                counts.put(ch, counts.get(ch) + 1);
            } else {
                counts.put(ch, 1);
            }
            if(counts.get(ch) > 1){
                return false;
            }
        }
        return true;
    }

    private static int lengthOfLongestSubstring(String s){
        List<String> subStrings = generatingSubstring(s);
        int length = 0;
        String ans = "";
        for(String eachSubString : subStrings){
            int currLength = eachSubString.length();
            if(currLength > length && isContainsUnique(eachSubString)){
                length = currLength;
                ans = eachSubString;
            }
        }
        System.out.println("Ans " + ans);
        return length;
    }

    private static int lengthOfLongestSubstring_2(String s){
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(left < s.length() && right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
                right++;
            }else{
                set.remove(s.charAt(right));
                left++;
                right = left;
                set.clear();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();
        System.out.println("All substring: " + generatingSubstring(s));
        System.out.println("Longest substring length: " + lengthOfLongestSubstring_2(s));
    }
}
