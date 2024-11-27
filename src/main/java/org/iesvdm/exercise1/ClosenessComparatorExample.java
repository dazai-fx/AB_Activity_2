package org.iesvdm.exercise1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ClosenessComparatorExample {

    public static void main(String[] args) {

        // Reference number for proximity
        int target = 25;
        // define the comparator using a lambda
        Comparator<Integer> closenessComparator = (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            return Integer.compare(diffA, diffB);
        };

        // Example 1: sort an arraylist
        List<Integer> numbers = Arrays.asList(30, 22, 40, 18, 25, 27);
        numbers.sort(closenessComparator);
        System.out.println("Arraylist sorted by proximity to: "+ target
            + ": " + numbers );

        // Example 2: Building a Treeset with the Comparator
        TreeSet<Integer> treeSet = new TreeSet<>(closenessComparator);
        treeSet.addAll(numbers);
        System.out.println("TreeSet sorted by proximity to: "+ target
                + ": " + treeSet );

        // Example 3:
        List<Integer> sortedStream = numbers.stream()
                .sorted(closenessComparator)
                .toList();
        System.out.println("Stream sorted by proximity to: "+ target
            + ": " + sortedStream );


    }

}
