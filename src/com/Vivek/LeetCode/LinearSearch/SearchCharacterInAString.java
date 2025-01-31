package com.Vivek.LeetCode.LinearSearch;

import java.util.Scanner;

public class SearchCharacterInAString {
    public static void main(String[] args) {
     String inputString = takeInputString();
     searchCharacterInAString(inputString);
    }

    static String takeInputString(){
        System.out.print("[?] Insert your string: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    static boolean searchCharacterInAString(String str){
        if(str.length() == 0){
            System.out.println("[-] String length is 0.");
            return false;
        }
        System.out.print("[?] What character do want to search?: ");
        Scanner in = new Scanner(System.in);
        char target = in.nextLine().trim().charAt(0);

        for(int idx = 0; idx < str.length(); idx++){
            if(str.charAt(idx) == target){
                System.out.println("[+] Character found at index: " + idx);
                return true;
            }
        }

        System.out.println("[-] Sorry character did not found.");
        return false;
    }
}
