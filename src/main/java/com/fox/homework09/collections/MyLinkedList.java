package com.fox.homework09.collections;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        Object value;
        Node prev;
        Node next;

        Node(Object value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value, last, null);

        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }
    public int size() {
        return size;
    }
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    public Object get(int index) {
        checkIndex(index);

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    public void remove(int index) {
        checkIndex(index);

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node prev = current.prev;
        Node next = current.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        size--;
    }

}