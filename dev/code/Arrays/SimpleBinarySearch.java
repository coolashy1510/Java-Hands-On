package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;

public class SimpleBinarySearch {
    public static void main(String[] args) {
        String[] name = {"bob", "bill", "buck", "bin"};
        Arrays.sort(name); // The array needs to be sorted for a binary search
        System.out.println(Arrays.toString(name));
        System.out.println(Arrays.binarySearch(name, "bin"));

        if(Arrays.binarySearch(name, "bin") >= 0) {
            System.out.println("Found bin in the array");
        }

    }
}
