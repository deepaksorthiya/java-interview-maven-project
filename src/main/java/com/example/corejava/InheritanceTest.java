package com.example.corejava;


public class InheritanceTest {
    public static void main(String[] args) {
        Rare rare = new Rare();
        // call most specific method rather than Object one
        String s = rare.callMethod(new Rare());
        System.out.println(s);
        System.out.println(rare instanceof Tiger);
        System.out.println(rare instanceof White);
    }

    private static class Tiger {
        public String callMethod(Tiger obj) {
            return "Tiger";
        }
    }

    private static class White extends Tiger {
        public String callMethod(White obj) {
            return "White";
        }
    }

    private static class Rare extends White {
        public String callMethod(Object obj) {
            return "Rare";
        }
    }
}
/**
 * OUTPUT
 * White
 * true
 * true
 */
