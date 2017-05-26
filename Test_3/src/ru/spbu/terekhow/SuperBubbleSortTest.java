package ru.spbu.terekhow;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Test class.
 */
public class SuperBubbleSortTest {
    /**
     * Create two arrays with size SIZE and fill the random integers
     * mo maxInt. Then first array sorted by SuperBubbleSort and second
     * by Collections.sort. Then they compared.
     */
    @Test
    public void sort() {
        final int SIZE = 1000;
        final int maxInt = 100000;
        Random rand = new Random();

        Integer currentArray[] = new Integer[SIZE];
        ArrayList<Integer> expectedArray = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            int value = rand.nextInt() % maxInt;
            currentArray[i] = value;
            expectedArray.add(value);
        }

        SuperBubbleSort<Integer> sorter = new SuperBubbleSort<>();
        sorter.sort(currentArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Collections.sort(expectedArray);

        ArrayList<Integer> actualArray = new ArrayList<>(Arrays.asList(currentArray));
        assertEquals(expectedArray, actualArray);
    }

}