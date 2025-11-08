package com.example.arraylist;

import java.util.ArrayList;

/**
 * @see ArrayList capacity will grow like this -> default 10, 10 + 10/2 = 15. 15+15/2 = 22
 */
public class ArrayListGrowCapacityTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10); //default 10

        list.add(12); // now 15
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17); // 22

        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);
        list.add(22);
        list.add(23); // 33
        list.add(24);

        int index = 9;
        Integer object = 9;

        list.remove(object); // remove given object
        list.remove(index); // remove element at index

        System.out.println(list);
    }
}
