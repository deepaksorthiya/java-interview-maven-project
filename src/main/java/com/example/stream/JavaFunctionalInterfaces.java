package com.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
    }
}
