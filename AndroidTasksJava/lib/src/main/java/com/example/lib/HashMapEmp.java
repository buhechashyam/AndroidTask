package com.example.lib;

import java.util.HashMap;
import java.util.LinkedList;

public class HashMapEmp {

    static void printHashMap(String operation, HashMap<Integer,String> hashMap) {

        System.out.println("\n" + operation);
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println(hashMap.get(i));
        }
    }

    public static void main(String[] args) {

        HashMap<Integer, String> hashMapOfNames = new HashMap<Integer, String>();

        hashMapOfNames.put(0,"Zero");
        hashMapOfNames.put(1,"One");
        hashMapOfNames.put(2,"Two");
        hashMapOfNames.put(3,"three");
        hashMapOfNames.put(4,"Four");

        System.out.println("KEYS : ");
        for (int i : hashMapOfNames.keySet()) {
            System.out.println(i);
        }

        System.out.println("\n VALUEs : ");
        for (String i : hashMapOfNames.values()) {
            System.out.println(i);
        }

        hashMapOfNames.remove(0);

        System.out.println(hashMapOfNames.get(3));
        System.out.println(hashMapOfNames.remove(2));



    }
}
