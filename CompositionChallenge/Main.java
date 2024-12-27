package com.io.Java11.CompositionChallenge;

public class Main {
    public static void main(String[] args) {
        SmartKitchen kitchen = new SmartKitchen();

        /*
        kitchen.getDishWasher().setHasWorkToDo(true);
        kitchen.getBrewMaster().setHasWorkToDo(true);
        kitchen.getIceBox().setHasWorkToDo(true);

        kitchen.getBrewMaster().brewCoffee();
        kitchen.getIceBox().orderFood();
        kitchen.getDishWasher().doDishes();
        */

        kitchen.setKitchenState(true, true, false);
        kitchen.doKitchenWork();
    }
}
