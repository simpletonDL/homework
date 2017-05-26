package ru.spbu.terekhow;

import java.util.Comparator;

/**
 * Generic class to sort any arrays with the best sort in the world.
 * @param <Type>
 *     Type of element
 */
public class SuperBubbleSort<Type> {
    public void sort(Type array[], Comparator<Type> comparator) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (comparator.compare(array[j], array[j+1]) > 0) {
                    Type a = array[j];
                    array[j] = array[j+1];
                    array[j+1] = a;
                }
            }
        }
    }
}
