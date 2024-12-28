package com.io.Java11.dev.code.CompositionChallenge;

public class Refrigerator {

    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood() {
        if(hasWorkToDo) {
            System.out.println("Ordering food...");
            hasWorkToDo = false;
        }
    }
}
