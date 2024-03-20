package com.example.linkedlist;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("one");
        linkedList.add("two");

        linkedList.addFirst("000");

        linkedList.remove("one");

        System.out.println(linkedList);
    }
}
