package com.example.corejava;

public class ExceptionOrderTest {

    public static void main(String[] args) {
        try {
            int arr[] = {5, 10, 15, 20, 25, 30};
            System.out.println(arr[6]);

        } catch (Exception e) {
            System.out.println("Exception 1");

        }
        //Compile Time Error - ArrayIndexOutOfBoundsException already caught
        /*  (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception 2");
        }*/
    }
}
