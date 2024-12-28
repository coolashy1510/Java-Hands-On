package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomArrayGenerator {
    public static void main(String[] args) {
        int[] array = getRandomArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println(array[2]);
        System.out.println("first element "+ array[0]);
        System.out.println("last element "+ array[array.length-1]);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i=0; i < len; i++) {
            newInt[i] = random.nextInt(100); // 0-99
        }
        return newInt;
    }
}
