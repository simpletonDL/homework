package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutInFile implements Out {
    private String path = "outFile.txt";

    public OutInFile() {}

    public OutInFile(String path) {
        this.path = path;
    }

    @Override
    public void drawSpiralFromArray(int[][] array) {
        ArrayList<Integer> out = ArrayToHelix.convert(array);
        try {
            FileWriter writer = new FileWriter(path);
            for (int i = 0; i < out.size(); i++) {
                writer.write(out.get(i) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
