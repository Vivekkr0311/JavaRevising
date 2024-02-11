package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySolutionProblem {

    // This problem is similar to Disjoint intervals.
    static class Activity implements Comparable<Activity>{

        int start;
        int end;
        Activity(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return this.start + " " + this.end;
        }

        @Override
        public int compareTo(Activity obj){
            if(obj.end > this.end){
                return 1;
            }else if(obj.end ==  this.end){
                return 0;
            }
            return -1;
        }
    }

    static class MyCmp implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.end - a2.end;
        }
    }

    public static int maxActivity(Activity[] activities){
        int count = 1;
//        Collections.sort(Arrays.asList(activities));
        Arrays.sort(activities, new MyCmp());
        int prev = 0;
        for(int i = 1; i < activities.length; i++){
            if(activities[i].start >= activities[prev].end){
                count++;
                prev = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        12 25
//        10 20
//        20 30
        Scanner input = new Scanner(System.in);
        System.out.println("How many activity do you have ?");
        int n = input.nextInt();
        Activity[] activities = new Activity[n];
        System.out.println("Enter each activity start and end: ");
        for(int i = 0; i < n; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            activities[i] = new Activity(start, end);
        }

        int result = maxActivity(activities);
        System.out.println("Maximum activities that can happen without collide: " + result);
    }
}
