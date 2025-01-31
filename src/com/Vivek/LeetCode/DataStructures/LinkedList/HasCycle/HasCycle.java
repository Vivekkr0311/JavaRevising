package com.Vivek.LeetCode.DataStructures.LinkedList.HasCycle;

import com.Vivek.LeetCode.DataStructures.LinkedList.Node;

public class HasCycle {
    private static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
