package ru.spbu.terekhow.tests;

import org.junit.Test;
import ru.spbu.terekhow.*;
import ru.spbu.terekhow.exceptions.*;
import static org.junit.Assert.*;

public class UniqueListTest {
    private List<Integer> list;

    @Test
    public void testListEquals() throws ListException {
        List<Integer> list1 = new UniqueList<>();
        List<Integer> list2 = new UniqueList<>();
        list1.pushBack(1);
        list1.pushBack(2);
        list1.pushBack(3);

        list2.pushFront(3);
        list2.pushFront(2);
        list2.pushFront(1);

        assertEquals(list1, list2);
    }

    @Test
    public void countOfException() throws ListException {
        list = new UniqueList<>();
        int exceptionCount = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    list.pushBack(j);
                } catch (UnnecessaryAction e) {
                    exceptionCount++;
                }
            }
        }
        assertEquals(900, exceptionCount);
    }

    @Test
    public void pushBack() throws ListException {
        list = new UniqueList<>();
        for (int i = 0; i < 1000; i++) {
            try {
                list.pushBack(i % 15);
            } catch (UnnecessaryAction e) {

            }
        }
        List<Integer> expectedList = new UniqueList<>();
        for (int i = 0; i < 15; i++) {
            expectedList.pushBack(i);
        }
        assertEquals(expectedList, list);
    }
}