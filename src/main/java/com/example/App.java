package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    /**
     * Calculates the count of subscribers per month who were not active
     * in the immediately preceding month.
     */
    static Map<Integer, Long> returningSubscribersPerMonth(List<SubscriptionEvent> events) {
        // Step 1: Group unique users by month using a TreeMap to keep months sorted

        Map<Month, Set<Integer>> collect = events.stream().collect(Collectors.groupingBy(e -> e.date().getMonth(), Collectors.mapping(e->e.userId(), Collectors.toSet())));
        System.out.println(collect);

        Map<Integer, Set<Integer>> monthlyActivity = new TreeMap<>();

        for (SubscriptionEvent event : events) {
            int month = event.date().getMonthValue();
            monthlyActivity
                    .computeIfAbsent(month, k -> new HashSet<>())
                    .add(event.userId());
        }

        Map<Integer, Long> result = new LinkedHashMap<>();

        // Step 2: Iterate through months to calculate the difference
        for (Integer currentMonth : monthlyActivity.keySet()) {
            Set<Integer> currentUsers = monthlyActivity.get(currentMonth);

            // Fetch users from the previous month (returns empty set if no data exists)
            Set<Integer> previousUsers = monthlyActivity.getOrDefault(currentMonth - 1, Collections.emptySet());

            // Step 3: Count users present in current month but NOT in previous month
            long newOrReturningCount = currentUsers.stream()
                    .filter(userId -> !previousUsers.contains(userId))
                    .count();

            result.put(currentMonth, newOrReturningCount);
        }

        return result;
    }

    // --- Main Method for Verification ---
    public static void main(String[] args) {
        List<SubscriptionEvent> events = List.of(
                new SubscriptionEvent(101, LocalDate.of(2025, 1, 5)),
                new SubscriptionEvent(102, LocalDate.of(2025, 2, 15)),
                new SubscriptionEvent(101, LocalDate.of(2025, 3, 20)),
                new SubscriptionEvent(103, LocalDate.of(2025, 3, 10)),
                new SubscriptionEvent(104, LocalDate.of(2025, 4, 5))
        );

        Map<Integer, Long> result = returningSubscribersPerMonth(events);

        // Expected Output: {1=1, 2=1, 3=2, 4=1}
        System.out.println("Result: " + result);
    }

}

// Record definition based on your usage
record SubscriptionEvent(int userId, LocalDate date) {
}