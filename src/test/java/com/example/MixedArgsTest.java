package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MixedArgsTest {

    static Stream<Arguments> provideArrayAndSum() {
        return Stream.of(
                // Arguments.of(Array, ExpectedSum)
                Arguments.of(new int[]{1, 2}, 3),
                Arguments.of(new int[]{5, 5, 5}, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArrayAndSum")
    void calculateSum(int[] input, int expectedSum) {
        int sum = 0;
        for (int i : input) sum += i;
        assertEquals(expectedSum, sum);
    }
}