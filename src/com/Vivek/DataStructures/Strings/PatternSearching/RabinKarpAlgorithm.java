package com.Vivek.DataStructures.Strings.PatternSearching;

import java.util.ArrayList;
import java.util.Scanner;

public class RabinKarpAlgorithm {

    static final int d=256;
    static final int q=101;
    private static ArrayList<Integer> rabinKarpAlgorithm(String pattern, String input){
        int M = pattern.length();
        int N = input.length();
        ArrayList<Integer> resultIndex = new ArrayList<>();

        //Compute (d ^ (M - 1)) % q
        int h = 1;
        for(int i = 1; i <= M - 1; i++)
            h = (h * d) % q;

        //Compute p and t
        int p = 0, t = 0;
        for(int i = 0; i < M; i++){
            p = (p * d + pattern.charAt(i)) % q;  // Horner's Rule for pattern
            t = (t * d + input.charAt(i)) % q;    // Horner's Rule for text
        }

        for(int i = 0; i <= (N - M); i++) {
            //Check for hit
            if (p == t) {
                boolean flag = true;
                for (int j = 0; j < M; j++) {
                    if (input.charAt(i + j) != pattern.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    resultIndex.add(i);
                }
            }

            //Compute ti + 1 using ti
            if (i < N - M) {
                t = ((d * (t - input.charAt(i) * h)) + input.charAt(i + M)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pattern: ");
        String pattern = scanner.nextLine();
        System.out.println("Enter the input string: ");
        String input = scanner.nextLine();

        System.out.println("Pattern " + pattern + " is present at " + rabinKarpAlgorithm(pattern, input) + " in " + input);
    }
}