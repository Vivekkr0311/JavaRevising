package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeQuestion10 {

    public static void main(String[] args) {
//        Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> filteredList = numbers
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                n -> (n & 1) == 0
                        )
                );

        List<Integer> evens = filteredList.get(true);
        List<Integer> odds = filteredList.get(false);
        System.out.println(evens);
        System.out.println(odds);
    }
}