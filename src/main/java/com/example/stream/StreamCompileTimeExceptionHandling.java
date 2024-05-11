package com.example.stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamCompileTimeExceptionHandling {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(handlingConsumerWrapper(
                i -> writeToFile(i), IOException.class));
    }

    static void writeToFile(Integer integer) throws IOException {
        // logic to write to file which throws IOException
        throw new IOException();
    }

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
            ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println(
                            "Exception occurred : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }

    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }
}
