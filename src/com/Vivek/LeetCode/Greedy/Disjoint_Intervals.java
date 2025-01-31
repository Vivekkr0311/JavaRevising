package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Disjoint_Intervals {

    static class Pair implements Comparable<Pair>{
        int first, second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair obj){
            if(this.second > obj.second){
                return 1;
            }else if(this.second == obj.second) {
                return 0;
            }
            return -1;
        }
    }

    static int mutuallyDisjointInterval(Pair[] list){
        int count = 1;
        Collections.sort(Arrays.asList(list));

        System.out.println("( " + list[0].first + ", " + list[0].second + ")");
        int eOfInterval = list[0].second;

        for(int i = 1; i < list.length; i++){
            if(list[i].first > eOfInterval){
                count++;
                System.out.println("( " + list[i].first + ", " + list[i].second + ")");
                eOfInterval = list[i].second;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many pairs??");
        int n = input.nextInt();
        Pair[] intervals = new Pair[n];
        System.out.println("Insert each pairs: a b");
        for(int i = 0; i < n; i++){
            int f = input.nextInt();
            int s = input.nextInt();
            Pair p = new Pair(f, s);
            intervals[i] = p;
        }
        System.out.println(mutuallyDisjointInterval(intervals));
    }
}
