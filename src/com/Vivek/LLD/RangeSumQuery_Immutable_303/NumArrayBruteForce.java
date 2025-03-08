package com.Vivek.LLD.RangeSumQuery_Immutable_303;

public class NumArrayBruteForce {
    private int[] nums;

    public NumArrayBruteForce(int[] nums) {
        this.nums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += this.nums[i];
        }
        return sum;
    }
}
