package com.io.Java11.dev.code.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExercise {
    public static void main(String[] args) {

        String[] items = {"apples", "oranges", "grapes"};

        List<String> newList = List.of(items);

        ArrayList arrayList = new ArrayList<>(newList);
        System.out.println("Before modifying the list : "+ arrayList);

        ArrayList anotherNewlist = new ArrayList(List.of("mangoes", "banana"));
        //arrayList.add(anotherNewlist);
        arrayList.addAll(anotherNewlist);
        System.out.println(anotherNewlist);
        System.out.println("after modifying the list: "+ arrayList);

        arrayList.add("kiwi");
        System.out.println("after modifying the list with kiwi: "+ arrayList);
        System.out.println("Index of Kiwi: "+ arrayList.indexOf("kiwi"));
        System.out.println("Last Known Index of Mangoes: "+ arrayList.lastIndexOf("mangoes"));

        arrayList.remove("kiwi");
        System.out.println("after removing kiwi: "+ arrayList);
    }
}
