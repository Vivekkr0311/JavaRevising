package com.Vivek.JavaSteeamAPIs.Operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Its returning streams
        Stream<Integer> stream = list.stream().filter(x -> (x & 1) == 0);
        System.out.println(stream);

        // If we want to collect it in a list
        List<Integer> filteredList = list.stream().filter(x -> (x&1) == 0).collect(Collectors.toList());
        System.out.println(filteredList);

        // If we want to convert each element now and put it into the list
        List<Integer> stream3 = filteredList.stream().map(x -> x/2).collect(Collectors.toList());
        System.out.println(stream3);

        List<Integer> duplicatesValues = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 6);
        System.out.println("Duplicates: "+duplicatesValues);
        List<Integer> filteredListWithoutDuplicates = duplicatesValues.stream().distinct().collect(Collectors.toList());
        System.out.println("Without duplicates: " + filteredListWithoutDuplicates);

        // We can sort the elements
        List<Integer> distinctAndSorted = duplicatesValues.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Distinct and Sorted: " + distinctAndSorted);

        List<Integer> distinctAndSortedDesc = duplicatesValues
                .stream()
                .distinct()
                .sorted((a, b) -> b -a)
                .collect(Collectors.toList());

        System.out.println("Distinct and Sorted (Desc): " + distinctAndSortedDesc);

        List<Integer> distinctAndSortedDescOnlyTwoElements = duplicatesValues
                .stream()
                .distinct()
                .sorted((a, b) -> b -a)
                .limit(2) // from starting to limit
                .collect(Collectors.toList());

        System.out.println("Distinct and Sorted (Desc) only two elements: " + distinctAndSortedDescOnlyTwoElements);

        List<Integer> distinctAndSortedDescOnlySkipElements = duplicatesValues
                .stream()
                .distinct()
                .sorted((a, b) -> b -a)
                .limit(4) // from starting to limit
                .skip(2) // from starting how many element you want to skip
                .collect(Collectors.toList());

        System.out.println("Distinct and Sorted (Desc) skip elements: " + distinctAndSortedDescOnlySkipElements);
    }
}
