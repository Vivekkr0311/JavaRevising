package com.Vivek.LeetCode.DataStructures.LinkedList.Questions.ReverseLinkedList;

import com.Vivek.LeetCode.DataStructures.LinkedList.Questions.LL;
import com.Vivek.LeetCode.DataStructures.LinkedList.Questions.LL.Node;

import java.util.Scanner;

public class ReverseLinkedList {

    private static Node reverseLinkedList(Node head){
        if(head == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node nex = curr.next;
        while(nex != null){
            curr.next = prev;
            prev = curr;
            curr = nex;
            nex = nex.next;
        }
        curr.next = prev;
        head = curr;
        return head;
    }

    private static Node reverseLinkedList_2(Node head){
        if(head == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node nex = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = nex;
            if(nex == null){
                break;
            }
            nex = nex.next;
        }

        return prev;
    }

    private static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +  " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements ?");
        int n = scanner.nextInt();

        LL list = new LL();

        System.out.println("Insert each elements: ");
        for(int i = 0; i < n; i++){
            list.insertLast(scanner.nextInt());
        }

        Node head = list.getHead();
        printList(head);
        head = reverseLinkedList(head);
        printList(head);
        head = reverseLinkedList_2(head);
        printList(head);
    }
}
