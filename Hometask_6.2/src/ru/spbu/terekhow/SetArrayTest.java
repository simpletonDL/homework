package ru.spbu.terekhow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class SetArrayTest {
    private Set<String> set = new SetArray<>();;

    @Test
    public void add() {
        set.clear();
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 30; j++)
                set.add(Integer.toString(j));

        String actual[] = set.toArray(new String[set.size()]);
        String expected[] = new String[30];
        for (int i = 0; i < 30; i++) {
            expected[i] = Integer.toString(i);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void contains() {
        set.clear();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("12");
        for (String a: set) {
            assertTrue(set.contains(a));
        }
    }

    @Test
    public void remove() {
        set.clear();
        set.add("1");
        set.add("2");
        set.add("2");
        assertEquals(2, set.size());
        set.remove("2");
        assertEquals(1, set.size());
        set.remove("1");
        assertEquals(0, set.size());
        assertEquals(false, set.remove("1"));
    }

    @Test
    public void containsAll() {
        set.clear();
        for (int i = 0; i < 1000; i++) {
            set.add(Integer.toString(i));
        }

        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            a.add(Integer.toString(i));
            assertTrue(set.containsAll(a));
        }
    }

    @Test
    public void addAll() {
        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");

        set.clear();
        set.add("1");
        set.add("4");
        set.addAll(a);

        String actual[] = set.toArray(new String[set.size()]);
        Arrays.sort(actual);
        String expected[] = {"1", "2", "3", "4"};
        assertEquals(expected, actual);
    }

    @Test
    public void retainAll() throws Exception {
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");

        set.clear();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.retainAll(a);

        String actual[] = set.toArray(new String[set.size()]);
        String expected[] = {"a", "b", "c"};
        assertEquals(expected, actual);
    }

    @Test
    public void removeAll() throws Exception {
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("c");
        a.add("d");
        a.add("d");
        a.add("d");

        set.clear();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("f");
        set.removeAll(a);

        String actual[] = set.toArray(new String[set.size()]);
        String expected[] = {"e", "f"};
        assertEquals(expected, actual);
    }
}