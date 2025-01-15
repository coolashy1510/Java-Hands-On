package com.io.Java11.dev.code.JourneyPlanner;

public class Station {
    private String name;
    private String line;

    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }
}
