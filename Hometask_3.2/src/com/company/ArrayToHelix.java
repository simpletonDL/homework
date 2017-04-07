package com.company;

import java.util.ArrayList;

/**
 * Class to convert the two-dimensional array to ArrayList in the spirally order.
 */
public class ArrayToHelix {
    /**
     * Convert the two-dimensional array to ArrayList in the spirally order.
     */
    protected ArrayList<Integer> convert(int array[][]) {
        int n = array.length;
        int targetI = n / 2;
        int targetJ = n / 2;
        int count = 0;
        ArrayList<Integer> newArray = new ArrayList();

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