package com.example.lib;

interface Animal {
    int name = 0;
    public void animalName();

    public void animalColor();

}

class Main1 implements Animal {

    @Override
    public void animalName() {
        System.out.println("Cow");
    }

    @Override
    public void animalColor() {
        System.out.println("White");

    }
}
