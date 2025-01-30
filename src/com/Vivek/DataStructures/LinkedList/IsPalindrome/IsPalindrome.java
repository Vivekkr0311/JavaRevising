package com.Vivek.DataStructures.LinkedList.IsPalindrome;

import com.Vivek.DataStructures.LinkedList.LinkedList;
import com.Vivek.DataStructures.LinkedList.Node;

import java.util.Stack;

public class IsPalindrome {
    private static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }

        if (head != null && head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.data != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertEnd(1);
        linkedList.insertEnd(2);
        linkedList.insertEnd(2);
        linkedList.insertEnd(1);

        Node head = linkedList.getHead();
        System.out.println("List is palindrome: " + isPalindrome(head));
    }
}