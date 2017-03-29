package com.company;

import java.util.ArrayList;

public class OutInConsole extends ArrayToHelix implements Out {
    @Override
    public void drawSpiralFromArray(int[][] array) {
        ArrayList<Integer> out = convert(array);
        for (int i = 0; i < out.size(); i++) {
            System.out.print(out.get(i) + " ");
        }
    }
}
