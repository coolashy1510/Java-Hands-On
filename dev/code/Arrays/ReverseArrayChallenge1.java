package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;

public class ReverseArrayChallenge1 {
    public static void main(String[] args) {
        int[] array = {11, 22, 13, 54, 35};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        boolean flag = true;
        int temp;
        while(flag) {
            flag=false;
            for(int i=0; i < array.length-1; i++) {
                if (array[i] < array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true;
                }
            }
        }

    }
}
