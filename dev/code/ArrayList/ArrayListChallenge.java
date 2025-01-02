package com.io.Java11.dev.code.ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int input = callInteractiveConsole();
        ArrayList groceryList = new ArrayList();
        boolean flag = true;

        while(flag) {
            switch(input) {
                case 0 -> System.out.println("Shutting down");
                case 1 -> addItemsToList(groceryList);
                case 2 -> removeItemsFromList(groceryList);
                default -> flag = false;
            }
        }

    }

    private static void addItemsToList(ArrayList groceryList) {
        System.out.println("Please enter the items to Add to the list separated by comma");

        String items = scanner.nextLine();
        String[] itemsArray = items.split(",");

        groceryList.addAll(List.of(itemsArray));
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Grocery List: " + groceryList);
    }

    private static void removeItemsFromList(ArrayList groceryList) {
        System.out.println("Please enter the items to Remove from the list separated by comma");
        Scanner scanner = new Scanner(System.in);
        String[] itemsArray = scanner.nextLine().split(",");

        groceryList.removeAll(List.of(itemsArray));
        System.out.println("Grocery List: " + groceryList);
    }

    private static int callInteractiveConsole() {
        Scanner scanner = new Scanner(System.in);
        String textBlock = """
                Available actions:
                
                0 - to shutdown
                
                1 - to add item(s) to list (comma delimited list)
                
                2 - to remove any items (comma delimited list)
                
                Enter a number for which action you want to do:""";
        System.out.println(textBlock);
        System.out.println(" ");

        return scanner.nextInt();
    }
}
