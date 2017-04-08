package ru.spbu.terekhow.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.spbu.terekhow.PriorityQueueByPointers;
import ru.spbu.terekhow.exceptions.EmptyQueue;

public class testQueue {
    @Test
    public void testEnqueue() throws Exception {
        PriorityQueueByPointers<Integer> q = new PriorityQueueByPointers<>();
        q.enqueue(5, 5);
        q.enqueue(1, 1);
        q.enqueue(2, 2);
        q.enqueue(3, 3);
        q.enqueue(10, 10);
        q.enqueue(7, 7);
        q.enqueue(6, 6);
        q.enqueue(4, 4);
        q.enqueue(8, 8);
        q.enqueue(9, 9);
        for (int i = 10; i >= 1; i--) {
            assertEquals(i, (int) q.dequeue());
        }
    }

    @Test (expected = EmptyQueue.class)
    public void testDequeue() throws Exception {
        PriorityQueueByPointers<Integer> q = new PriorityQueueByPointers<>();
        q.enqueue(10, 3);
        q.enqueue(11, 2);
        q.enqueue(12, 1);
        try {
            q.dequeue();
            q.dequeue();
            q.dequeue();
        } catch (EmptyQueue e) {
            throw new Exception();
        }
        q.dequeue();
    }
}
