package com.fox.homework09.collections;

public class MyStack {
    private Object[] data = new Object[10];
    private int size = 0;

    public void push(Object value) {
        ensureCapacity();
        data[size++] = value;
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object value = data[--size];
        data[size] = null;
        return value;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }

    public int size() {
        return size;
    }

    public void clear() {
        data = new Object[10];
        size = 0;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
