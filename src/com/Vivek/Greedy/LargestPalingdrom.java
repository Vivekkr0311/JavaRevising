package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestPalingdrom {

    static int solution(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(char c: s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);

        int result = 0;
        boolean oddFound = false;
        for(int c: counts.values()){
            if(c % 2 == 0){
                result += c;
            }else{
                oddFound = true;
                result += c - 1;
            }
        }
        if(oddFound) result++;
        return result;
    }

    static boolean isEven(int num){
        if(num == 0){
            return false;
        }
        return (num & 1) == 0;
    }

    static int largestPalindromeTwo(String s){
        if(s.length() == 1){
            return 1;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        int result = 0;
        boolean oddFound = false;
        for(int i = 0; i < counts.size(); i++){
            if(isEven(counts.get(s.charAt(i)))){
                result += counts.get(s.charAt(i));
            }else{
                oddFound = true;
                result += counts.get(s.charAt(i)) - 1;
            }
        }
        return oddFound ? result + 1 : result;
    }

//    static int largestPalindrome(String s){
//        if(s.length() == 1){
//            return 1;
//        }
//        int[] freqChar = new int[52];
//        for(int i = 0; i < s.length(); i++){
//            char ch = s.charAt(i);
//            if(ch >= 'a' && ch < 'z'){
//                freqChar[ch - 'a'] += 1;
//            }else if(ch >= 'A' && ch < 'Z'){
//                freqChar[ch - 'A' + 26] += 1;
//            }
//        }
//        System.out.println(Arrays.toString(freqChar));
//        int[] freqCharSort = Arrays.copyOf(freqChar, freqChar.length);
//        Arrays.sort(freqCharSort);
//        int even = 0;
//        int odd = 0;
//        int ans = 0;
//        boolean oddOccured = false;
//        for(int i = freqCharSort.length - 1; i > 0; i--){
//            if(freqCharSort[i] == 0){
//                break;
//            }
//           if((freqCharSort[i] & 1) == 0){
//               ans += freqCharSort[i];
//           }else{
//               ans += freqCharSort[i] - 1;
//               oddOccured = true;
//           }
//        }
//        return oddOccured ? even + odd + 1 : even + odd;
//    }

    public static void main(String[] args) {

        // test case:
//        abccccdd OP: dccaccd
        // ccc, bananas, bb
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String stringInput = input.nextLine();
        System.out.println(solution(stringInput));
    }
}
