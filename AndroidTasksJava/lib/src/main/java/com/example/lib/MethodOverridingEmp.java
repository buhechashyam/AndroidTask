package com.example.lib;


class Vehicle {
     void drive() {
        System.out.println("I'm drive a vehicle");
    }
}

class Bike extends Vehicle {
     void drive() {
        System.out.println("I'm drive a bike");
    }
}

public class MethodOverridingEmp {

    public static void main(String[] args) {

        Vehicle vc = new Vehicle();
        vc.drive();

        Bike bike = new Bike();
        bike.drive();

        Vehicle obj = new Bike();
        obj.drive();
    }
}
