package ru.spbu.terekhow.tests;

import org.junit.Test;
import ru.spbu.terekhow.UniqueList;
import ru.spbu.terekhow.List;
import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.exceptions.UnnecessaryAction;

import static org.junit.Assert.*;

public class UniqueListTest {
    private List<Integer> list;

    @Test
    public void countOfException() {
        list = new UniqueList<>();
        int exceptionCount = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    list.pushBack(j);
                } catch (UnnecessaryAction e) {
                    exceptionCount++;
                } catch (ListException e) {
                    fail();
                }
            }
        }
        assertEquals(900, exceptionCount);
    }

    @Test
    public void pushBack() {
        list = new UniqueList<>();
        for (int i = 0; i < 1000; i++) {
            try {
                list.pushBack(i % 15);
            } catch (UnnecessaryAction e) {

            } catch (ListException e) {
                fail();
            }
        }

        List<Integer> expectedList = new UniqueList<>();
        for (int i = 0; i < 15; i++) {
            try {
                expectedList.pushBack(i);
            } catch (ListException e) {
                fail();
            }
        }

        assertTrue(isListsEquals(list, expectedList));
    }

    private <T> boolean isListsEquals(List<T> A, List<T> B) {
        if (A.getSize() != B.getSize()) {
            return false;
        }
        for (int i = 0; i < A.getSize(); i++) {
            try {
                if (A.getElementFromIndex(i) != B.getElementFromIndex(i)) {
                    return false;
                }
            } catch (ListException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}