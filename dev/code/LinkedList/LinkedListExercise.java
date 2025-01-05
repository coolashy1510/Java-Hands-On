package com.io.Java11.dev.code.LinkedList;

import java.util.LinkedList;

public class LinkedListExercise {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Chennai");
        linkedList.add("Delhi");
        linkedList.add("Mumbai");
        linkedList.add("Kolkata");
        System.out.println(linkedList);
        addElements(linkedList);
        System.out.println(linkedList);
    }

    private static void addElements(LinkedList<String> linkedList) {
        linkedList.add("Pune");
        linkedList.add("Kanpur");

        linkedList.addFirst("Visakhapatnam"); // adds element to the first index
        linkedList.addLast("Ahmedabad"); // adds element to the last index

        // Queue methods
        linkedList.offer("Surat"); // adds to the last
        linkedList.offerFirst("Rajkot"); // adds to the first
        linkedList.offerLast("Vadodara"); // adds to the last

        //Stack Methods
        linkedList.push("Hyderabad"); // adds element to the first index

    }
}
