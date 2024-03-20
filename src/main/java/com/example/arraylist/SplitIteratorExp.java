package com.example.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SplitIteratorExp {
    public static void main(String[] args) {
        {
            ArrayList<String> list = new ArrayList<>();

            list.add("one");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");
            list.add("two");

            List<Integer> lst = list.stream().flatMapToInt(s -> s.chars()).collect(ArrayList::new, (integers, value) -> integers.add(value), (integers, integers2) -> integers.addAll(integers2));
            System.out.println(lst);
            Spliterator<String> spliterator = list.spliterator();
            // Traverse and process elements using tryAdvance()
            spliterator.tryAdvance(System.out::println);
            spliterator.tryAdvance(System.out::println);
            spliterator.tryAdvance(System.out::println);
            spliterator.tryAdvance(System.out::println);
            spliterator.tryAdvance(System.out::println);

            list.remove("two");

            list.sort(null);


            System.out.println(list);
        }
    }
}


