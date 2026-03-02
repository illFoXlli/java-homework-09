package com.fox.homework09.collections;

public class MyHashMap<K, V> {

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;

    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    private static final float LOAD_FACTOR = 0.75f;


    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }


    public void put(K key, V value) {
        resizeIfNeeded();

        int index = getIndex(key);

        Node<K, V> current = table[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;

        size++;
    }


    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> current = table[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }


    public void remove(K key) {
        int index = getIndex(key);

        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (keysEqual(current.key, key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return;
            }

            prev = current;
            current = current.next;
        }
    }


    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }


    public int size() {
        return size;
    }


    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }

        return Math.abs(key.hashCode()) % table.length;
    }


    private boolean keysEqual(K k1, K k2) {
        return k1 == null ? k2 == null : k1.equals(k2);
    }


    private void resizeIfNeeded() {
        if (size >= table.length * LOAD_FACTOR) {

            Node<K, V>[] oldTable = table;

            table = new Node[oldTable.length * 2];

            size = 0;

            for (Node<K, V> node : oldTable) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }
}