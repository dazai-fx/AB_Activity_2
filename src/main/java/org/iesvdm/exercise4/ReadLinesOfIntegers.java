package org.iesvdm.exercise4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadLinesOfIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashSet<List<Integer>> linesSet = new HashSet<>();

        System.out.println("Enter lines of numbers or text (press Enter on an empty line to stop):");

        while (true) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                break; // Stop reading when the user enters an empty line
            }

            // Convert the line into a List of integers, filtering out non-integer values
            List<Integer> integersList = Arrays.stream(input.trim().split(" "))
                    .filter(ReadLinesOfIntegers::isInteger) // Use a helper method to check if it's an integer
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (!integersList.isEmpty()) {
                linesSet.add(integersList);
            }
        }

        scanner.close();

        System.out.println("Contents of the set:");
        linesSet.forEach(line -> {
            System.out.print("Line: ");
            line.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });
    }

    // Helper method to check if a string represents an integer
    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
