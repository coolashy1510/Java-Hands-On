package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;
import java.util.Random;

public class DescendingSort {
    public static void main(String[] args) {
        int[] newArray = randomArray(5);
        System.out.println(Arrays.toString(newArray));

        int[] sortedArray = sortIntegers(newArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * Generates an array of random integers.
     * Each integer is between 0 (inclusive) and 1000 (exclusive).
     *
     * @param length the length of the array to generate
     * @return an array containing random integers
     */
    private static int[] randomArray(int length) {
        Random random = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }

    /**
     * Sorts an array of integers in descending order using bubble sort algorithm.
     * @param array the array of integers to sort
     * @return a new sorted array
     */
    private static int[] sortIntegers(int[] array) {
        // Create a copy of the original array
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        // Loop until the array is sorted
        while (flag) {
            flag = false;
            // Loop through each element in the array
            for (int i = 0; i < sortedArray.length - 1; i++) {
                // Check if the current element is smaller than the next one
                if (sortedArray[i] < sortedArray[i + 1]) {
                    // Swap the elements
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    // Set the flag to true to indicate that a swap has been made
                    flag = true;
                }
            }
        }

        // Return the sorted array
        return sortedArray;
    }
}
