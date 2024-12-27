package com.io.Java11;

public class SwitchChallenge {
    public static void main(String[] args) {
       System.out.println(printDayOFWeek(6));
    }
    public static String printDayOFWeek (int day) {
        return switch (day) {
            case 0 -> "Monday";
            case 1 -> "Tuesday";
            case 2 -> "Wednesday";
            case 3 -> "Thursday";
            case 4 -> "Friday";
            case 5 -> "Saturday";
            case 6 -> "Sunday";
            default -> "Invalid Day";
        };
    }
}
