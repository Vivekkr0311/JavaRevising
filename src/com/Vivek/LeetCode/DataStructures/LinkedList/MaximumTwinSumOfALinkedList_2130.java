package com.Vivek.LeetCode.DataStructures.LinkedList;

public class MaximumTwinSumOfALinkedList_2130 {
    public static int[] valueArry(Node halfWayHead, int totalLength) {
        int[] tempArr = new int[totalLength];
        Node temp = halfWayHead;

        for (int i = 0; i < totalLength && temp != null; i++) {
            tempArr[i] = temp.data;
            temp = temp.next;
        }
        return tempArr;
    }

    public static Node getHalfWayPointer(int halfWayLength, Node head) {
        Node temp = head;
        for (int i = 0; i <= halfWayLength && temp != null; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static int getLength(Node head) {
        Node temp = head;

        int ans = 0;
        while (temp != null) {
            temp = temp.next;
            ans++;
        }

        return ans;
    }

    private static int pairSumHelper(Node head, int halfWayIdx, int[] halfListValues){
        Node temp = head;
        int lastIdx = halfListValues.length - 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= halfWayIdx; i++){
            int currSum = temp.data +  halfListValues[lastIdx--];
            ans = Math.max(currSum, ans);
            temp = temp.next;
        }
        return ans;
    }
    public static int pairSum(Node head) {

        int n = getLength(head);
        int halfLength = (n / 2) - 1;
        Node halfWayP = getHalfWayPointer(halfLength, head);
        int[] valueArry = valueArry(halfWayP, n - halfLength - 1);
        return pairSumHelper(head, halfLength, valueArry);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertEnd(4);
        linkedList.insertEnd(2);
        linkedList.insertEnd(2);
        linkedList.insertEnd(3);

        Node head = linkedList.getHead();

        System.out.println(pairSum(head));
    }
}
