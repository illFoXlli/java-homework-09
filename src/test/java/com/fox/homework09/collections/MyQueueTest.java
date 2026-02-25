package com.fox.homework09.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void testAddAndPeek() {
        MyQueue queue = new MyQueue();
        queue.add("A");
        queue.add("B");

        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testPoll() {
        MyQueue queue = new MyQueue();
        queue.add("A");
        queue.add("B");

        assertEquals("A", queue.poll());
        assertEquals("B", queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void testPollFromEmpty() {
        MyQueue queue = new MyQueue();

        assertNull(queue.poll());
        assertNull(queue.peek());
        assertEquals(0, queue.size());
    }

    @Test
    void testClear() {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);

        queue.clear();

        assertEquals(0, queue.size());
        assertNull(queue.peek());
    }
}
