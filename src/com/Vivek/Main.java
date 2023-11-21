package com.Vivek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("What is your name?? \n");
        String name = input.nextLine();
        System.out.println("What is your dob?? \n");
        int dob = input2.nextInt();

        if((dob == 1) && name.equals("Jelly")){
            System.out.println("Happy Birthday " + name);
        }else{
            System.out.println("Sirf jelly ke liye hai ye computer program.");
        }
    }
}
