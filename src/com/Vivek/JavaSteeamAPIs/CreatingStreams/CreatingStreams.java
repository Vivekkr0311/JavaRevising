package com.Vivek.JavaSteeamAPIs.CreatingStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
        // 1. Convert list into a stream
        List<String> list = Arrays.asList("Apple", "Banana", "Orange", "Grapes");
        Stream<String> myStream = list.stream();

        // 2. Convert an array into a stream
        String[] list2 = {"Apple", "Banana", "Orange", "Grapes"};
        Stream<String> stream = Arrays.stream(list2);

        // 3. Create stream directly giving the values
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);

        // 4. Create steam using lamba expression
        // takes 0 first, then computes next element using n -> n + 1 upto 100
        // eg, 0,     1,     2,     3,     4   ...    100
        //     |      |      |      |      |           |
        //    seed  0 + 1  1 + 1  2 + 1  3 + 1 ...  99 + 1
        Stream<Integer> stream3 = Stream.iterate(0, n -> n + 1).limit(100);

        // 5. Create stream using generate
        Stream<Integer> stream4 = Stream.generate(() -> (int) Math.random()).limit(5);
    }
}
