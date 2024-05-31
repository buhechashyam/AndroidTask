package com.example.lib;


public class MethodOverloadingExm {

    /*
    Method overloading : method name are same and in same class, but parameters are different, or return type may or may not difference
     */
    static int sum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    static int sum(int firstNum, int secondNum, int thirdNum) {
        return firstNum + secondNum + thirdNum;
    }

    static float sum(float firstNum, float secondNum, float thirdNum) {
        return firstNum + secondNum + thirdNum;
    }

    public static void main(String[] args) {
        System.out.println("Sum of two numbers : " + sum(10, 30));
        System.out.println("Sum of three numbers : " + sum(10, 30, 40));
        System.out.println("Sum of three Float numbers : " + sum(54.44f, 30.54f, 1.43f));
    }
}
