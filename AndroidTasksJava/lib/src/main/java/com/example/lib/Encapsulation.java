package com.example.lib;

public class Encapsulation {
    private String name = "Shyam";

    public String getName() {
        return name;
    }

    public void setName(String newName) {

        this.name = newName;

    }
}

class Main {
    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();

        System.out.println(obj.getName());

        obj.setName("Shyam Buhecha");
        System.out.println(obj.getName());
    }
}