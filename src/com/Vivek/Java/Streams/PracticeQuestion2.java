package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PracticeQuestion2 {
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

//        Calculate the average age of a list of Person objects using Java streams:

        double result = persons
                .stream()
                .mapToInt((p) -> p.age)
                .average()
                .orElse(0);

        System.out.println(result);

    }
}
