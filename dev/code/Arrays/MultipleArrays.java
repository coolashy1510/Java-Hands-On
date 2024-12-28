package com.io.Java11.dev.code.Arrays;

import java.util.Arrays;

public class MultipleArrays {
    public static void main(String[] args) {
        int[][] array2 = new int[4][4];

        for (int[] outer : array2) {
            System.out.println("Outer" + Arrays.toString(outer));
        }

        for (int i=0; i< array2.length; i++) {
            var innerArray = array2[i];
            for(int j=0; j<innerArray.length; j++) {
                //System.out.println("Individual Elements: " + array2[i][j]+ " ");
                array2[i][j] = i+j;
            }
        }

        /*for (var outer: array2) {
            for(var element: outer) {
                System.out.print(element+ " ");
            }
            System.out.println();
        }*/

        //System.out.println(Arrays.deepToString(array2));

    }
}
