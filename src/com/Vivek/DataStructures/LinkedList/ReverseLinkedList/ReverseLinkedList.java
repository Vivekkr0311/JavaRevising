package com.Vivek.DataStructures.LinkedList.ReverseLinkedList;

import com.Vivek.DataStructures.LinkedList.LinkedList;
import com.Vivek.DataStructures.LinkedList.Node;

public class ReverseLinkedList {
    private static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
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
        head = reverseList(head);
        head.display(head);
    }
}
