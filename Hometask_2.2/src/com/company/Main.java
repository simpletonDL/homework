package com.company;

public class Main {
    public static void main(String[] args) {
        List list = new DoubleLinkedList();
        testList(list);
    }

    public static void testList(List list) {
        list.insert(0, "2");
        list.showInConsole(); // 2
        list.insert(1, "1");
        list.showInConsole(); // 2 1
        list.insert(1, "3");
        list.showInConsole(); // 2 3 1
        list.insert(3, "4");
        list.showInConsole(); // 2 3 1 4
        list.insert(5, "2"); // Out of the range
        list.showInConsole(); // 2 3 1 4

        System.out.println(list.getSize()); // 4

        System.out.println(list.getIndexOfElement("3")); // 1
        System.out.println(list.getIndexOfElement("7")); // -1

        System.out.println(list.retrieve(0)); // 2
        System.out.println(list.retrieve(4)); // Out of the range

        list.delete(1);
        list.showInConsole(); // 2 1 4
        list.delete(0);
        list.showInConsole(); // 1 4
        list.delete(1);
        list.showInConsole(); // 1
        list.delete(0);
        list.showInConsole(); //
        list.delete(0); // List is empty //*/

        System.out.println("*************");
    }
}
