package com.Vivek.Collections.Sets.TreeSet;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // By default, elements in TreeSet is stores in increasing order.
        // For string, it is lexicographical increasing order.
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("abc");
        treeSet.add("xyz");
        treeSet.add("efg");
        treeSet.add("abc");

        System.out.println(treeSet);

        TreeSet<Integer> intergerTreeSet = new TreeSet<>();
        intergerTreeSet.add(50);
        intergerTreeSet.add(5);
        intergerTreeSet.add(10);
        intergerTreeSet.add(60);
        intergerTreeSet.add(870);
        intergerTreeSet.add(0);
        intergerTreeSet.add(40);
        intergerTreeSet.add(98);

        // Functions which are present in treeSet but not in HashSet are:
        // floor(), ceiling(), lower(), higher()
        System.out.println(intergerTreeSet);
        System.out.println("Floor of 6: " + intergerTreeSet.floor(6)); // will print 5
        System.out.println("Ceiling of 7: " + intergerTreeSet.ceiling(7)); // will print 10
        System.out.println("Nearest value lower than 5: " + intergerTreeSet.lower(5));
        System.out.println("Nearest value higher than 5: " + intergerTreeSet.higher(5));

        // Since TreeSet uses Red-Black tree time complexities of these operations are:
        // O(log(n)) for:
        //             add()
        //             contains()
        //             remove()
        //             floor()
        //             ceiling()
        //             higher()
        //             lower()

        // O(1) for:
        //          size()
        //          isEmpty()
    }
}
