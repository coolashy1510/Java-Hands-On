package com.io.Java11.dev.code.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name, int distance) {}

public class LinkedListChallenge {
    static boolean goingForward = true;
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        addPlace(placesToVisit, new Place("London", 50));
        addPlace(placesToVisit, new Place("Birmingham", 100));
        addPlace(placesToVisit, new Place("Manchester", 250));
        addPlace(placesToVisit, new Place("NewCastle", 300));
        placesToVisit.addFirst(new Place("Romford", 0));
        System.out.println(placesToVisit);


        callInteractiveConsole();
        callBusinessLogic(placesToVisit);
    }

    /**
     * Business logic of the program.
     * It loops through the list and based on user input, it either moves forward
     * or backwards in the list.
     * @param placesToVisit the list of places to visit
     */
    private static void callBusinessLogic(LinkedList<Place> placesToVisit) {
        var iterator = placesToVisit.listIterator();

        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;

        // loop through the list until the user wants to quit
        while (!quitLoop) {
            // if we are at the beginning of the list, go forward
            if (!iterator.hasPrevious()) {
                System.out.println("Originating : " + iterator.next());
                goingForward = true;
            }
            // if we are at the end of the list, go backwards
            if (!iterator.hasNext()) {
                System.out.println("Final : " + iterator.previous());
                goingForward = false;
            }
            System.out.println("enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);
            switch(menuItem) {
                case "F" -> moveForward(iterator);
                case "B" -> moveBackwards(iterator);
                case "L" -> System.out.println(placesToVisit);
                case "M" -> callInteractiveConsole();
                default -> quitLoop = true;
            }

        }
    }

    /**
     * Moves the iterator backwards in the list. If the current direction
     * was forward, it adjusts the position by moving one step back.
     * @param iterator the list iterator to move backwards
     */
    private static void moveBackwards(ListIterator<Place> iterator) {
        System.out.println("User wants to go backwards");

        // Check if the current direction is forward
        if (goingForward) {
            // Change direction to backwards
            goingForward = false;
            // Adjust position by moving one step back if possible
            if (iterator.hasPrevious()) {
                iterator.previous();
            }
        }

        // Move iterator backwards and print the previous element if possible
        if (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    /**
     * Moves the iterator forward in the list. If the current direction
     * was backward, it adjusts the position by moving one step forward.
     * @param iterator the list iterator to move forward
     */
    private static void moveForward(ListIterator<Place> iterator) {
        System.out.println("User wants to go forward");
        // Check if the current direction is backwards
        if (!goingForward) {
            // Change direction to forwards
            goingForward = true;
            // Adjust position by moving one step forward if possible
            if (iterator.hasNext()) {
                iterator.next();
            }
        }
        // Move iterator forward and print the next element if possible
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Adds a place to the list if it does not already exist.
     * It checks by comparing the name and distance of the places.
     * If a place with the same name is found, it does not add the place.
     * If a place with a shorter distance is found, it adds the place at that
     * position in the list.
     * @param list the list of places
     * @param place the place to be added
     */
    private static void addPlace(LinkedList<Place> list, Place place) {
        // Check if the place already exists in the list
        if(list.contains(place)) {
            System.out.println("Found duplicate: "+ place);
            return;
        }

        // Check if the place name already exists in the list
        for(Place p : list) {
            if(p.name().equalsIgnoreCase(place.name())) {
                System.out.println("Found duplicate: "+ place);
                return;
            }
        }

        // Add the place to the list in the correct order
        int matchedIndex = 0;
        for (var listPlace: list) {
            if(place.distance() < listPlace.distance()) {
                // If the new place has a shorter distance, add it at this position
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }
        // If the new place has the longest distance, add it at the end
        list.add(place);
    }

    /**
     * Prompts the user to select an action from the menu.
     */
    private static void callInteractiveConsole() {
        String textBlock = """
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""";
        System.out.println(textBlock);
    }
}
