package com.io.Java11.dev.code.JourneyPlanner;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<String> stations;
    private int duration;

    public Route() {
        this.stations = new ArrayList<>();
        this.duration = 0;
    }

    public Route(Route route) {
        this.stations = new ArrayList<>(route.stations);
        this.duration = route.duration;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
