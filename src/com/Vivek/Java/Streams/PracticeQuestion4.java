package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeQuestion4 {

    public static void main(String[] args) {
//        Merge two sorted lists into a single sorted list using Java streams:

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> result = Stream
                .concat(list1.stream(), list2.stream())
                .sorted()
                .toList();

        System.out.println(result);

        List<Integer> sortedList = Stream
                .concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedList);

        List<Integer> result2 = Stream
                .concat(list1.stream(), list2.stream())
                .sorted((a, b) -> {
                    if (a > b) return 1;
                    else if (a < b) return -1;
                    else return 0;
                })
                .toList();

        System.out.println(result2);

//        Merge two lists, keep only odd numbers, multiply them by 2 if they’re greater than 5, and sort descending.

        List<Integer> result3 =
                Stream
                        .concat(list1.stream(), list2.stream())
                        .sorted((a, b) -> {
                            if (a > b) return -1;
                            else if (a < b) return 1;
                            else return 0;
                        })
                        .filter(n -> ((n & 1) != 0))
                        .map(n -> n * 2)
                        .toList();

        System.out.println(result3);

    }
}
