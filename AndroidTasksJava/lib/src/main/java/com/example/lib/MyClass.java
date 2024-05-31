package com.example.lib;

public class MyClass {

    String myName = "Shyam";

    int firstNum = 1;

    final int secondNum = 1;

    public static void main(String[] args) {

        //create class object
        MyClass obj = new MyClass();

        //access class property using class object
        System.out.println("My name is " + obj.myName);


        // --> Objects

        //mutable variable - value change
        obj.firstNum = 2;
        System.out.println(obj.firstNum);

        //immutable variable - not value change
        // obj.secondNum = 2;
        System.out.println(obj.secondNum);

        //Create multiple objects

        MyClass firstObj = new MyClass();
        MyClass secondObj = new MyClass();


    }
}