package com.io.Java11.dev.code.CompositionChallenge;

public class SmartKitchen {
private CoffeeMaker brewMaster;
private Dishwasher dishWasher;
private Refrigerator iceBox;

public SmartKitchen() {
    brewMaster = new CoffeeMaker();
    iceBox = new Refrigerator();
    dishWasher = new Dishwasher();
}

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public Dishwasher getDishWasher() {
        return dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public void doKitchenWork() {
    brewMaster.brewCoffee();
    dishWasher.doDishes();
    iceBox.orderFood();
}

    public void setKitchenState(boolean coffeeFlag, boolean dishFlag, boolean iceFlag) {
    brewMaster.setHasWorkToDo(coffeeFlag);
    dishWasher.setHasWorkToDo(dishFlag);
    iceBox.setHasWorkToDo(iceFlag);
    }
}


