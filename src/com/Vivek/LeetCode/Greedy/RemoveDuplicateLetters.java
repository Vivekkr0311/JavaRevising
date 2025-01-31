package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class RemoveDuplicateLetters {

    // Faster solution
    public static String removeDuplicate(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);


            if (seen[currentChar - 'a']) {
                continue;
            }


            while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(currentChar);
            seen[currentChar - 'a'] = true;
        }


        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    static String removeDuplicateLetter(String up, String p){
    // Not finding lexicographical smallest
        if(p.isEmpty()){
            return up;
        }

        if(up.contains(p.charAt(0) +"")){
            return removeDuplicateLetter(up, p.substring(1));
        }else{
           return removeDuplicateLetter(p.charAt(0) + up, p.substring(1));
        }
    }


    public static String removeDuplicateLetters(String s) {
    // Not finding lexicographical smallest
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String resultString = new String(charArr);
        return removeDuplicateLetter("", resultString);
    }

    // Not finding lexicographical smallest -> Fixed: Slower solution
    static String solution(String input){
        boolean[] flag = new boolean[26];
        int[] chIndexes = new int[26];
        int n = input.length();

        for(int i = 0; i < n; i++){
            chIndexes[input.charAt(i) - 'a'] = i;
        }

        String ans = "";
        for(int i = 0; i < n; i++){
            char ch = input.charAt(i);
            int chIdx = ch - 'a';

            if(flag[chIdx]){
                continue;
            }

            while((!ans.isEmpty()) && (ans.charAt(ans.length() - 1) > ch) && (chIndexes[ans.charAt(ans.length() - 1) - 'a'] > i)){
                flag[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans = ans.substring(0, ans.length() - 1);
            }

            ans = ans + ch;
            flag[chIdx] = true;
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test case: cbacdcbc
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String string = input.nextLine();
        System.out.println(solution(string));
    }
}
