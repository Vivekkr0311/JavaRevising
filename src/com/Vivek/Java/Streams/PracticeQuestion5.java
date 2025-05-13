package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.List;

public class PracticeQuestion5 {

    public static void main(String[] args) {
        // Find the intersection of two lists using Java streams:
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> result = list1
                .stream()
                .filter(x-> list2.contains(x))
                .toList();

        List<Integer> result2 = list1
                .stream()
                .filter(list2::contains)
                .toList();

        System.out.println(result);
        System.out.println(result2);
    }
}
