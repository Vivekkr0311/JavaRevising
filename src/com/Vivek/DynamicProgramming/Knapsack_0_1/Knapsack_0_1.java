package com.Vivek.DynamicProgramming.Knapsack_0_1;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_0_1 {

    static class Item implements Comparable<Item> {
        private int profit;
        private int weight;

        Item(int p, int w){
            this.profit = p;
            this.weight = w;
        }

        @Override
        public int compareTo(Item o){
            double r1 = (double) o.profit / o.weight;
            double r2 = (double) this.profit / this.weight;
            if(r1 == r2){
                return 0;
            }else if(r1 < r2){
                return -1;
            }
            return 1;
        }

        @Override
        public String toString(){
            double r2 = (double) this.profit / this.weight;
            return "(" + this.profit + ", " + this.weight + ") " + r2;
        }
    }

    static int knapsack_0_1(Item[] items, int capacity){
        Arrays.sort(items);

        int profit = 0;
        for(int i = 0; i < items.length; i++){
            System.out.println(items[i].profit + " " + items[i].weight);
            if(capacity - items[i].weight >= 0 && capacity >= 0){
                capacity = capacity - items[i].weight;
                profit = profit + items[i].profit;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of items: ");
        int n = input.nextInt();
        System.out.println("Enter each item profit and weight: ");
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++){
            int p = input.nextInt();
            int w = input.nextInt();
            items[i] = new Item(p, w);
        }
        System.out.println("Enter knapsack capacity: ");
        int k = input.nextInt();
        System.out.println("Maximum profit you can get: " + knapsack_0_1(items, k));
    }
}
