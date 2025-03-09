package com.Vivek.LLD.HeapDesign_KthLargestElementInAStream_703;

import java.util.Arrays;

public class MaxHeap {
    private int heapsize;
    private int[] a;
    private int k;

    public MaxHeap(int k, int[] arr) {
        this.k = k;
        this.heapsize = arr.length;
        this.a = Arrays.copyOf(arr, arr.length);
        buildHeap();
    }

    private void buildHeap() {
        for (int i = heapsize / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public int add(int val) {
        if (heapsize == a.length) {
            a = Arrays.copyOf(a, heapsize * 2);
        }

        a[heapsize] = val;
        heapsize++;
        int i = heapsize - 1;

        // Fix the max heap property
        while (i > 0 && a[parent(i)] < a[i]) {
            swap(i, parent(i));
            i = parent(i);
        }

        return kthLargest();
    }

    public void displayHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(a, heapsize)));
    }

    public int kthLargest() {
        int result = -1;
        MaxHeap tempHeap = new MaxHeap(this.k, Arrays.copyOf(a, heapsize));

        for (int i = 0; i < k; i++) {
            result = tempHeap.extractMax();
        }

        return result;
    }

    public int extractMax() {
        if (heapsize < 1) {
            System.out.println("Heap underflow");
            return -1;
        }

        int max = a[0];
        a[0] = a[heapsize - 1];
        heapsize--;
        maxHeapify(0);
        return max;
    }

    private void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapsize && a[l] > a[largest]) {
            largest = l;
        }

        if (r < heapsize && a[r] > a[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 14, 10, 8, 7, 9, 3, 2, 4, 6};
        int k = 3;
        MaxHeap maxHeap = new MaxHeap(k, arr);
        maxHeap.displayHeap();

        System.out.println(maxHeap.add(100));
        maxHeap.displayHeap();
    }
}
