package com.example.corejava;

public class ClassLocalAndInstanceVariableTest {

    private static class Temp {
        private int x = 10;
        protected int y = 10;

        protected Temp() {
            this(5);
        }

        private Temp(int x) {
            this(x, 15);
            y = x;
        }

        protected Temp(int x, int y) {
            System.out.println("x * y: " + (x * y));
            System.out.println("this.x * this.y: " + (this.x * this.y));
        }
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
        System.out.println("x : " + temp.x);
        System.out.println("y : " + temp.y);

    }

}

/**
 * OUTPUT ::
 * x * y: 75
 * this.x * this.y: 100
 * x : 10
 * y : 5
 */
