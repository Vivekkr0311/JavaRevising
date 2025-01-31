package com.Vivek.LeetCode.DataStructures.LinkedList.ReverseLinkedListII;

import com.Vivek.LeetCode.DataStructures.LinkedList.LinkedList;
import com.Vivek.LeetCode.DataStructures.LinkedList.Node;

import java.util.Scanner;

public class ReverseLinkedListII {
    private static Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }

        Node curr = head;
        Node prev = null;

        for(int i = 0; curr != null && i < left - 1; i++){
            prev = curr;
            curr = curr.next;
        }

        Node last = prev;
        Node newEnd = curr;

        Node next = curr.next;
        for(int i = 0; curr != null && i < right - left + 1; i++){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertEnd(1);
        linkedList.insertEnd(2);
        linkedList.insertEnd(3);
        linkedList.insertEnd(4);
        linkedList.insertEnd(5);
        Node head = linkedList.getHead();
        head.display(head);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first position: ");
        int left = scanner.nextInt();

        System.out.println("Enter second position: ");
        int right = scanner.nextInt();

        head = reverseBetween(head, left, right);
        head.display(head);
    }
}
