package com.Vivek.Collections.Map.MapExample;

import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        // Set interface stores keys, while Map interface is used stores key-value pairs.
        // It's an interface so, you have to override some methods.
        // Let's use class which already did, like TreeMap.
        // TreeMap: It is an implementation of self-balancing tree. Particularly Red-Black tree.
        // HashMap and LinkedHashMap, uses Hashing internally which allows us quickly insert, search and delete.
        // While TreeMap, take O(log(n)) for search, delete and insert, but it provides sorted data access.
        // And TreeMap also have methods like ceiling(), floor(), lower(), higher() which are not present in HashMap or LinkedHashMap.


        Map<Integer, String> map = new TreeMap<>();

        map.put(3, "Vivek Three");
        map.put(2, "Vivek Two");
        map.put(1, "ABC");
        map.put(1, "Vivek"); // It will replace the value associated with the give key 1.


        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());

    }
}
