package org.iesvdm.exercise2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {

        System.out.println("Enter some words (separated by spaces):");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Set<String> words = new TreeSet<String>();

        words.addAll(Arrays.asList(input.split(" ")));
        System.out.println("Words printed using a TreeSet: ");
        for (String word : words) {
            System.out.println(word);
        }

        /*
        Key difference:
        HashSet stores elements in no particular order.
        treeSet stores elements in sorted (natural) order.
        */

    }

}
