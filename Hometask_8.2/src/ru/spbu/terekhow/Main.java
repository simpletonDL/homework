package ru.spbu.terekhow;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(0);
        MergeSortMultiThread a = new MergeSortMultiThread();
        a.sort(arr, 3);
        System.out.println(arr);
    }
}
