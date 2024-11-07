package com.example.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsWildCardSuperAndExtendsTest {

    public static void main(String[] args) {

        List<? extends Number> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));

        List<Number> ln = new ArrayList<>();
        addNumbers(ln);
        System.out.println(ln);

        List<Integer> lii = Arrays.asList(1, 2, 3);
        List<String> lss = Arrays.asList("one", "two", "three");
        printList(lii);
        printList(lss);
    }

    //upper bound is Number, Only allowed to perform Integer, Long, Float, Double
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    // lower bound is Integer, Only allowed to perform Integer, Number, Object
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
