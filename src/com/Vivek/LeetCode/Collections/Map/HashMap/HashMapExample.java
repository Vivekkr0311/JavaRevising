package com.Vivek.LeetCode.Collections.Map.HashMap;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("vivek", 1);
        map.put("abc", 2);
        map.put("xyz", 3);

        System.out.println(map);

        for(HashMap.Entry<String, Integer> item : map.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }

        if(map.containsKey("vivek")){
            System.out.println("value with key 'vivek' is present.");
        }
        System.out.println(map.size());
        map.remove("vivek");
        System.out.println(map.size());

        System.out.println(map.get("xyz"));
    }
}
