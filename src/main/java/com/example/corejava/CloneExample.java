package com.example.corejava;

import java.util.Objects;

public class CloneExample implements Cloneable {

    public String name = "ABC";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample original = new CloneExample();
        Object clone = original.clone();
        System.out.println("############# Before ############");
        System.out.println("Original : " + original);
        System.out.println("Clone : " + clone);
        System.out.println("#########################");
        System.out.println("############# After ############");
        original.name = "TEST";
        System.out.println("Original : " + original);
        System.out.println("Clone : " + clone);
        System.out.println("#########################");

    }

    @Override
    public String toString() {
        return "CloneExample{" +
                "name='" + name + '\'' +
                '}' + " HashCode : " + Objects.hashCode(this);
    }
}
/**
 * OUTPUT
 * ############# Before ############
 * Original : CloneExample{name='ABC'} HashCode : 363771819
 * Clone : CloneExample{name='ABC'} HashCode : 664223387
 * #########################
 * ############# After ############
 * Original : CloneExample{name='TEST'} HashCode : 363771819
 * Clone : CloneExample{name='ABC'} HashCode : 664223387
 * #########################
 */
