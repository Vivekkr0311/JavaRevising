package com.Vivek.LLD.HeapDesign_KthLargestElementInAStream_703;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap2 {
    private static int heapsize;

    public static void buildHeap(ArrayList<Integer> a) {
        int n = a.size();
        heapsize = a.size();
        for (int i = n/ 2 - 1; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    private static int extractMax(ArrayList<Integer> a) {
        if (heapsize < 1) {
            System.out.println("Heap underflow");
            return -1;
        }

        int max = a.get(0);
        a.add(0, a.get(heapsize - 1));
        a.remove(heapsize - 1);
        heapsize = heapsize - 1;
        maxHeapify(a, 0);
        return max;
    }

    private static void maxHeapify(ArrayList<Integer> a, int i) {
        int l = i * 2 + 1;
        int r = 2 * (i + 1);
        int largest;

        if (l < heapsize && a.get(l) > a.get(i)) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapsize && a.get(r) > a.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            int temp = a.get(largest);
            a.add(largest, a.get(i));
            a.add(i, temp);
            maxHeapify(a, largest);
        }
    }

    public static void main(String[] args) {
        Integer[] temp = {1, 14, 10, 8, 7, 9, 3, 2, 4, 6};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(temp));

        buildHeap(arr);
        System.out.println(arr);
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(extractMax(arr));
        System.out.println(arr);
    }
}
