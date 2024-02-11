package com.Vivek.Greedy;

import java.util.Arrays;
import java.util.Collections;
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

    public static int maxActivity(Activity[] activities){
        int count = 1;
        Collections.sort(Arrays.asList(activities));
        System.out.println(activities[0].start + " " + activities[0].end);

        int endOfInterval = activities[0].end;

        for(int i = 1; i < activities.length; i++){
            if(activities[i].start > endOfInterval){
                count++;
                System.out.println(activities[i].start + " " + activities[i].end);
                endOfInterval = activities[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
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
