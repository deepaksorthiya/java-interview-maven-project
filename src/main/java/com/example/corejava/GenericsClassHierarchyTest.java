package com.example.corejava;

import java.util.ArrayList;
import java.util.List;

public class GenericsClassHierarchyTest {

    public static void main(String[] args) {
        List<EvenNumber> le = new ArrayList<>();
        List<? extends EvenNumber> ln = le;
        //ln.add(new NaturalNumber(35));  // compile-time error
        //ln.add(new EvenNumber(35)); // compile-time error

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
