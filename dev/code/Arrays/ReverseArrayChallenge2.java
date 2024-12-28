package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;

public class ReverseArrayChallenge2 {
    public static void main(String[] args) {
        int[] array = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println("Final : " + Arrays.toString(array));
    }



    /**
     * Reverses an array of integers in place.
     * @param array The array to reverse
     */
    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        // Loop through the array and swap elements at the beginning and end
        for ( int i = 0; i < halfLength ; i++) {
            // Swap elements
            int temp = array[i];
            array[i] = array[maxIndex- i];
            array[maxIndex - i] = temp;
            // Print the array at each step
            System.out.println(" ---- > "+Arrays.toString(array));
        }
    }
}
