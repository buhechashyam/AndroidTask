package com.example.lib;

import java.util.ArrayList;
import java.util.Collections;

/*
   Array vs ArrayList
   Array - can not change
   ArrayList - we can add,remove,update and delete the value
 */
public class ArrayListEmp {

    static void printArraylist(String operation, ArrayList<String> arrayList) {

        System.out.println("\n" + operation);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + " " + arrayList.get(i));
        }
    }


    public static void main(String[] args) {
        //create an ArrayList
        ArrayList<String> names = new ArrayList<String>();
        //Add element into the arrayList
        names.add("Shyam");
        names.add("Sagar");
        names.add("Pratik");
        names.add("Darshan");
        names.add("RAM");
        names.add("R");
        names.add("Ajay");
        names.add("Axay");

        printArraylist("Add Operation", names);

        //Remove element into the arrayList
        names.remove(2);

        printArraylist("After Remove element", names);

        //Update element into the arrayList
        names.set(2, "Shubham");
        printArraylist("After Update element", names);

        //check if arraylist contain element or not
        boolean bool = names.contains("Sagar");
        System.out.println(bool);

        //print size of arrayList
        int sizeOfArrayList = names.size();
        System.out.println(sizeOfArrayList);

        names.add(6,"New");
        printArraylist("Add in at Last index", names);

        //Sort ArrayList
        Collections.sort(names);
        printArraylist("Sort Operation", names);

        // swaping
        Collections.swap(names,0,1);
        printArraylist("Swaping", names);

        //clear
        names.clear();
        printArraylist("Clear", names);

    }


}
