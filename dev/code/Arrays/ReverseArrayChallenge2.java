package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;

public class ReverseArrayChallenge2 {
    public static void main(String[] args) {
        int[] array = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println("Final : " + Arrays.toString(array));
    }



    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for ( int i = 0; i < halfLength ; i++) {
            int temp = array[i];
            array[i] = array[maxIndex- i];
            array[maxIndex - i] = temp;
            System.out.println(" ---- > "+Arrays.toString(array));
        }
    }
}
