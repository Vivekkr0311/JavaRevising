package com.Vivek.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;
public class LinearSearchExample {
    public static void main(String[] args) {
        int[] arr = createAnArray();
        System.out.println(linearSearch(arr));
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

    static int linearSearch(int []arr){
        if(arr.length == 0){
            System.out.println("[-] Array length is 0.");
            return -1;
        }
        System.out.print("[?] What element do want to search?: ");
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();

        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx] == target){
                System.out.println("[+] Element found at index: " + idx);
                return idx;
            }
        }

        System.out.println("[-] Sorry element did not found.");
        return -1;
    }
}
