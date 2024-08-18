package com.Vivek.DataStructures.LinkedList.Questions.ReverseLinkedList;

import com.Vivek.DataStructures.LinkedList.Questions.LL;

import java.util.Scanner;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements ?");
        int n = scanner.nextInt();

        LL list = new LL();

        System.out.println("Insert each elements: ");
        for(int i = 0; i < n; i++){
            list.insertLast(scanner.nextInt());
        }

        list.printList();
    }
}
