package com.Vivek.DataStructures.LinkedList.IntersectionOfTwoLists;

import com.Vivek.DataStructures.LinkedList.LinkedList;
import com.Vivek.DataStructures.LinkedList.Node;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntersectionOfTwoLists {
    private static void makeIntersectionLists(Node head1, Node head2, int val) {
        Node temp = head1;

        Node intersectionNode = null;
        while (temp != null) {
            if (temp.data == val) {
                intersectionNode = temp;
                break;
            }
            temp = temp.next;
        }

        Node temp2 = head2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        temp2.next = intersectionNode;
    }

    private static Node getIntersectionNode(Node nodeA, Node nodeB) {
        if (nodeA == null || nodeB == null) {
            return null;
        }

        Set<Node> set = new HashSet<>();

        Node temp = nodeA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = nodeB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insertEnd(4);
        list1.insertEnd(1);
        list1.insertEnd(8);
        list1.insertEnd(4);
        list1.insertEnd(5);

        list2.insertEnd(5);
        list2.insertEnd(6);
        list2.insertEnd(1);

        Node head1 = list1.getHead();
        Node head2 = list2.getHead();

        System.out.println("Without intersection: ");
        head1.display(head1);
        head2.display(head2);

        System.out.println("Insert at which node you want to make list1 and list2 intersect: ");
        int val = scanner.nextInt();

        makeIntersectionLists(head1, head2, val);

        System.out.println("With intersection: ");
        head1.display(head1);
        head2.display(head2);

        Node intersectionPoint = getIntersectionNode(head1, head2);
        System.out.println("Intersection point: " + intersectionPoint.data);
    }
}
