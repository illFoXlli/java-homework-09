package com.fox.homework09.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void testAddAndGet() {
        MyArrayList list = new MyArrayList();
        list.add("Hello");
        list.add("World");

        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    void testSize() {
        MyArrayList list = new MyArrayList();
        list.add("A");
        list.add("B");

        assertEquals(2, list.size());
    }

    @Test
    void testRemove() {
        MyArrayList list = new MyArrayList();
        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);

        assertEquals("C", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testClear() {
        MyArrayList list = new MyArrayList();
        list.add("A");
        list.add("B");

        list.clear();

        assertEquals(0, list.size());
    }
}

