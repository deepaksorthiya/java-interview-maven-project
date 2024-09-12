package com.example.corejava;


public class GenericsPairClassTest {

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(1, "apple");
        boolean same = compare(p1, p2);
        System.out.println(same);
    }

    public static <K extends Number, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    private record Pair<K, V>(K getKey, V getValue) {

    }

}
