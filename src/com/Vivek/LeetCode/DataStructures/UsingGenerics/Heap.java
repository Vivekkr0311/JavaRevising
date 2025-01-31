package com.Vivek.LeetCode.DataStructures.UsingGenerics;
import java.util.ArrayList;
import java.util.Comparator;

public class Heap <T extends Comparator<T>> {
    private ArrayList <T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int getParentIdx(int idx){
        return ((idx - 1)/2);
    }

    private static int leftChildIdx(int idx){
        return idx * 2 + 1;
    }

    private static int rightChildIdx(int idx){
        return idx * 2 + 2;
    }

    public void insert(T value){
        list.add(value);
        heapify(list.size() - 1);
    }

    private void heapify(int idx){
        if(idx == 0){
            return;
        }

        int parent = getParentIdx(idx);
//        if(list.get(idx).compareTo(list.get(parent)) < 0){
//            swap(idx, parent);
//            heapify(parent);
//        }
    }

    private void downHeap(int idx){
        int min = idx;
        int left = leftChildIdx(idx);
        int right = rightChildIdx(idx);
//        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
//            min = left;
//        }
//
//        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
//            min = right;
//        }

        if(min != idx){
            swap(min, idx);
            downHeap(min);
        }
    }

    public void remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
    }
}
