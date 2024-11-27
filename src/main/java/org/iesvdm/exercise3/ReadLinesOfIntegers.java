package org.iesvdm.exercise3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadLinesOfIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashSet<List<Integer>> linesSet = new HashSet<>();

        System.out.println("Enter lines of integers (press Enter on an empty line to stop):");

        while (true) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                break; // Stop reading when the user enters an empty line
            }

            // Convert the line into a List of integers
            List<Integer> integersList = Arrays.stream(input.trim().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            linesSet.add(integersList);
        }

        scanner.close();

        System.out.println("Contents of the set:");
        linesSet.forEach(line -> {
            System.out.print("Line: ");
            line.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });

    }
}
