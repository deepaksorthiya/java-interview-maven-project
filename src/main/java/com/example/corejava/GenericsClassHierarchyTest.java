package com.example.corejava;

import java.util.ArrayList;
import java.util.List;

public class GenericsClassHierarchyTest {

    public static void main(String[] args) {
        List<? super Number> le = new ArrayList<>(); // same as List<Number> le = new ArrayList<>();
        // List<? extends Number> le = new ArrayList<>(); // ERROR
        le.add(Double.valueOf(1.7));
        le.add(Integer.valueOf(1));

        for (Object n : le) {
            System.out.println(n);
        }

        List<? super NaturalNumber> ln = new ArrayList<>();

        ln.add(new NaturalNumber(35));
        ln.add(new EvenNumber(35));

        List<Integer> li = new ArrayList<>();
        li.add(Integer.valueOf(11));
        List<? extends Number> list = li;
        //list.add(Integer.valueOf(10)); // compile-time error

    }

    private static class NaturalNumber {
        private int i;

        public NaturalNumber(int i) {
            this.i = i;
        }
    }

    private static class EvenNumber extends NaturalNumber {
        public EvenNumber(int i) {
            super(i);
        }
    }
}
