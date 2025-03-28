package com.example.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListIteratorTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");

        System.out.println(list);

        //forward direction
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            System.out.print(next + " ");
        }
        System.out.println();

        // reverse direction
        ListIterator<String> revIterator = list.listIterator(list.size());
        while (revIterator.hasPrevious()) {
            String prev = revIterator.previous();
            System.out.print(prev + " ");
        }
        System.out.println();

        // remove
        ListIterator<String> remIterator = list.listIterator();
        while (remIterator.hasNext()) {
            String next = remIterator.next();
            if ("one".equals(next)) {
                remIterator.remove();
            }
        }
        System.out.println(list);

        // add
        ListIterator<String> addIterator = list.listIterator();
        while (addIterator.hasNext()) {
            String next = addIterator.next();
            if ("two".equals(next)) {
                addIterator.add("two");
            }
        }
        System.out.println(list);
    }
}
/**
 * OUTPUT ::
 * [one, two, two, three]
 * one two two three
 * three two two one
 * [two, two, three]
 * [two, two, two, two, three]
 */
