package com.Vivek.LeetCode.DataStructures.LinkedList.RemoveDuplicates;

import com.Vivek.LeetCode.DataStructures.LinkedList.LinkedList;
import com.Vivek.LeetCode.DataStructures.LinkedList.Node;

public class RemoveDuplicates {
    private static Node deleteDuplicates(Node head) {
        if (head == null) {
            return head;
        }

        Node node = head;

        while (node.next != null) {
            if (node.data == node.next.data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertEnd(1);
        list1.insertEnd(2);
        list1.insertEnd(2);
        list1.insertEnd(3);
        list1.insertEnd(4);
        list1.insertEnd(5);
        list1.insertEnd(5);
        list1.insertEnd(6);
        Node head1 = list1.getHead();

        head1 = deleteDuplicates(head1);
        head1.display(head1);
    }
}
