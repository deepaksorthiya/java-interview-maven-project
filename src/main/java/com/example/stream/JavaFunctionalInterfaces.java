package com.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class JavaFunctionalInterfaces {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());

        List<String> list = new ArrayList<>();

        Consumer<String> consumer = list::add;
        consumer.accept("gfgdgdgdg");

        BiConsumer<List<String>, String> biConsumer = List::add;

        biConsumer.accept(list, "sdfsdfsd");

        BinaryOperator<Integer> binaryOperator = Integer::sum;

        binaryOperator.apply(1, 2);

        System.out.println(list);

        Consumer<String> testedConsumer = testConsumer(System.out::println);
        testedConsumer.accept("dssff");

        Function<String, Integer> function = (s) -> Integer.parseInt(s);
        Integer j = function.apply("1");
        System.out.println(j);
    }

    private static <T> Consumer<T> testConsumer(Consumer<T> consumer) {
        return t -> {
            consumer.accept(t);
        };
    }
}
