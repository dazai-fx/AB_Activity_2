package org.iesvdm.exercise2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        System.out.println("Enter some words (separated by spaces):");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Set<String> words = new HashSet<>();

        words.addAll(Arrays.asList(input.split(" ")));

        System.out.println("Words printed using a HashSet:");
        for (String word : words) {
            System.out.println(word);
        }

    }

}
