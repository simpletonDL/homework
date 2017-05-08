package ru.spbu.terekhow;

import java.util.*;

/**
 * This class implements Set. <b>Notice</b>, that asymptotic complexity of
 * almost all methods is O(n), but isn`t O(n*logn) like TreeSet.
 * @param <Type>
 * Type of stored elements.
 */
public class SetArray<Type> implements Set<Type> {
    private ArrayList<Type> array = new ArrayList<Type>();

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public boolean contains(Object o) {
        return (array.indexOf(o) != -1);
    }

    @Override
    public Iterator<Type> iterator() {
        return array.iterator();
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return array.toArray(a);
    }

    @Override
    public boolean add(Type type) {
        if (!contains(type)) {
            array.add(type);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            array.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return array.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Type> c) {
        Iterator<? extends Type> it = c.iterator();
        boolean hasChanged = false;

        while(it.hasNext()) {
            if (add(it.next())) {
                hasChanged = true;
            }
        }
        return hasChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return array.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return array.removeAll(c);
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
