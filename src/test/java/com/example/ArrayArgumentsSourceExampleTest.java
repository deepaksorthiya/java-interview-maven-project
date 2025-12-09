package com.example;

import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.ParameterDeclarations;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayArgumentsSourceExampleTest {

    @ParameterizedTest
    @ArgumentsSource(ArrayArgumentsGenerator.class)
    void calculateSum(int[] input, int expectedSum) {
        int sum = 0;
        for (int num : input) {
            sum += num;
        }
        assertEquals(expectedSum, sum);
    }

    private static class ArrayArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(@NonNull ParameterDeclarations parameters, ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new int[]{1, 1, 1}, 3),
                    Arguments.of(new int[]{2, 2, 2}, 6),
                    Arguments.of(new int[]{3, 3, 3}, 9)
            );
        }
    }
}