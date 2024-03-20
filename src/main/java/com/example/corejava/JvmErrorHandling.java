package com.example.corejava;

import java.util.ArrayList;
import java.util.List;

public class JvmErrorHandling {

    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>();
            while (true) {
                list.add(1);
            }
            //test();
        } catch (Error error) {
            System.out.println(error);
        }
    }

    public static void test(){
        test();
    }
}
