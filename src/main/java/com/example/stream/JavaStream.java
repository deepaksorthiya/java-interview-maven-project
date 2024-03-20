package com.example.stream;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class JavaStream {

    public static void main(String[] args) {
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        for (int i = 0; i < visits.length; i++) {

        }
        return null;
    }

    private static class UserStats {
        private Optional<Long> visitCount;

        public Optional<Long> getVisitCount() {
            return visitCount;
        }
    }

}