package com.company;

public class Main {

    public static void main(String[] args)
    {
        List list = new List();
        list.insert(0, 2);
        list.show(); // 2
        list.insert(1, 1);
        list.show(); // 2 1
        list.insert(1, 3);
        list.show(); // 2 3 1
        list.insert(3, 4);
        list.show(); // 2 3 1 4
        list.insert(5, 2); // Out of the range
        list.show(); // 2 3 1 4

        System.out.println(list.getSize()); // 4

        System.out.println(list.locale(3)); // 1
        System.out.println(list.locale(7)); // -1

        System.out.println(list.retrieve(0)); // 2
        System.out.println(list.retrieve(4)); // -1

        list.delete(1);
        list.show(); // 2 1 4
        list.delete(0);
        list.show(); // 1 4
        list.delete(1);
        list.show(); // 1
        list.delete(0);
        list.show(); //
        list.delete(0); // List is empty
    }
}