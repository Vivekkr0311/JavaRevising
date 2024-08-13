package com.Vivek.Assignment.Question_1;

import java.util.Scanner;

public class Solution {
    private static void printList(Node head){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    private static Node removeNode(int val, Node head){
        if(head == null){
            // empty list
            return null;
        }

        if(head.data > val && head.next == null){
            // list with only 1 node
            head = null;
            return head;
        }

        Node prev = head;
        Node curr = prev.next;

        while(prev.data > val){
            // when first node is always greater than the x
            head = prev.next;
            prev = head;
            curr = prev.next;
        }

        while(curr != null){
            // greater value found in middle or at the end
            if(curr.data > val){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scnaner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scnaner.nextInt();

        Node head = null;
        Node tail = head;

        for(int i = 0; i < n; i++){
            int temp = scnaner.nextInt();
            Node node = new Node(temp);
            if(head == null){
                head = node;
                tail = head;
            }else{
                tail.next = node;
                tail = node;
            }
        }

        System.out.print("Enter x: ");
        int val = scnaner.nextInt();
        printList(head);
        head = removeNode(val, head);
        printList(head);
    }
}
