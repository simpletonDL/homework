package ru.spbu.terekhow.test;

import org.junit.Test;
import ru.spbu.terekhow.BubbleSort.SuperBubbleSort;

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
    public void sortInteger() {
        final int SIZE = 1000;
        final int MAX_INT = 100000;
        Random rand = new Random();

        Integer currentArray[] = new Integer[SIZE];
        ArrayList<Integer> expectedArray = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            int value = rand.nextInt() % MAX_INT;
            currentArray[i] = value;
            expectedArray.add(value);
        }

        SuperBubbleSort.sort(currentArray, (a1, a2) -> (a1 - a2));
        Collections.sort(expectedArray);

        ArrayList<Integer> actualArray = new ArrayList<>(Arrays.asList(currentArray));
        assertEquals(expectedArray, actualArray);
    }

    /**
     * Test string sorting (magic sort by length)
     */
    @Test
    public void sortStrings() {
        String actualArray[] = {"yellow", "red", "blue", "green"};
        
        SuperBubbleSort.sort(actualArray, (o1, o2) ->  (o1.length() - o2.length()));

        String expectedArray[] = {"red", "blue", "green", "yellow"};

        ArrayList<String> actualList = new ArrayList<>(Arrays.asList(actualArray));
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList(expectedArray));

        assertEquals(expectedList, actualList);
    }
}