package com.Vivek.LLD.RangeSumQuery_Immutable_303;

public class RunnerClass {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        NumArrayBruteForce arr = new NumArrayBruteForce(nums);
        int sum = arr.sumRange(0, 3);
        int sum2 = arr.sumRange(0, 1);
        int sum3 = arr.sumRange(1, 3);
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println("-------------------------");
        NumArrayUsingPrefixSum arr2 = new NumArrayUsingPrefixSum(nums);
        sum = arr2.sumRange(0, 3);
        sum2 = arr2.sumRange(0, 1);
        sum3 = arr2.sumRange(1, 3);
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);

    }
}
