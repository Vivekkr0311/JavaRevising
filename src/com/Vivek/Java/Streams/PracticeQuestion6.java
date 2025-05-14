package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.List;

public class PracticeQuestion6 {

    public static void main(String[] args) {
//      Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);

        List<Integer> unique = numbersWithDuplicates
                .stream()
                .distinct()
                .toList();
        System.out.println(unique);
    }
}
