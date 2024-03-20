package com.example.corejava;

import java.util.Random;

public class RandomNumExample {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // generate random number from (0,9) + 1
            System.out.println(random.nextInt(10) + 1);
        }
    }
}
