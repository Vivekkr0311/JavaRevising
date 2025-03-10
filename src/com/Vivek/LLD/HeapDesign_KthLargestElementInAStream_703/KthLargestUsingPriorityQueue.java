package com.Vivek.LLD.HeapDesign_KthLargestElementInAStream_703;

import java.util.PriorityQueue;

public class KthLargestUsingPriorityQueue {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestUsingPriorityQueue(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }

        while (minHeap.size() > this.k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        this.minHeap.add(val);

        while (this.minHeap.size() > this.k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}
