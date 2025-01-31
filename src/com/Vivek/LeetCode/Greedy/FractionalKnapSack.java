package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapSack {

    static class Item {
        int value;
        int weight;

        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return "(" + this.value + ", " + this.weight + " )";
        }
    }

    static class MyCmpWeight implements Comparator<Item> {
        @Override
        public int compare(Item a1, Item a2) {
            return a1.weight - a2.weight;
        }
    }

    static class MyCmpValues implements Comparator<Item> {
        @Override
        public int compare(Item a1, Item a2) {
            return -(a1.value - a2.value);
        }
    }

    static class MyCmpProfitOverWeight implements Comparator<Item>{
        @Override
        public int compare(Item a1, Item a2){
            return -((a1.value/a1.weight) - (a2.value/a2.weight));
        }
    }

    public static double fractionalKnapSackGreedyAboutValues(Item[] items, int capacity){
        double count = 1;
        Arrays.sort(items, new MyCmpValues());
        System.out.println(Arrays.toString(items));
        int totalProfit = items[0].value;
        capacity -= items[0].weight;
        for(int i = 1; i < items.length; i++){
            if(capacity >= 0 && capacity >= items[i].weight){
                totalProfit += items[i].value;
                capacity -= items[i].weight;
                count++;
            }else{
                totalProfit += items[i].value * ((double)capacity / items[i].weight);
                count += (double)capacity / items[i].weight;
                break;
            }
        }
        System.out.println("Total Profit: " + totalProfit);
        return count;
    }

    public static double fractionalKnapSackGreedyAboutSmallestWeight(Item[] items, int capacity){
        double count = 1;
        Arrays.sort(items, new MyCmpWeight());
        System.out.println(Arrays.toString(items));
        int totalProfit = items[0].value;
        capacity -= items[0].weight;
        for(int i = 1; i < items.length; i++){
            if(capacity >= 0 && capacity >= items[i].weight){
                totalProfit += items[i].value;
                capacity -= items[i].weight;
                count++;
            }else{
                totalProfit += items[i].value * ((double)capacity / items[i].weight);
                count += (double)capacity / items[i].weight;
                break;
            }
        }
        System.out.println("Total Profit: " + totalProfit);
        return count;
    }

    public static double fractionalKnapSackGreedyAboutValueOverWeight(Item[] items, int capacity){
        double count = 1;
        Arrays.sort(items, new MyCmpProfitOverWeight());

        System.out.println(Arrays.toString(items));
        int totalProfit = items[0].value;
        capacity -= items[0].weight;
        for(int i = 1; i < items.length; i++){
            if(capacity >= 0 && capacity >= items[i].weight){
                totalProfit += items[i].value;
                capacity -= items[i].weight;
                count++;
            }else{
                totalProfit += items[i].value * ((double)capacity / items[i].weight);
                count += (double)capacity / items[i].weight;
                break;
            }
        }
        System.out.println("Total Profit: " + totalProfit);
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many item do you have ?");
        int n = input.nextInt();
        Item[] items = new Item[n];
        System.out.println("Enter each item value and weight: ");
        for(int i = 0; i < n; i++){
            int value = input.nextInt();
            int weight = input.nextInt();
            items[i] = new Item(value, weight);
        }

//        60 10
//        40 40
//        100 20
//        120 30
        System.out.println("Enter total capacity: ");
        int capacity = input.nextInt();
        double result = fractionalKnapSackGreedyAboutValues(items, capacity);

        System.out.println("Maximum item that you can have when greedy about values/ profit: " + result + "\n");
        double resultTwo = fractionalKnapSackGreedyAboutSmallestWeight(items, capacity);
        System.out.println("Maximum item that you can have when greedy about having item with smallest weight: " + resultTwo + "\n");
        double resultThree = fractionalKnapSackGreedyAboutValueOverWeight(items, capacity);
        System.out.println("Maximum item that you can have when greedy about value over weight: " + resultThree + "\n");
    }
}
