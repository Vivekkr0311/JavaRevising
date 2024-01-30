package com.Vivek.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fuel_10 {

    static int[] doubleTheArray(int[] arr){
        int n = arr.length;
        int[] temp = new int[n * 2];
        for(int i = 0; i < n; i++){
            temp[i] = arr[i];
        }
        for(int i = n; i < temp.length; i++){
            temp[i] = arr[i - n];
        }
        return temp;
    }

    static int[] calculateCost(int[] gas, int[] cost, int start, int end, int curr){
        int idx = -1;
        for(int i = start; i < end; i++){
            curr = curr + gas[i] - cost[i];
            if(curr < 0){
                return new int[]{-1, -1};
            }
            idx = i;
        }
        return new int[]{curr, idx};
    }

    static void fuel(int[] gas, int[] cost){
        int[] doubleGasArray = doubleTheArray(gas);
        int[] doubleCostArray = doubleTheArray(cost);
        int n = gas.length;
        int curr = 0;
        int ansIdx = 0;
        for(int startSegment = 0; startSegment + n < doubleCostArray.length; startSegment++){
            int[] ansArr = calculateCost(doubleGasArray, doubleCostArray, startSegment, startSegment + n, curr);
             curr = ansArr[0];
             if(curr < 0){
                 curr = 0;
                 continue;
             }
             ansIdx = ansArr[1] % n + 1;
        }
        System.out.println("Cost is " + curr + " and starting idx will be " + ansIdx);
    }

    public static int canCompleteCircuit(int[] A, int[] B) {
        int n = A.length;

        int curr = 0;
        int start = 0;
        for (int i = 0; i < n * 2; i++) {
            int g = A[i % n];
            int c = B[i % n];

            if (i == start + n) {
                return start;
            }

            curr = curr + g - c;

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return -1;
    }

    static int canCompleteCircuitEfficient(int[] gas, int[] cost){
        int total = 0;
        int curr = 0;
        int station = 0;
        for(int i = 0; i < cost.length; i++) {
            int diff = gas[i] - cost[i];
            curr += diff;
            total += diff;
            if(curr < 0) {
                curr = 0;
                station = (i + 1) % cost.length;
            }
        }
        return total >= 0 ? station : -1;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of station: ");
        int n = input.nextInt();
        int[] gas = new int[n];
        System.out.println("Enter gas: ");
        for(int i = 0; i < n; i++){
            gas[i] = input.nextInt();
        }

        int[] cost = new int[n];
        System.out.println("Enter cost: ");
        for(int i = 0; i < n; i++){
            cost[i] = input.nextInt();
        }

//        Enter gas:
//        3 5 2 1 7
//        Enter cost:
//        4 2 1 9 1
//        Enter gas:
//        1 2 3 4 5
//        Enter cost:
//        3 4 5 1 2
        fuel(gas, cost);
//        System.out.println(Arrays.toString(doubleTheArray(gas)));
//        System.out.println(canCompleteCircuit(gas, cost));
//        System.out.println(calculateCost(gas, cost, 0, n, 3));
    }
}
