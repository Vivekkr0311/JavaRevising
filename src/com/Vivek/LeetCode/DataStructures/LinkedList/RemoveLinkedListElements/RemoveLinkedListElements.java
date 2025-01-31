package com.Vivek.LeetCode.DataStructures.LinkedList.RemoveLinkedListElements;

import com.Vivek.LeetCode.DataStructures.LinkedList.LinkedList;
import com.Vivek.LeetCode.DataStructures.LinkedList.Node;

import java.util.Scanner;

public class RemoveLinkedListElements {
    private static Node removeElements(Node head, int val) {
        if (head == null) {
            return head;
        }

        while (head != null && head.data == val) {
            head = head.next;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            if (curr.data == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(6);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        list.insertEnd(6);

        Node head = list.getHead();
        head.display(head);

        System.out.println("Enter which value you want to remove: ");
        int val = scanner.nextInt();

        head = removeElements(head, val);
        head.display(head);

    }
}