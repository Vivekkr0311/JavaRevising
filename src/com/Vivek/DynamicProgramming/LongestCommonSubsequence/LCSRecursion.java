package com.Vivek.DynamicProgramming.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCSRecursion {

    static int LCS_Two(String s1, String s2, int m, int n){
        // This approach does not need to generate all combination of common subsequence.
        if(m == 0 || n == 0){
            return 0;
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + LCS_Two(s1, s2, m - 1, n -1);
        }else{
            return Math.max(
              LCS_Two(s1, s2, m, n - 1),
              LCS_Two(s1, s2, m - 1, n)
            );
        }
    }

    static int LCS(ArrayList<String> first, ArrayList<String> second){
        int lcs = 0;
        for(int i = 0; i < first.size(); i++){
            for(int j = 0; j < second.size(); j++){
                if(first.get(i).equalsIgnoreCase(second.get(j))){
                    if(lcs < first.get(i).length()){
                        lcs = first.get(i).length();
                    }
                }
            }
        }
        return lcs;
    }

    static ArrayList<String> allSubsequence(String unprocess, String process){
        // This method prints all possible sub sequence not common subsequence.
        if(process.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(unprocess);
            return list;
        }

        char ch = process.charAt(0);
        ArrayList<String> first = allSubsequence(unprocess + ch, process.substring(1));
        ArrayList<String> second = allSubsequence(unprocess, process.substring(1));
        first.addAll(second);
        return first;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first string to find its LCS: ");
        String ip = input.nextLine();
        System.out.println("Enter your second string to find its LCS: ");
        String ip2 = input.nextLine();
        ArrayList<String> listOne = allSubsequence("", ip);
        ArrayList<String> listTwo = allSubsequence("", ip2);
        System.out.println(LCS(listOne, listTwo));
        System.out.println(LCS_Two(ip, ip2, ip.length(), ip.length()));
    }
}
