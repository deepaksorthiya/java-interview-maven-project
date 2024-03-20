package com.example.stream;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2, 3, 4);
        List<Integer> l2 = List.of(2, 3);
        List<Integer> l3 = List.of(2);

        List<List<Integer>> ll = List.of(l1, l2, l3);

        List<Integer> list = ll.stream().flatMap(Collection::stream).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);
    }
}
