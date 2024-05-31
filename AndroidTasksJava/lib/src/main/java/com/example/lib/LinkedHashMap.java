package com.example.lib;

import java.util.Map;

public class LinkedHashMap {


    public static void main(String[] args) {

        java.util.LinkedHashMap<Integer, String> students = new java.util.LinkedHashMap<>();
        //Capacity
        java.util.LinkedHashMap<Integer, String> linkedHashMap1 = new java.util.LinkedHashMap<>(3);

        //capacity with loadFactor. Load Factor define when students is full that time increase capacity automatically by 0.75
        java.util.LinkedHashMap<Integer, String> linkedHashMap2 = new java.util.LinkedHashMap<>(5, 0.75f);

        //with order
        java.util.LinkedHashMap<Integer, String> linkedHashMap3 = new java.util.LinkedHashMap<>(5, 0.75f, true);


        students.put(1, "RAJ");
        students.put(2, "JAY");
        students.put(3, "RAM");
        students.put(4, "TEJ");

        System.out.println(students);

        System.out.println("Size : " + students.size());

        System.out.println("Key Set : " + students.keySet());

        System.out.println("Value Set : " + students.values());

        System.out.println("Value \"RAM\" is Contain or Not(T/F) : " + students.containsValue("RAM"));

        System.out.println("Get a Value which key have 1 : " + students.get(1));

        System.out.println(students.entrySet());

        for (int i : students.keySet()
        ) {
            System.out.println(students.get(i));
        }
    }
}
