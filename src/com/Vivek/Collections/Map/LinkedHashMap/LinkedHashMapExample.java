package com.Vivek.Collections.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        // It maintains the order of insertion.

        map.put("abc", 1);
        map.put("efg", 4);
        map.put("xyz", 6);
        map.put("pqr", 10);

        System.out.println(map);

        for(Map.Entry<String, Integer> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
