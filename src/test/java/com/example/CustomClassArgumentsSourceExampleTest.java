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

class CustomClassArgumentsSourceExampleTest {

    @ParameterizedTest
    @ArgumentsSource(PersonArgumentsGenerator.class)
    void comparePersonId(Person person, int id) {
        assertEquals(person.id, id);
    }

    private static class PersonArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(@NonNull ParameterDeclarations parameters, ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new Person(1, "John", "Doe"), 1),
                    Arguments.of(new Person(2, "Alice", "Alice"), 2),
                    Arguments.of(new Person(3, "Bob", "Bob"), 3)
            );
        }
    }

    private record Person(int id, String firstName, String lastName) {

    }
}