package com.example.lib;

abstract class AbstractionEmp {

    //abstract method
    abstract void sum();

    // non abstract method

    public void printNum(int number) {
        System.out.println("Number  : " + number);
    }
}

class NumSum extends AbstractionEmp {

    @Override
    void sum() {
        System.out.println("Sum of two numbers : " + (1+2));
    }
}
class MainNumbers {
    public static void main(String[] args) {
        NumSum obj = new NumSum();
        obj.sum();
        obj.printNum(3);
    }
}
