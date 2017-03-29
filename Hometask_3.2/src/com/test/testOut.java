package com.test;

import static org.junit.Assert.*;

import com.company.ArrayToHelix;
import com.company.OutInConsole;
import com.company.OutInFile;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class testOut {
    @Test
    public void testConsoleOut1() {
        int a[][] = {{25, 10, 11, 12, 13},
                     {24,  9,  2,  3, 14},
                     {23,  8,  1,  4, 15},
                     {22,  7,  6,  5, 16},
                     {21, 20, 19, 18, 17}};
        String actual = getConsoleOut(a);
        String expected = correctAnswer(a);
        assertEquals(expected, actual);
    }

    @Test
    public void testConsoleOut2() {
        int a[][] = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                a[i][j] = i * 101 + j;
            }
        }
        String actual = getConsoleOut(a);
        String expected = correctAnswer(a);
        assertEquals(expected, actual);
    }

    @Test
    public void testFileOut3() {
        int a[][] = {{25, 10, 11, 12, 13},
                     {24,  9,  2,  3, 14},
                     {23,  8,  1,  4, 15},
                     {22,  7,  6,  5, 16},
                     {21, 20, 19, 18, 17}};
        String actual = null;
        try {
            actual = getFileOut(a);
        } catch (IOException e) {
            fail();
        }
        String expected = correctAnswer(a);
        assertEquals(expected, actual);
    }

    @Test
    public void testFileOut4() {
        int a[][] = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                a[i][j] = i * 101 + j;
            }
        }
        String actual = null;
        try {
            actual = getFileOut(a);
        } catch (IOException e) {
            fail();
        }
        String expected = correctAnswer(a);
        assertEquals(expected, actual);
    }

    private String getConsoleOut(int[][] array) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream previous = System.out;

        System.setOut(printStream);

        OutInConsole canvas =  new OutInConsole();
        canvas.drawSpiralFromArray(array);

        System.setOut(previous);
        printStream.close();

        String out = byteArrayOutputStream.toString();
        return out;
    }

    private String getFileOut(int a[][]) throws IOException {
        File file = new File("output.txt");
        OutInFile out = new OutInFile(file.toPath().toString());
        out.drawSpiralFromArray(a);

        FileReader reader = new FileReader("output.txt");
        BufferedReader bufReader = new BufferedReader(reader);

        String s = bufReader.readLine();
        System.out.println(s);

        bufReader.close();
        file.delete();

        return s;
    }

    private String correctAnswer(int array[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = array.length;
        int color[][] = new int[n][n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n / 2 + 1; k++){
            while(!outOfRange(i + 1, j, n) && color[i + 1][j] == 0) {
                result.add(0, array[i][j]);
                color[i][j] = 1;
                i++;
            }
            while(!outOfRange(i, j + 1, n) && color[i][j + 1] == 0) {
                result.add(0, array[i][j]);
                color[i][j] = 1;
                j++;
            }
            while(!outOfRange(i - 1, j, n) && color[i - 1][j] == 0) {
                result.add(0, array[i][j]);
                color[i][j] = 1;
                i--;
            }
            while(!outOfRange(i, j - 1, n) && color[i][j - 1] == 0) {
                result.add(0, array[i][j]);
                color[i][j] = 1;
                j--;
            }
        }
        result.add(0, array[n / 2][n / 2]);
        return arrayListToString(result);
    }

    private boolean outOfRange(int i, int j, int n) {
        return !((0 <= i && i < n) && (0 <= j && j < n));
    }

    private String arrayListToString(ArrayList<Integer> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i) + " ";
        }
        return s;
    }
}
