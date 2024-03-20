package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamRuntimeExceptionHandling02 {

    public static void main(String[] args) {


        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(consumerWrapper(i -> System.out.println(50 / i), ArithmeticException.class));

    }

    private static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {

        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println("Exception occurred : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }
}
