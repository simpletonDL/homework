package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class implements {@link com.company.Out} and write
 * result in file.
 */
public class OutInFile extends ArrayToHelix implements Out {
    private String path = "outFile.txt";

    /**
     * Empty constructor. Note, that in this case
     * file will be placed in the root directory.
     * The file name will be outFile.txt.
     */
    public OutInFile() {}

    /**
     * This constructor set path to the file.
     * @param path
     * Path to the output file. Note, that creation file by yourselves
     * is unnecessary, because it vill be done automatically.
     */
    public OutInFile(String path) {
        this.path = path;
    }

    /**
     * Out result in the file.
     * @param array
     * Input array.
     */
    @Override
    public void drawSpiralFromArray(int[][] array) {
        ArrayList<Integer> out = convert(array);
        try {
            FileWriter writer = new FileWriter(path);
            for (int i = 0; i < out.size(); i++) {
                writer.write(out.get(i) + " ");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Cant`t create file " + path);
        }
    }
}
