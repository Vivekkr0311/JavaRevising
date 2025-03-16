package com.Vivek.LLD.Design_HashSet;

public class MyHashSet {
    private static final int SIZE = 1_000_001;
    private static boolean[] set;

    public MyHashSet() {
        set = new boolean[SIZE];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
