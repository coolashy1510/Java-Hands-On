package com.io.Java11.dev.code.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExercise {
    public static void main(String[] args) {

        String[] items = {"apples", "oranges", "grapes"};

        List<String> newList = List.of(items);

        ArrayList arrayList = new ArrayList<>();
        arrayList.add(newList);
        System.out.println("Before modifying the list : "+ arrayList);

        ArrayList anotherNewlist = new ArrayList(List.of("mangoes", "banana"));
        arrayList.add(anotherNewlist);
        System.out.println(anotherNewlist);
        System.out.println("after modifying the list: "+ arrayList);

        arrayList.add("kiwi");
        System.out.println("after modifying the list with kiwi: "+ arrayList);
    }
}
