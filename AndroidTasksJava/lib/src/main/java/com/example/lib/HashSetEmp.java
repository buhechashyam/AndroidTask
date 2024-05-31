package com.example.lib;

import java.util.HashSet;

public class HashSetEmp {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);


        for (int i : hashSet) {
            System.out.println(i);
        }

        System.out.println("Size of HashSet : " + hashSet.size());
        System.out.println("Contains: " + hashSet.contains(2));




    }
}
