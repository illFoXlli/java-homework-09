package com.fox.homework09.collections;

public class MyQueue {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return head.value;
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }

        Object value = head.value;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
