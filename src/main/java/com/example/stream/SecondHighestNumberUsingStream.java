package com.example.stream;

import java.util.*;

/**
 *
 */
public class SecondHighestNumberUsingStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 10, 5, null, 8); // Mixed data

        Integer result = findSecondHighest(numbers);
        System.out.println("Result: " + result);
    }

    public static Integer findSecondHighest(List<Integer> list) {
        return Optional.ofNullable(list)      // 1. Handle null list
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)        // 2. Handle null elements inside list
                .distinct()                      // 3. Handle duplicates
                .sorted(Comparator.reverseOrder())
                .skip(1)                         // 4. Move to second position
                .findFirst()                     // 5. Return Optional
                .orElse(null);                   // 6. Return null if < 2 unique elements
    }
}
