package com.Vivek.LLD.RangeSumQuery_Immutable_303;

public class NumArrayUsingPrefixSum {
    private int[] prefixSum;

    public NumArrayUsingPrefixSum(int[] nums) {
        this.prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}
