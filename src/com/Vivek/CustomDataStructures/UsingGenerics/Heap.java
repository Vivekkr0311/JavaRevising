package com.Vivek.CustomDataStructures.UsingGenerics;
import java.util.ArrayList;
import java.util.Comparator;

public class Heap <T extends Comparator<T>> {
    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
}
