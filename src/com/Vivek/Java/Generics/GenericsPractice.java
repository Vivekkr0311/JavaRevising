package com.Vivek.Java.Generics;

public class GenericsPractice <K, V>{

    K key;
    V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public GenericsPractice(K a, V b){
        this.key = a;
        this.value = b;
    }
}
