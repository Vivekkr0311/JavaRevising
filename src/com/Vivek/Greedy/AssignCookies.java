package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class AssignCookies {

//    static int findContentChildrens(int[] greed, int[] cookies, int g, int c){
//        if(g == greed.length && c == cookies.length){
//            return 0;
//        }
//
//        Arrays.sort(greed);
//        Arrays.sort(cookies);
//        int ans = 0;
//        if(greed[g] <= cookies[c]){
//            ans = ans + findContentChildrens(greed, cookies, g + 1, c + 1) + 1;
//        }
//        ans = ans + findContentChildrens(greed, cookies, g, c+1);
//        return ans;
//    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of kids: ");
        int n = input.nextInt();
        int[] kids = new int[n];
        System.out.println("Enter greed of each kids: ");
        for(int i = 0;  i < n; i++){
            kids[i] = input.nextInt();
        }
        System.out.println("Enter number of cookies");
        int c = input.nextInt();
        int[] cookies = new int[c];
        System.out.println("Enter each size: ");
        for(int i = 0;  i < c; i++){
            cookies[i] = input.nextInt();
        }

        System.out.println("Maximum kids that can be feed: " + findContentChildrens(kids, cookies, 0, 0));
    }
}
