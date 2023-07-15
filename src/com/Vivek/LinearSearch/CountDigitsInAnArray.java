package com.Vivek.LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class CountDigitsInAnArray {
    public static void main(String[] args) {
        int []arr = createArray();
        numberOfDigitHavingEvenNumberOfDigits(arr);
    }

    static int[] createArray(){
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
    static int countDigit(int number){
        int count = 0;
        while(number > 0){
            count++;
            number /= 10;
        }

        return count;
    }

    static int numberOfDigitHavingEvenNumberOfDigits(int arr[]){
        if(arr.length == 0){
            System.out.println("[-] Array lenght is 0");
            return -1;
        }

        int count = 0;
        for(int number : arr){
            if(countDigit(number)%2 == 0){
                count++;
            }
        }

        System.out.println("[+] Total number of digits which are having even number of digits are: " + count);
        return count;
    }
}
