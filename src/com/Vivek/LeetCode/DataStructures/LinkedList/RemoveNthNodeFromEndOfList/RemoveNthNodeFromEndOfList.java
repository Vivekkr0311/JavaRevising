package com.Vivek.LeetCode.DataStructures.LinkedList.RemoveNthNodeFromEndOfList;

import com.Vivek.LeetCode.DataStructures.LinkedList.LinkedList;
import com.Vivek.LeetCode.DataStructures.LinkedList.Node;

import java.util.Scanner;

public class RemoveNthNodeFromEndOfList {
    private static Node removeNthFromEnd(Node head, int n) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (n <= length) {
            temp = head;
            int pointOfRemoval = length - n;
            if (pointOfRemoval == 0) {
                head = head.next;
                return head;
            }
            while (pointOfRemoval >= 1) {
                temp = temp.next;
                pointOfRemoval--;
            }

            temp.next = temp.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);

        LinkedList list1 = new LinkedList();
        list1.insertEnd(1);
        list1.insertEnd(2);
        Node head1 = list1.getHead();
        head1.display(head1);

//        Node head = list.getHead();
//        head.display(head);

        System.out.println("Enter the position from the last which you want to remove: ");
        int idx = scanner.nextInt();

//        head = removeNthFromEnd(head, idx);
        head1 = removeNthFromEnd(head1, idx);
        head1.display(head1);
    }
}
