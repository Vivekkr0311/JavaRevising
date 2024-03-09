package com.Vivek.CustomDataStructures.LinkedList.MergeLists;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        this.size++;

        if(tail == null){
            tail = head;
        }
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(tail == null){
            insertFirst(data);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        this.size++;
    }

    public void insertAt(int data, int idx){
        if(idx > size){
            System.out.println("cannot insert at " + idx);
            System.out.println("List size is " + getSize());
            return;
        }
        if(idx == 0){
            insertFirst(data);
            return;
        }
        if(idx == size){
            insertEnd(data);
            return;
        }
        Node temp = head;
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }
        Node newNode = new Node(data, temp.next);
        temp.next = newNode;
        size++;
    }

    private Node insertRecursion(Node node, int data, int idx){
        if(idx == 0) {
            Node temp = new Node(data, node);
            size++;
            return temp;
        }
        node.next = insertRecursion(node.next, data, idx - 1);
        return node;
    }

    public void insertAtRecursion(int data, int idx){
        head = insertRecursion(head, data, idx);
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" END");
    }

    public void deleteFirst(){
        head = head.next;
        size--;
    }

    public void deleteEnd(){
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void deleteFrom(int idx){
        if(idx < 0){
            System.out.println("Invalid idx");
            return;
        }
        if(idx > size){
            System.out.println("Size is " + getSize());
            System.out.println("Cannot delete from " + idx);
            return;
        }
        if(idx == 0){
            deleteFirst();
            return;
        }
        if(idx == size){
            deleteEnd();
            return;
        }
        Node temp = head;
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public int getSize(){
        return this.size;
    }

    // Merge two sorted list
    public static LL merge(LL head1, LL head2){
        Node temp1 = head1.head;
        Node temp2 = head2.head;
        LL newList = new LL();

        while(temp1 != null && temp2 != null){
            if(temp1.data < temp2.data){
                newList.insertEnd(temp1.data);
                temp1 = temp1.next;
            }else{
                newList.insertEnd(temp2.data);
                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
            newList.insertEnd(temp1.data);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            newList.insertEnd(temp2.data);
            temp2 = temp2.next;
        }
        return newList;
    }

    public static void main(String[] args) {
        LL list1 = new LL();

        list1.insertEnd(1);
        list1.insertEnd(3);
        list1.insertEnd(5);
//        list1.insertEnd(3);
//        list1.insertEnd(9);

        LL list2 = new LL();

        list2.insertEnd(14);
        list2.insertEnd(55);
        list2.insertEnd(70);
        list2.insertEnd(100);

        list1.display();
        list2.display();

        LL newList = merge(list1, list2);
        newList.display();
    }
}
