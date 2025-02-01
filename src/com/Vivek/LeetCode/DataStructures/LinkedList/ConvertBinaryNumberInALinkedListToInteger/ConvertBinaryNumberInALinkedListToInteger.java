package com.Vivek.LeetCode.DataStructures.LinkedList.ConvertBinaryNumberInALinkedListToInteger;

import com.Vivek.LeetCode.DataStructures.LinkedList.LinkedList;
import com.Vivek.LeetCode.DataStructures.LinkedList.Node;

public class ConvertBinaryNumberInALinkedListToInteger {
    private static int getDecimalValue(Node head) {
        Node temp = head;
        int length = 0;
        int decimal = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        temp = head;
        while (length > 0) {
            decimal = decimal + temp.data * (1 << (length - 1));
            temp = temp.next;
            length--;
        }
        return decimal;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.insertEnd(1);
        list.insertEnd(0);
        list.insertEnd(1);

        list2.insertEnd(0);

        Node head = list.getHead();
        Node head2 = list2.getHead();
        head.display(head);

        int decimal = getDecimalValue(head);
        int decimal2 = getDecimalValue(head2);
        System.out.println("List in decimal: " + decimal);
        System.out.println("List in decimal: " + decimal2);
    }
}
