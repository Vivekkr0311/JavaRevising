package com.Vivek.Collections.Sets.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ExampleQuestionOnLinkedHashSet {

    static void printDistinctItemAsTheyAppear(Integer[] input){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for(Integer i : input)
            linkedHashSet.add(i);


        for(Integer i : linkedHashSet)
            System.out.print(i + " ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many elements? ");
        int n = input.nextInt();
        System.out.println("Enter each elements: ");
        Integer[] inputArr = new Integer[n];
        for(int i = 0; i < n; i++){
            inputArr[i] = input.nextInt();
        }

        printDistinctItemAsTheyAppear(inputArr);
    }
}
