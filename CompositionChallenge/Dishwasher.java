package com.io.Java11.CompositionChallenge;

public class Dishwasher {
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes () {
        if(hasWorkToDo) {
            System.out.println("Doing dishes...");
            hasWorkToDo = false;
        }
    }
}
