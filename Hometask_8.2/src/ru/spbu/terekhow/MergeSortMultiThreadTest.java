package ru.spbu.terekhow;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class MergeSortMultiThreadTest {
    @Test
    public void sort() {
        final int SIZE = 100000;
        final int COUNTTHREADS = 100;

        ArrayList<Integer> expectedArray = new ArrayList<>();
        ArrayList<Integer> actualArray = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            int randValue = rand.nextInt();
            expectedArray.add(randValue);
            actualArray.add(randValue);
        }

        long timeCollectionsSort = System.currentTimeMillis();
        Collections.sort(expectedArray);
        timeCollectionsSort = System.currentTimeMillis() - timeCollectionsSort;

        MergeSortMultiThread sorter = new MergeSortMultiThread();

        long timeMergeSortMultiThread = System.currentTimeMillis();
        sorter.sort(actualArray, COUNTTHREADS);
        timeMergeSortMultiThread = System.currentTimeMillis() - timeMergeSortMultiThread;

        System.out.println("Collections sort time: " + timeCollectionsSort);
        System.out.println("Merge sort by multy thread time: " + timeMergeSortMultiThread);
        //System.out.println(expectedArray);
        //System.out.println(actualArray);

        assertEquals(expectedArray, actualArray);
    }

}