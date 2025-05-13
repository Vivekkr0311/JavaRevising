package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PracticeQuestion1 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "apple", "banana", "cherry", "date", "grapefruit"
        );

        // finding longest string in the list using java streams

        Optional<String> result = strings
                .stream()
                .max(
                        Comparator.comparingInt(String::length)
                );

        Optional<String> result2 = strings
                .stream()
                .reduce((s1, s2) ->
                            s1.length() >=  s2.length() ? s1 : s2
                        );

        System.out.println(result.get());
        System.out.println(result2.get());
    }
}
