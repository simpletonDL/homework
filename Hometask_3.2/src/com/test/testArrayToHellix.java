package com.test;

import static org.junit.Assert.*;

import com.company.ArrayToHelix;
import org.junit.Test;

import java.util.ArrayList;

public class testArrayToHellix {
    @Test
    public void test1() {
        int a[][] = {{25, 10, 11, 12, 13},
                     {24,  9,  2,  3, 14},
                     {23,  8,  1,  4, 15},
                     {22,  7,  6,  5, 16},
                     {21, 20, 19, 18, 17}};
        ArrayList<Integer> actual = ArrayToHelix.convert(a);
        ArrayList<Integer> expected = correctAnswer(a);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int a[][] = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                a[i][j] = i * 101 + j;
            }
        }
        ArrayList<Integer> actual = ArrayToHelix.convert(a);
        ArrayList<Integer> expected = correctAnswer(a);
        assertEquals(expected, actual);
    }

    private ArrayList<Integer> correctAnswer(int array[][]) {
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
        return result;
    }

    private boolean outOfRange(int i, int j, int n) {
        return !((0 <= i && i < n) && (0 <= j && j < n));
    }
}
