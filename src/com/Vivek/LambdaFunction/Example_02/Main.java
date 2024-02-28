package com.Vivek.LambdaFunction.Example_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list.add(i  + 1);
        }

        Consumer<Integer> func = item -> System.out.println(item * 2);
        list.forEach(func);
    }
}
