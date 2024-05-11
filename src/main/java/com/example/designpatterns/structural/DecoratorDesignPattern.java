package com.example.designpatterns.structural;

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        VanillaCake vanillaStrawberryCake = new VanillaCake(new StrawberryCake(new BasicCake()));
        vanillaStrawberryCake.flavour();
        System.out.println(vanillaStrawberryCake.getAmount());
    }

    private interface Cake {
        void flavour();
        int getAmount();
    }

    private static class BasicCake implements Cake {
        @Override
        public void flavour() {
            System.out.println("Basic Cake");
        }

        @Override
        public int getAmount() {
            return 50;
        }
    }

    private static abstract class CakeDecorator implements Cake {
        private Cake cake;

        public CakeDecorator(Cake cake) {
            this.cake = cake;
        }

        @Override
        public void flavour() {
            cake.flavour();
        }

        @Override
        public int getAmount() {
            return cake.getAmount();
        }
    }

    private static class VanillaCake extends CakeDecorator {

        public VanillaCake(Cake cake) {
            super(cake);
        }

        @Override
        public void flavour() {
            super.flavour();
            System.out.println("Adding Vanilla flavour");
        }

        @Override
        public int getAmount() {
            return super.getAmount() + 10;
        }
    }

    private static class StrawberryCake extends CakeDecorator {

        public StrawberryCake(Cake cake) {
            super(cake);
        }

        @Override
        public void flavour() {
            super.flavour();
            System.out.println("Adding Strawberry flavour");
        }

        @Override
        public int getAmount() {
            return super.getAmount() + 10;
        }
    }
}
