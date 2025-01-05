package com.io.Java11.dev.code.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExercise {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Chennai");
        linkedList.add("Delhi");
        linkedList.add("Mumbai");
        linkedList.add("Kolkata");
        System.out.println(linkedList);

        addElements(linkedList);
        System.out.println("Added Elements: " + linkedList);

     //   removeElements(linkedList);
      //  System.out.println("Removed Elements: " + linkedList);

        //gettingElements(linkedList);

        //printItinerary(linkedList);
        //printItinerary2(linkedList);
        printItinerary3(linkedList);
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

    private static void removeElements(LinkedList<String> linkedList) {

        linkedList.remove("Kolkata"); // removes the element

        String s1 = linkedList.remove(); // removes the first element
        System.out.println(s1 + " removed from the list");
        String s2 = linkedList.removeFirst(); // removes the first element
        System.out.println(s2 + " removed from the list");
        String s3 = linkedList.removeLast(); // removes the last element
        System.out.println(s3 + " removed from the list");
        String s4 = linkedList.remove(5); // removes the element at index 5
        System.out.println(s4 + " removed from the list");

        System.out.println(linkedList);

        // Queue methods
        String s5 = linkedList.poll(); // removes the first element
        System.out.println(s5 + " removed from the list");

        String s6 = linkedList.pollFirst(); // removes the first element
        System.out.println(s6 + " removed from the list");

        String s7 = linkedList.pollLast(); // removes the last element
        System.out.println(s7 + " removed from the list");

        linkedList.push("Pondicherry");
        linkedList.push("Goa");
        System.out.println(linkedList);

        // Stack methods
        String s8 = linkedList.pop(); // removes the first element
        System.out.println(s8 + " removed from the list");

        boolean b = linkedList.removeFirstOccurrence("Mumbai"); // removes the first occurrence
        System.out.println(b);
    }

    private static void gettingElements(LinkedList<String> linkedList) {
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        System.out.println(linkedList.indexOf("Pune"));

        System.out.println(linkedList.lastIndexOf("Pondicherry"));

        System.out.println(linkedList.peek());
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
    }

    public static void printItinerary(LinkedList<String> linkedList) {
        System.out.println("Trip stats at " + linkedList.getFirst());

        for (int i =1; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i-1)+ " -> " + linkedList.get(i));
        }
        System.out.println("Trip ends at " + linkedList.getLast());
    }

    public static void printItinerary2(LinkedList<String> linkedList) {
        System.out.println("Trip stats at " + linkedList.getFirst());

        String previousTown = linkedList.getFirst();
        for (String town : linkedList) {
            System.out.println(previousTown + " -> " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + linkedList.getLast());
    }

    public static void printItinerary3(LinkedList<String> linkedList) {
        System.out.println("Trip stats at " + linkedList.getFirst());

        String previousTown = linkedList.getFirst();

        ListIterator<String> iterator = linkedList.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println(previousTown + " -> " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + linkedList.getLast());
    }
}