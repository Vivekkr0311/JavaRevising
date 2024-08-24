package com.Vivek.DataStructures.Strings;

import java.util.Scanner;

public class ZigZagPattern {

//    private static void convert(String s, int numRows){
//
//        String ans = "";
//        int gR = numRows;
//
//        int k = 0;
//        for(int rows = gR; rows > 0; rows--){
//            if(rows == 1){
//                for(int i = k; i < s.length(); i += 2*gR - 2){
//                    ans = ans + s.charAt(i);
//                }
//                rows = 0;
//                break;
//            }
//
//            if(rows == 0){
//                break;
//            }
//            for(int i = k; i < s.length(); i += 2 * rows - 2){
//                ans = ans + s.charAt(i);
//            }
//            k++;
//        }
//
//        System.out.println(ans);
////        System.out.println(ans.substring(0, ans.length() - givR));
//    }

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

    private static void convert3(String s, int numRows){
        if(numRows == 1){
            System.out.println(s);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i = 0; i < numRows; i++){
            int south = 2 * (numRows - 1 - i);
            int north = 2 * i;
            int idx = i;
            boolean goingSouth = true;
            while(idx < n){
                sb.append(s.charAt(idx));
                if(i == 0){
                    idx += south;
                }else if(i == numRows - 1){
                    idx += north;
                }else{
                    if(goingSouth){
                        idx += south;
                    }else{
                        idx += north;
                    }
                    goingSouth = !goingSouth;
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scanner.nextLine();
        System.out.println("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        convert3(s,numRows);
    }
}
