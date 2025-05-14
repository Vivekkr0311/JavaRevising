package com.Vivek.Java.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeQuestion9 {

    public static void main(String[] args) {
//        Given a list of strings, find the frequency of each word using Java streams:

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");

        Map<String, Integer> map = words
                .stream()
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                Collectors.summingInt(c -> 1))
                );

        HashMap<String, Integer> map2 = words
                .stream()
                        .collect(
                                Collectors.groupingBy(
                                        c -> c,
                                        HashMap::new,
                                        Collectors.summingInt(c -> 1)
                                )
                        );

        Map<String, Long> map3 = words
                .stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting())
                );

        TreeMap<String, Integer> map4 = words
                .stream()
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                TreeMap::new,
                                Collectors.summingInt(c -> 1)
                        )
                );

        LinkedHashMap<String, Integer> map5 = words
                .stream()
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                LinkedHashMap::new,
                                Collectors.summingInt(c -> 1)
                        )
                );

        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map4);
        System.out.println(map5);
    }
}