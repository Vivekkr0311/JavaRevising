package com.Vivek.ArraysAndArrayLists.SlidingWindow;

import java.util.Scanner;

public class CountSubstringsThatSatisfyKContraintI {
    private static boolean doesContainAtMostK(String s, int k){
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeroCount++;
            }else if(s.charAt(i) == '1'){
                oneCount++;
            }
        }
        return zeroCount <= k || oneCount <= k;
    }

    private static int countKConstraintSubstringsBruteForce(String s, int k){
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if (doesContainAtMostK(s.substring(i, j + 1), k)){
                    ans++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    private static int countKConstraintSubstrings(String s, int k){
        int ans = 0;
        int left = 0;
        int right = left;
        int countOnes = 0;
        int countZeros = 0;
        int n = s.length();

        while(right < n){
            if(s.charAt(right) == '0'){
                countZeros++;
            }else if(s.charAt(right) == '1'){
                countOnes++;
            }

            while(countOnes > k && countZeros > k){
                if(s.charAt(left) == '0'){
                    countZeros--;
                }else if(s.charAt(left) == '1'){
                    countOnes--;
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String binary = scanner.nextLine();
        System.out.println("Enter k: ");
        int k = scanner.nextInt();


        System.out.println("Number of substring that contains at most " + k + ", 0s and 1s: " + countKConstraintSubstringsBruteForce(binary, k));
        System.out.println("Number of substring that contains at most " + k + ", 0s and 1s: " + countKConstraintSubstrings(binary, k));
    }
}
