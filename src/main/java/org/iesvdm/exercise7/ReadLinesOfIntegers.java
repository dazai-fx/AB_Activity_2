package org.iesvdm.exercise7;

import java.util.*;
import java.util.stream.Collectors;

public class ReadLinesOfIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Set<Integer>> linesList = new ArrayList<>();

        System.out.println("Enter lines of text (press Enter on an empty line to stop):");

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

            if (!integersSet.isEmpty()) {
                linesList.add(integersSet);
            }
        }

        scanner.close();

        System.out.println("Contents of the list:");
        linesList.forEach(line -> {
            System.out.print("Line: ");
            line.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });

        // Example usage of the longestList method
        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (Set<Integer> set : linesList) {
            hashSet.add(new ArrayList<>(set));
        }

        // Find the longest list using Collections.max and a Comparator
        List<Integer> longest = Collections.max(hashSet, (list1, list2) -> Integer.compare(list1.size(), list2.size()));
        System.out.println("Longest list: " + longest);

        // Find the list with the largest sum using Collections.max and a Comparator
        List<Integer> largestSum = Collections.max(hashSet, (list1, list2) -> Integer.compare(
                list1.stream().mapToInt(Integer::intValue).sum(),
                list2.stream().mapToInt(Integer::intValue).sum()
        ));
        System.out.println("List with largest sum: " + largestSum);

        // Using streams to find the longest list
        List<Integer> longestStream = hashSet.stream()
                .max(Comparator.comparingInt(List::size))
                .orElse(new ArrayList<>());
        System.out.println("Longest list (stream): " + longestStream);

        // Using streams to find the list with the largest sum
        List<Integer> largestSumStream = hashSet.stream()
                .max(Comparator.comparingInt(list -> list.stream().mapToInt(Integer::intValue).sum()))
                .orElse(new ArrayList<>());
        System.out.println("List with largest sum (stream): " + largestSumStream);
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

    // Method to find the longest List in a HashSet using reduce
    private static List<Integer> longestList(HashSet<List<Integer>> hashSet) {
        return hashSet.stream()
                .reduce(new ArrayList<>(), (longest, current) ->
                        current.size() > longest.size() ? current : longest);
    }

}
