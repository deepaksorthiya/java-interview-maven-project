package com.example.corejava;

import java.math.BigInteger;

public class BigIntegerImmutability {

    public static void main(String[] args) {

        BigInteger bigInteger = BigInteger.TEN;
        System.out.println(bigInteger);
        change(bigInteger);
        System.out.println(bigInteger);
    }

    public static void change(BigInteger integer) {
        integer.add(BigInteger.ONE);
    }

}
