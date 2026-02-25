package com.fox.homework09.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void testPushAndSize() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        assertEquals(2, stack.size());
    }

    @Test
    void testPeek() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.peek());
        assertEquals(2, stack.size()); // peek не удаляет
    }

    @Test
    void testPop() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void testClear() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.clear();

        assertEquals(0, stack.size());
        assertNull(stack.peek());
    }

    @Test
    void testRemoveByIndex() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.remove(1); // удаляем B

        assertEquals(2, stack.size());
        assertEquals("C", stack.pop());
        assertEquals("A", stack.pop());
    }
}
