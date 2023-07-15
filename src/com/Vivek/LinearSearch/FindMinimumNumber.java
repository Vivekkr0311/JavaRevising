package com.Vivek.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinimumNumber {
    public static void main(String[] args) {
        int[] arr = createAnArray();
        System.out.println(minimumNumber(arr));
    }

    static int[] createAnArray(){
        System.out.print("[?] How many element do you want in you array?: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.print("[?] Insert every element: ");
        int[] arr = new int[number];

        for(int idx = 0; idx < number; idx++){
            arr[idx] = in.nextInt();
        }

        System.out.println("[+] Array created: " + Arrays.toString(arr));
        return arr;
    }

    static int minimumNumber(int []arr){
        if(arr.length == 0){
            System.out.println("[-] Array length is 0.");
            return -1;
        }

        int minimumNumber = arr[0];
        for(int idx = 1; idx < arr.length; idx++){
            if(arr[idx] < minimumNumber){
                minimumNumber = arr[idx];
            }
        }

        System.out.println("[+] Minimum number is: " +  minimumNumber);
        return minimumNumber;
    }
}
