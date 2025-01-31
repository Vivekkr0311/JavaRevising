package com.Vivek.Java.Generics;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        GenericsPractice<Integer, Integer> integerData = new GenericsPractice<>(10, 20);
        GenericsPractice<String, String> stringData = new GenericsPractice<>("Vivek", "kumar");
        GenericsPractice<Integer, String> keyV = new GenericsPractice<>(10, "ABC");
        GenericsPractice<String, Integer> keyVT = new GenericsPractice<>("ABC", 10);

        System.out.println(integerData.key + " " + integerData.value);
        System.out.println(stringData.key + " " + stringData.value);
        System.out.println(keyV.key + " " + keyV.value);
        System.out.println(keyVT.key +  " " + keyVT.value);
    }
}