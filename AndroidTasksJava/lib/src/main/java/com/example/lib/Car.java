package com.example.lib;

public class Car {

    /*
      Methods - Public and static
       1. public - access using objects
       2. static - access without objects
     */

    static void carName(String carName){
        System.out.println(carName);
    }

    public String fullNameOfCar(String name, String model) {
        return name + " " + model;
    }

    //
    public static void main(String[] args) {
       carName("BMW");


       Car audi = new Car();
       System.out.println("Name Of Car : " + audi.fullNameOfCar("Audi", "Model S1") );
    }
}
