package com.example.designpatterns.creational;

public class BuilderDesignPattern02 {

    public static void main(String[] args) {
        Customer customer = new CustomerBuilder()
                .firstName("Tony")
                .lastName("Stark")
                .primaryEmail("tonystark@abc.com")
                .primaryMobileNumber("1234567890")
                .build();

        System.out.println(customer);
    }

    private static class Customer {
        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final String primaryEmail;
        private final String secondaryEmail;
        private final String primaryMobileNumber;
        private final String secondaryMobileNumber;

        public Customer(CustomerBuilder customerBuilder) {
            this.firstName = customerBuilder.getFirstName();
            this.middleName = customerBuilder.getMiddleName();
            this.lastName = customerBuilder.getLastName();
            this.primaryEmail = customerBuilder.getPrimaryEmail();
            this.secondaryEmail = customerBuilder.getSecondaryEmail();
            this.primaryMobileNumber = customerBuilder.getPrimaryMobileNumber();
            this.secondaryMobileNumber = customerBuilder.getSecondaryMobileNumber();
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPrimaryEmail() {
            return primaryEmail;
        }

        public String getSecondaryEmail() {
            return secondaryEmail;
        }

        public String getPrimaryMobileNumber() {
            return primaryMobileNumber;
        }

        public String getSecondaryMobileNumber() {
            return secondaryMobileNumber;
        }

        @Override
        public String toString() {
            return "First Name: " + firstName + "\n" +
                    "Middle Name: " + middleName + "\n" +
                    "Last Name: " + lastName + "\n" +
                    "Primary Email: " + primaryEmail + "\n" +
                    "Secondary Email: " + secondaryEmail + "\n" +
                    "Primary Mobile Number: " + primaryMobileNumber + "\n" +
                    "Secondary Mobile Number: " + secondaryMobileNumber + "\n";
        }
    }

    private interface ICustomerBuilder {
        ICustomerBuilder firstName(String firstName);

        ICustomerBuilder lastName(String lastName);

        ICustomerBuilder middleName(String middleName);

        ICustomerBuilder primaryEmail(String primaryEmail);

        ICustomerBuilder secondaryEmail(String secondaryEmail);

        ICustomerBuilder primaryMobileNumber(String primaryMobileNumber);

        ICustomerBuilder secondaryMobileNumber(String secondaryMobileNumber);
    }

    private static class CustomerBuilder implements ICustomerBuilder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String primaryEmail;
        private String secondaryEmail;
        private String primaryMobileNumber;
        private String secondaryMobileNumber;

        @Override
        public CustomerBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public CustomerBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public CustomerBuilder middleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        @Override
        public CustomerBuilder primaryEmail(final String primaryEmail) {
            this.primaryEmail = primaryEmail;
            return this;
        }

        @Override
        public CustomerBuilder secondaryEmail(final String secondaryEmail) {
            this.secondaryEmail = secondaryEmail;
            return this;
        }

        @Override
        public CustomerBuilder primaryMobileNumber(final String primaryMobileNumber) {
            this.primaryMobileNumber = primaryMobileNumber;
            return this;
        }

        @Override
        public CustomerBuilder secondaryMobileNumber(final String secondaryMobileNumber) {
            this.secondaryMobileNumber = secondaryMobileNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPrimaryEmail() {
            return primaryEmail;
        }

        public String getSecondaryEmail() {
            return secondaryEmail;
        }

        public String getPrimaryMobileNumber() {
            return primaryMobileNumber;
        }

        public String getSecondaryMobileNumber() {
            return secondaryMobileNumber;
        }
    }


}
