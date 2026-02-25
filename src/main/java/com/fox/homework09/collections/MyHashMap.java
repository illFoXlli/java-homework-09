package com.fox.homework09.collections;

public class MyHashMap {
    private Node head;
    private int size;

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Object key, Object value) {
        if (head == null) {
            head = new Node(key, value, null);
            size++;
            return;
        }

        Node current = head;
        while (true) {
            if (current.key.equals(key)) {
                current.value = value; // перезапись значения
                return;
            }
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        current.next = new Node(key, value, null);
        size++;
    }

    public Object get(Object key) {
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(Object key) {
        if (head == null) {
            return;
        }

        if (head.key.equals(key)) {
            head = head.next;
            size--;
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.key.equals(key)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
