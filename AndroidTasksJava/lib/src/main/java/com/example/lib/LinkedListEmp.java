package com.example.lib;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListEmp {

    static void printLinkedList(String operation, LinkedList<Integer> linkedList) {

        System.out.println("\n" + operation);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<Integer>();

        numbers.add(0);
        numbers.add(1);
        numbers.add(2);

        numbers.add(1,3);
        printLinkedList("Add",numbers);

        numbers.addFirst(22);
        printLinkedList("Add First",numbers);

        numbers.addLast(23);
        printLinkedList("Add Last",numbers);

        numbers.removeFirst();
        printLinkedList("Remove First",numbers);

        numbers.removeLast();
        printLinkedList("Remove Last",numbers);

    }
}
