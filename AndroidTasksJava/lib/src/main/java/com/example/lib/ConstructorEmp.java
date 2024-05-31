package com.example.lib;

//constructor is used for creating a objects

class Fruits {
    String nameOfFruits;

    //default constructor
    public Fruits() {
        this.nameOfFruits = "Orange";
    }

    //parameterized constructor

    public Fruits(String name) {
        this.nameOfFruits = name;
    }


    public static void main(String[] args) {
        Fruits mango = new Fruits("Mango");

        System.out.println(mango.nameOfFruits);
    }
}