package org.iesvdm.exercise5;

import java.util.*;
import java.util.stream.Collectors;

public class ReadLinesOfIntegers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Set<Integer>> linesList = new ArrayList<>();

        System.out.println("Enter lines of numbers or text (press Enter on an empty line to stop):");

        while (true) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                break; // Stop reading when the user enters an empty line
            }

            // Convert the line into a Set of integers, filtering out non-integer values
            Set<Integer> integersSet = Arrays.stream(input.trim().split(" "))
                    .filter(ReadLinesOfIntegers::isInteger) // Use a helper method to check if it's an integer
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            // Add the set to the List
            if (!integersSet.isEmpty()) {
                linesList.add(integersSet);
            }
        }

        // Close the scanner
        scanner.close();

        // Print the contents of the List using forEach
        System.out.println("Contents of the list:");
        linesList.forEach(line -> {
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

        /*
        Current Program:
        Storage: Each line is stored as a Set<Integer>, and all lines are stored in a List<Set<Integer>>.

        Duplicates in a single line are removed due to the Set behavior.
        <Identical lines are preserved in the List as distinct entries.
         */

    }

}
