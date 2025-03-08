package com.Vivek.LLD.HeapDesign_KthLargestElementInAStream_703;

import java.util.ArrayList;
import java.util.Collections;

public class KthLargestBruteForce {
    private ArrayList<Integer> nums;
    private int k;

    public KthLargestBruteForce(int k, int[] nums) {
        this.nums = new ArrayList<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            this.nums.add(nums[i]);
        }
    }

    public int add(int val) {
        this.nums.add(val);
        Collections.sort(this.nums);
        int kthLargest = this.nums.get(this.nums.size() - k);
        return kthLargest;
    }
}
