package com.company;

import java.util.ArrayList;

/**
 * This class implements {@link com.company.Out} and show
 * result in console.
 */
public class OutInConsole extends ArrayToHelix implements Out {
    /**
     * Show result in console.
     * @param array
     * Input array.
     */
    @Override
    public void drawSpiralFromArray(int[][] array) {
        ArrayList<Integer> out = convert(array);
        for (int i = 0; i < out.size(); i++) {
            System.out.print(out.get(i) + " ");
        }
    }
}