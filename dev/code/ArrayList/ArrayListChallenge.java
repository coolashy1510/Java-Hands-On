package com.io.Java11.dev.code.ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);


    /**
     * This is the main entry point for the program.
     * It initializes the application and starts the interactive loop.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList groceryList = new ArrayList();
        boolean flag = true;

        while(flag) {
            int input = callInteractiveConsole();
            switch(input) {
                // Add items to the list
                case 1 -> addItemsToList(groceryList);
                // Remove items from the list
                case 2 -> removeItemsFromList(groceryList);
                // Quit the application
                default -> flag = false;
            }

            // Sort the list
            groceryList.sort(Comparator.naturalOrder());

            // Print the list
            System.out.println(groceryList);
        }
    }

    /**
     * Add items to the grocery list.
     * This method prompts the user to enter the items to add to the list
     * separated by comma. It then splits the input string into individual
     * strings and adds them to the list if they don't already exist.
     * @param groceryList the list of items
     */
    private static void addItemsToList(ArrayList groceryList) {
        System.out.println("Please enter the items to Add to the list separated by comma");
        String items = scanner.nextLine();
        String[] itemsArray = items.split(",");

        for(String item : itemsArray) {
            String trimmedItem = item.trim();
            // Check if the item doesn't already exist in the list
            if (groceryList.indexOf(trimmedItem) < 0) {
                groceryList.add(trimmedItem);
            }
        }
    }

    /**
     * Remove items from the grocery list.
     * This method prompts the user to enter the items to remove from the list
     * separated by comma. It then splits the input string into individual
     * strings and removes them from the list if they exist.
     * @param groceryList the list of items
     */
    private static void removeItemsFromList(ArrayList groceryList) {
        System.out.println("Please enter the items to Remove from the list separated by comma");
        Scanner scanner = new Scanner(System.in);
        String[] itemsArray = scanner.nextLine().split(",");

        // Iterate over the items to remove and remove them from the list if they exist
        for (String item : itemsArray) {
            String trimmedItem = item.trim();
            // Check if the item exists in the list
            if (groceryList.indexOf(trimmedItem) >= 0) {
                groceryList.remove(trimmedItem);
            }
        }
    }

    /**
     * Displays the interactive console menu to the user and reads their input.
     * The user can choose actions such as shutdown, add items to the list, or
     * remove items from the list.
     *
     * @return an integer representing the user's chosen action
     */
    private static int callInteractiveConsole() {
        // Initialize a scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Define a text block to display available actions to the user
        String textBlock = """
                Available actions:
                
                0 - to shutdown
                
                1 - to add item(s) to list (comma delimited list)
                
                2 - to remove any items (comma delimited list)
                
                Enter a number for which action you want to do:""";

        // Print the text block to the console
        System.out.println(textBlock);
        System.out.println(" ");

        // Read and return the user's input as an integer
        return scanner.nextInt();
    }
}
