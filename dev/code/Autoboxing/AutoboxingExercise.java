package com.io.Java11.dev.code.Autoboxing;

public class AutoboxingExercise {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(10); // unnecessary boxing
        int unboxedInt = boxedInt.intValue(); // unnecessary unboxing

        Integer boxedInt2 = 10; // autoboxing
        int unboxedInt2 = boxedInt2; // autounboxing

        System.out.println(boxedInt);
        System.out.println(unboxedInt);
        System.out.println(boxedInt2);
        System.out.println(unboxedInt2);

        System.out.println(boxedInt2.getClass().getName());
    }
}
