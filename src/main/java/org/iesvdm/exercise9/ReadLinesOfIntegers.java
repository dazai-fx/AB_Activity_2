package org.iesvdm.exercise9;

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

        // TreeSet with ordering by the length of lists, breaking ties by sum
        TreeSet<List<Integer>> treeSetByLength = new TreeSet<>(
                (list1, list2) -> {
                    int lengthComparison = Integer.compare(list1.size(), list2.size());
                    if (lengthComparison != 0) {
                        return lengthComparison;
                    }
                    return Integer.compare(
                            list1.stream().mapToInt(Integer::intValue).sum(),
                            list2.stream().mapToInt(Integer::intValue).sum()
                    );
                }
        );
        treeSetByLength.addAll(hashSet);

        // TreeSet with ordering by the sum of integers, breaking ties by length
        TreeSet<List<Integer>> treeSetBySum = new TreeSet<>(
                (list1, list2) -> {
                    int sumComparison = Integer.compare(
                            list1.stream().mapToInt(Integer::intValue).sum(),
                            list2.stream().mapToInt(Integer::intValue).sum()
                    );
                    if (sumComparison != 0) {
                        return sumComparison;
                    }
                    return Integer.compare(list1.size(), list2.size());
                }
        );
        treeSetBySum.addAll(hashSet);

        // Print the TreeSet ordered by length
        System.out.println("TreeSet ordered by length of lists (ties broken by sum):");
        treeSetByLength.forEach(list -> {
            System.out.println(list + " (Length: " + list.size() + ", Sum: " + list.stream().mapToInt(Integer::intValue).sum() + ")");
        });

        // Print the TreeSet ordered by sum
        System.out.println("TreeSet ordered by sum of integers (ties broken by length):");
        treeSetBySum.forEach(list -> {
            System.out.println(list + " (Sum: " + list.stream().mapToInt(Integer::intValue).sum() + ", Length: " + list.size() + ")");
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

    // Method to find the longest List in a HashSet using reduce
    private static List<Integer> longestList(HashSet<List<Integer>> hashSet) {
        return hashSet.stream()
                .reduce(new ArrayList<>(), (longest, current) ->
                        current.size() > longest.size() ? current : longest);
    }

}
