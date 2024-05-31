package com.example.lib;


//for class
class Person {


    public String name = "Shyam";
    private String phone = "95610464343";
    protected int age = 22;

    public String getName() {
        return phone;
    }
    public static void main(String[] args) {

        Person shyam = new Person();

        //public private and protected property access inside the class
        System.out.println("Person Name : " + shyam.name);
        System.out.println("Person Phone : " + shyam.phone);
        System.out.println("Person Age : " + shyam.age);
    }
}

class Engineer extends Person {


    public static void main(String[] args) {

        Engineer engineer = new Engineer();

        //public and protected property access by the child the class and not access private property of parent class
        System.out.println("Person Name : " + engineer.name);
        System.out.println("Person Age : " + engineer.age);
    }
}

class ShopKeeper {

    public static void main(String[] args) {

        Person shyam = new Person();

        //only public property access anywhere
        System.out.println("Person Name : " + shyam.name);
    }

}