package com.fox.homework09.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void addAndGetWorks() {
        MyLinkedList list = new MyLinkedList();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void removeFromBeginning() {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(0);

        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void removeFromMiddle() {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);

        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void removeFromEnd() {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(2);

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void clearEmptiesList() {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");

        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void getFromEmptyThrows() {
        MyLinkedList list = new MyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void removeFromEmptyThrows() {
        MyLinkedList list = new MyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void getWithInvalidIndexThrows() {
        MyLinkedList list = new MyLinkedList();
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
}
