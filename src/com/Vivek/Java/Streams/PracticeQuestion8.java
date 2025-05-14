package com.Vivek.Java.Streams;

import java.util.Arrays;

public class PracticeQuestion8 {

    public static void main(String[] args) {
//      Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 4;

        int result = Arrays
                .stream(array)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);

        System.out.println(result);
    }
}
