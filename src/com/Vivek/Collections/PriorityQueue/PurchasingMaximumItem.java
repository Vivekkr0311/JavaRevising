package com.Vivek.Collections.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PurchasingMaximumItem {

    static int maximumtItem(PriorityQueue<Integer> items, int sum){
        int count = 0;
        while(sum >= 0 && !items.isEmpty()){
            if(items.peek() <= sum){
                count++;
                sum -= items.peek();
                items.poll();
            }else{
                items.poll();
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many item do you have ? ");
        int n = input.nextInt();
        PriorityQueue<Integer> items = new PriorityQueue<>();
        System.out.println("Enter each item cost: ");
        for(int i = 0; i < n; i++){
            items.add(input.nextInt());
        }

        System.out.println("Enter sum of amount you have: ");
        int sum = input.nextInt();
        System.out.println("Maximum item that can be purchased with the sum " + sum + " is: " + maximumtItem(items, sum));
    }
}
