package com.example.corejava;

public class CloneExample implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample cloneExample1 = new CloneExample();
        Object clone = cloneExample1.clone();

        System.out.println(cloneExample1);
        System.out.println(clone);

    }
}
