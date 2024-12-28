package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {

    /**
     * Read a line of input from the user and convert it into an integer array.
     * The input is expected to be comma-separated.
     * @return an array of integers
     */
    private static int[] readIntegers () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers separated by commas:");
        String input = scanner.nextLine();

        // Split the input string into an array of strings
        // using the comma as the delimiter
        String[] splits = input.split(",");

        // Convert the array of strings into an array of integers
        int[] values = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            // Trim the string to remove any leading or trailing whitespace
            // and then parse it into an integer
            values[i] = Integer.parseInt(splits[i].trim());
        }

        return values;
    }

    /**
     * Find the minimum value in an array of integers.
     * @param array the array of integers
     * @return the minimum value
     */
    public static int findMin(int[] array) {
        // Initialize the minimum value to the first element of the array
        int min = array[0];

        // Iterate over the array, comparing each element with the current
        // minimum, and updating the minimum if the element is smaller
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        // Return the minimum value
        return min;
    }

    /**
     * Entry point for the program.
     * Reads a list of integers from the user, finds the minimum and prints it to the console.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Read a list of comma-separated integers from the user
        int[] array = readIntegers();
        // Find the minimum value in the array
        int min = findMin(array);
        // Print the result to the console
        System.out.println("min = "+ min);
    }
}
