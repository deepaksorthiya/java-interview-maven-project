package com.example.designpatterns.creational;

import lombok.Builder;


public class CustomerBuilderLombokTest {


    @Builder
    public record Customer(String firstName, String middleName, String lastName, String primaryEmail,
                           String secondaryEmail, String primaryMobileNumber, String secondaryMobileNumber) {
    }

    public static void main(String[] args) {
        Customer customer1 = Customer
                .builder()
                .firstName("John")
                .middleName("Doe")
                .build();
        Customer customer2 = Customer
                .builder()
                .firstName("John")
                .middleName("Doe")
                .build();
        System.out.println(customer1.equals(customer2));
    }
}
