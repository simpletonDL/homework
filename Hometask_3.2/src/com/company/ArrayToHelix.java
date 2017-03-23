package com.company;

import java.util.ArrayList;

public class ArrayToHelix {
    public static ArrayList<Integer> convert(int array[][]) {
        int n = array.length;
        int targetI = n / 2;
        int targetJ = n / 2;
        int count = 0;
        ArrayList<Integer> newArray = new ArrayList<Integer>();

        newArray.add(array[targetI][targetJ]);
        for (int i = 0; i < n / 2; i++) {
            count++;
            for (int j = 0; j < count; j++) {
                targetI--;
                newArray.add(array[targetI][targetJ]);
            }
            for (int j = 0; j < count; j++) {
                targetJ++;
                newArray.add(array[targetI][targetJ]);
            }
            count++;
            for (int j = 0; j < count; j++) {
                targetI++;
                newArray.add(array[targetI][targetJ]);
            }
            for (int j = 0; j < count; j++) {
                targetJ--;
                newArray.add(array[targetI][targetJ]);
            }
        }
        for (int j = 0; j < count; j++) {
            targetI--;
            newArray.add(array[targetI][targetJ]);
        }
        return newArray;
    }
}
