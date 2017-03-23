package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int a[][] = {{25, 10, 11, 12, 13},
                     {24,  9,  2,  3, 14},
                     {23,  8,  1,  4, 15},
                     {22,  7,  6,  5, 16},
                     {21, 20, 19, 18, 17}};
        drawSpiral(new OutInFile("src/com/outFiles/out.txt"), a);
        drawSpiral(new OutInConsole(), a);
    }

    private static void drawSpiral(Out out, int array[][]) {
        out.drawSpiralFromArray(array);
    }
}
