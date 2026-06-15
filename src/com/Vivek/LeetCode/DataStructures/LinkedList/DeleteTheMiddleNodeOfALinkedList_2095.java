package com.Vivek.LeetCode.DataStructures.LinkedList;

public class DeleteTheMiddleNodeOfALinkedList_2095 {
    private static Node findJustBeforeMiddle(Node head){
        Node fast = head;
        Node slow = head;
        Node slowL = null;

        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slowL = slow;
            slow = slow.next;
        }

        return slowL;
    }

    private static Node deleteMiddle(Node head) {
        if(head == null) return null;
        if(head.next == null) return null;

        Node middle = findJustBeforeMiddle(head);
        middle.next = middle.next.next;
        return head;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertEnd(1);
        linkedList.insertEnd(3);
        linkedList.insertEnd(4);
        linkedList.insertEnd(7);
        linkedList.insertEnd(1);
        linkedList.insertEnd(2);
        linkedList.insertEnd(6);

        Node head = linkedList.getHead();

        deleteMiddle(head);
        linkedList.display();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertEnd(1);
        linkedList2.insertEnd(2);
        linkedList2.insertEnd(3);
        linkedList2.insertEnd(4);

        deleteMiddle(linkedList2.getHead());
        linkedList2.display();
    }
}
