package com.Vivek.DataStructures.LinkedList.MergeTwoSortedList;

import com.Vivek.DataStructures.LinkedList.LinkedList;
import com.Vivek.DataStructures.LinkedList.Node;

public class MergeTwoSortedList {
    private static Node mergeTwoLists(Node list1, Node list2) {
        Node ansHead = new Node();
        Node tail = ansHead;
        Node first = list1;
        Node second = list2;
        while(first != null && second != null){
            Node newNode;
            if(first.data <= second.data){
                newNode = new Node(first.data);
                first = first.next;
            }else{
                newNode = new Node(second.data);
                second = second.next;
            }
            tail.next = newNode;
            tail = tail.next;
        }

        while(first != null){
            Node node = new Node(first.data);
            tail.next = node;
            tail = tail.next;
            first = first.next;
        }

        while(second != null){
            Node node = new Node(second.data);
            tail.next = node;
            tail = tail.next;
            second = second.next;
        }
        return ansHead.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertEnd(1);
        list1.insertEnd(4);
        list1.insertEnd(5);
        list1.insertEnd(6);
        Node head1 = list1.getHead();
        
        LinkedList list2 = new LinkedList();
        list2.insertEnd(2);
        list2.insertEnd(3);
        list2.insertEnd(7);
        list2.insertEnd(8);
        Node head2 = list2.getHead();
        
        Node head = mergeTwoLists(head1, head2);
        head.display(head);
    }
}
