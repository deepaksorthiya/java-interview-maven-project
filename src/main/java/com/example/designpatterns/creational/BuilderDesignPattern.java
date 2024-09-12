package com.example.designpatterns.creational;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder(6, Pizza.BreadType.THICK_CRUST)
                .withCheese(true)
                .withOlive(true)
                .build();
        System.out.println(pizza);
    }

    private static class Pizza {
        private int size;
        private BreadType breadType;

        private boolean cheese;
        private boolean olive;
        private boolean pepper;

        public Pizza(PizzaBuilder pizzaBuilder) {
            this.size = pizzaBuilder.size;
            this.breadType = pizzaBuilder.breadType;

            this.cheese = pizzaBuilder.cheese;
            this.olive = pizzaBuilder.olive;
            this.pepper = pizzaBuilder.pepper;
        }

        public static class PizzaBuilder {
            //Mandatory Parameters
            private int size;
            private BreadType breadType;

            //Optional Parameters
            private boolean cheese;
            private boolean olive;
            private boolean pepper;

            public PizzaBuilder(int size, BreadType breadType) {
                this.size = size;
                this.breadType = breadType;
            }

            public PizzaBuilder withCheese(boolean cheese) {
                this.cheese = cheese;
                return this;
            }

            public PizzaBuilder withOlive(boolean olive) {
                this.olive = olive;
                return this;
            }

            public PizzaBuilder withPepper(boolean pepper) {
                this.pepper = pepper;
                return this;
            }

            public Pizza build() {
                return new Pizza(this);
            }
        }

        public enum BreadType {
            THIN_CRUST,
            THICK_CRUST,
            FLAT_BREAD;
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "size=" + size +
                    ", breadType=" + breadType +
                    ", cheese=" + cheese +
                    ", olive=" + olive +
                    ", pepper=" + pepper +
                    '}';
        }
    }
}
