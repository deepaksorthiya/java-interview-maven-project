package com.example.corejava;

import java.util.Arrays;
import java.util.List;

public class EnumExample {
    public static void main(String[] args) {
        Arrays.stream(A.values()).forEach(a -> System.out.println(a.getStr()));
    }

    private enum A {

        A("StringA"), B("StringB"), C("StringC");
        private final String str;

        A(String str) {
            this.str = str;
        }

        String getStr() {
            return this.str;
        }
    }

}
