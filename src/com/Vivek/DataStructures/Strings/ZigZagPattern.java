package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class ZigZagPattern {

    private static void convert(String s, int numRows){
        String ans = "";
        int div = s.length() / numRows;
        int givR = numRows;
        numRows = numRows + 1;
        for(int i = 0; i < s.length(); i++){
            if(numRows > 0){
                for(int j = i; j < s.length(); j += numRows){
                    System.out.print(s.charAt(j) + " ");
//                    ans = ans + s.charAt(j);
                }
            }else{
                break;
            }
            numRows /= div;
            System.out.println();
        }
//        System.out.println(ans.substring(0, ans.length() - givR));
    }

    private static void convert2(String s, int numRows){
        if(numRows == 1){
            System.out.println(s);
        }

        String ans = "";
        for(int i = 0; i < numRows; i++){
            int increment = 2 * (numRows - 1);
            for(int j = i; j < s.length(); j+=increment){
                ans = ans + s.charAt(j);
                if((i > 0) && (i < numRows - 1) && ((j + increment - 2 * i) < s.length())){
                    ans = ans + s.charAt(j + increment - 2 * i);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();
        System.out.println("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        convert2(s,numRows);
    }
}
