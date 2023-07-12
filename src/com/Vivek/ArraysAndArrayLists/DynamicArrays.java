package com.Vivek.ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

//Dynamic arrays is just a fancy word to ArrayList.
public class DynamicArrays {
    public static void main(String[] args) {
        ArrayList<Integer> arr = makesAnArraylist();
        System.out.println(arr);
    }

    static ArrayList<Integer> makesAnArraylist(){
        boolean stillWantToFillElements = true;
        Scanner flag = new Scanner(System.in);

        Scanner in = new Scanner(System.in);
        System.out.print("[?] How many elements?: ");
        int n = in.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        //In '()' you can specify size as well, like new ArrayList<>(n);
        //But as we demonstrating dynamic size array, we will not do that.
        System.out.print("[?] Inserting individual elements: ");
        for(int i = 0; i < n; i++){
            arr.add(in.nextInt());
        }

        do{
            System.out.print("[?] Do you still want to fill elements?: (true or false) ");
            stillWantToFillElements = flag.nextBoolean();
            if(stillWantToFillElements){
                System.out.print("[+] Adding some more element: ");
                arr.add(in.nextInt());
            }else if(!stillWantToFillElements){
                break;
            }
        }while(stillWantToFillElements);

        return arr;
    }
}
