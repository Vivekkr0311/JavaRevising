package com.Vivek.Collections.Sets.SetInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConvertingToSet {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i + 1);
        }
        for(int i = 5; i < 10; i++){
            list.add(i + 1);
        }

        System.out.println("<< ArrayList >> \n" + list);

        Set<Integer> set = new HashSet<>(list);
        System.out.println("<< Now it's a set >> \n" + set);
    }
}
