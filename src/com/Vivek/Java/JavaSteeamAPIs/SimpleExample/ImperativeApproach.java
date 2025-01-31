package com.Vivek.Java.JavaSteeamAPIs.SimpleExample;

import java.util.Arrays;

public class ImperativeApproach {
    public static void main(String[] args) {
        // We convert a collections into a stream, then we can apply functional and declarative approach to
        // operate on that stream. This is all about Java Steam APIs.
        // Declarative approach means, you just write code for what you want to do, not how you will do.

        // imperative approach
        int [] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if((arr[i] & 1) == 0){
                sum += arr[i];
            }
        }

        System.out.println(sum);

        // Declarative approach
        int[] arr2 = {1, 2, 3, 4, 5};
        int sum2 = Arrays.stream(arr2).filter(n -> (n & 1) == 0).sum();
        System.out.println(sum2);
    }
}
