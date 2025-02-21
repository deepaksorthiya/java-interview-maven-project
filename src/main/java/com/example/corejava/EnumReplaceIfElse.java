package com.example.corejava;

/**
 * <a href="https://medium.com/@jakemer10/replacing-if-else-statements-with-enums-in-java-a-cleaner-approach-a16ba4eead40">Enum In Java</a>
 */
public class EnumReplaceIfElse {

    public enum CustomerType {
        REGULAR {
            @Override
            public double calculateDiscount(double basePrice) {
                return basePrice;
            }
        },
        MEMBER {
            @Override
            public double calculateDiscount(double basePrice) {
                return basePrice * 0.9;
            }
        },
        VIP {
            @Override
            public double calculateDiscount(double basePrice) {
                return basePrice * 0.8;
            }
        };

        public abstract double calculateDiscount(double basePrice);
    }

    public static void main(String[] args) {
        System.out.println(calculatePrice(CustomerType.REGULAR, 10));
        System.out.println(calculatePrice(CustomerType.MEMBER, 10));
        System.out.println(calculatePrice(CustomerType.VIP, 10));
    }

    public static double calculatePrice(CustomerType customerType, double basePrice) {
        return customerType.calculateDiscount(basePrice);
    }

//    public double calculatePrice(CustomerType customerType, double basePrice) {
//        if (customerType == CustomerType.REGULAR) {
//            return basePrice;
//        } else if (customerType == CustomerType.MEMBER) {
//            return basePrice * 0.9;
//        } else if (customerType == CustomerType.VIP) {
//            return basePrice * 0.8;
//        } else {
//            throw new IllegalArgumentException("Unknown customer type");
//        }
//    }
}
