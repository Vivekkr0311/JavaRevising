package com.Vivek.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JobSequencingProblem {

    public static class Job {

        int id;
        int deadline;
        int profit;

        Job(int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString(){
            return "(" + this.deadline + ", " + this.profit + ")";
        }
    }

    public static class MyCmp implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2){
            return (j1.deadline - j2.deadline);
        }
    }

    public static class MyCmpProfit implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2){
            return -(j1.profit - j2.profit);
        }
    }

    static int maximumDeadline(Job[] job){
        System.out.println(Arrays.toString(job));
        int maxDeadline = job[1].deadline;

        for(int i = 2; i < job.length; i++){
            if(job[i].deadline > maxDeadline){
                maxDeadline = job[i].deadline;
            }
        }
        return maxDeadline;
    }

    public static int searchAndPutSlot(int[] takenJob, int slotNumber){
        int slotIdx = -1;
        int pointOne = -1;
        for(int i = takenJob.length; i > 0; i--){
            if(takenJob[i] == -1 && slotNumber <= i){
                continue;
            }else if(slotNumber > i){
                pointOne = i + 1;
                break;
            }
        }

        for(int i = pointOne; i < takenJob.length; i++){
            if(takenJob[i] == -1){
                slotIdx = i;
            }
        }
        return slotIdx;
    }

    public static int jobSequence(Job[] jobs){
        Arrays.sort(jobs, new MyCmpProfit());
//        int deadline = jobs[jobs.length - 1].deadline;
        int maxDeadline = 0;
        for(int i = 0; i < jobs.length; i++){
            if(jobs[i].deadline > maxDeadline){
                maxDeadline = jobs[i].deadline;
            }
        }

        int[] takenJob = new int[maxDeadline + 1];
        for(int i = 1; i <= maxDeadline; i++){
            takenJob[i] = -1;
        }

        int countJob = 0; int profit = 0;
        for(int i = 0; i < jobs.length; i++){
            for(int j = jobs[i].deadline; j > 0; j--){
                if(takenJob[j] == -1){
                    takenJob[j] = i;
                    countJob++;
                    profit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Profit: " + profit);
        return countJob;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many jobs do you have ?");
        int n = input.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Give each job id, deadline and profit: ");
        for(int i = 0; i < n; i++){
//            int id = input.nextInt();
            int value = input.nextInt();
            int weight = input.nextInt();
            jobs[i] = new Job(value, weight);
        }

//        2 100
//        1 50
//        2 10
//        1 20
//        3 30
//        System.out.println("Give your deadline to finish: ");
//        int deadline = input.nextInt();
        System.out.println("Number of jobs you can complete: " + jobSequence(jobs));
    }
}
