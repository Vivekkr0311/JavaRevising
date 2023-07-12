package com.Vivek.ArraysAndArrayLists;

//int arr = new int[10];
//int arr -> This is done in compile time, and arr is stored in a stack memory.
//new int[10] -> This happens in runtime. It is actually Dynamic Memory Allocation, and it is stored in a heap memory.

import java.util.Scanner;

//Actual definition of an array is that Array is a continuous memory (like in C and C++), but in Java it might not be the case
//it totally depends on JVM.
//Reason is, All objects are stored in the heap memory of Java, and heaps are not continuous, and array is also an java object
//which is stored in the heap memory therefore
//it might be the case that array object is not continuous. But it totally depends on JVM because stack memory, heap
//memory which is used to run program is of JVM.
public class ArrayExample {
    public static void main(String[] args) {
        int arr[] = takingInputInAnArray();
        printingAnArray(arr);

        int arrTwoD[][] = createTwoDArray();
        printTwoDArray(arrTwoD);

        //We are using method overloading.
        System.out.println("[+] Maximum of one D array is: " + maxOfAnArray(arr));
        System.out.println("[+] Maximum of two D array is: " + maxOfAnArray(arrTwoD));

        int []reversedArray = reverseAnArray(arr);
        printingAnArray(reversedArray);
    }

    static int[] takingInputInAnArray(){
        Scanner in = new Scanner(System.in);
        System.out.print("[?] How many elements? : ");
        int n = in.nextInt();

        int []arr = new int[n];
        System.out.print("[?] Insert individual elements: ");
        for(int i = 0; i <n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println("[+] Array is created.");
        return arr;
    }

    static void printingAnArray(int []arr){
        System.out.print("[!] Elements are: ");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static int[][] createTwoDArray(){
        Scanner in = new Scanner(System.in);
        System.out.print("[?] Insert number of rows: ");
        int rows = in.nextInt();
        System.out.print("[?] Insert number of columns: ");
        int columns = in.nextInt();

        int array[][] = new int[rows][columns];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                System.out.print("[?] Insert in row: " + r + " and column " + c + ": ");
                array[r][c] = in.nextInt();
            }
        }

        return array;
    }

    static void printTwoDArray(int [][]arr){
        System.out.println("[!] Printing 2D Array: ");
        for(int temp[] : arr){
            for(int x :  temp){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static int maxOfAnArray(int []arr){

        if(arr.length == 0){
            return -1;
        }

        int max = arr[0];
         for(int x : arr){
             if(x >= max){
                 max = x;
             }
         }

         return max;
    }

    static int maxOfAnArray(int [][]arr){
        if(arr.length == 0){
            return -1;
        }

        int max = arr[0][0];

        for(int []temp : arr){
            for(int x : temp){
                if(x >= max){
                    max = x;
                }
            }
        }

        return max;
    }

    static int[] reverseAnArray(int []arr){
        int start = 0;
        int end = arr.length - 1;

        System.out.println("[!] Reversing an array: ");
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }
}
