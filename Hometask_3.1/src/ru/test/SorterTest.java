package ru.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.com.Sort;
import ru.com.bubbleSort;
import ru.com.mergeSort;

import static org.junit.Assert.*;

public class SorterTest {
    private Sort sorter;
    private int countOfTest;
    private int lengthArray;
    private int range;

    @Before
    public void init() {
        sorter = new mergeSort(); // Вот тут менять сортировки и выбирать параметры
        countOfTest = 10;
        lengthArray = 1000;
        range = 1000000000;
    }

    @Test
    public void sort() {
        int array[];
        for (int i = 0; i < countOfTest; i++) {
            array = new int[lengthArray];
            setRandomArray(array, range);
            sorter.sort(array);
            assertEquals(true,inRiseOrder(array));
        }
    }

    @Test
    public void maxCase() {
        int array[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = 999-i;
        }
        int expected[] = new int[1000];
        for (int i = 0; i < 1000; i++) {
            expected[i] = i;
        }
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void minCase() {
        int array[] = {0};
        int expected[] = {0};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    private boolean inRiseOrder(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    private void setRandomArray(int array[], int range) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (range+1));
        }
    }
}