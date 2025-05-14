package com.Vivek.Java.Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeQuestion7 {
    static class Transaction {
        private String date;
        private int amount;

        Transaction(String date, int amount) {
            this.date = date;
            this.amount = amount;
        }

        public String getDate() {
            return this.date;
        }

        public int getAmount() {
            return this.amount;
        }
    }

    public static void main(String[] args) {
//      Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> result = transactions
                .stream()
                .collect(
                        Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount))
                );

        System.out.println(result);

//        Count frequencies of character using stream

        String input = "aabbccddeeffgghhi";

        Map<Character, Integer> result2 = input
                .chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                Collectors.summingInt(c -> 1)
                        )
                );

        System.out.println(result2);

        HashMap<Character, Integer> result3 = input
                .chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                HashMap::new,
                                Collectors.summingInt(c -> 1))
                );
        System.out.println(result3);
    }
}
