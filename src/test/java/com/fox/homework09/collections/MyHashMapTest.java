package com.fox.homework09.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void testPutAndGet() {
        MyHashMap map = new MyHashMap();
        map.put("a", 1);
        map.put("b", 2);

        assertEquals(1, map.get("a"));
        assertEquals(2, map.get("b"));
    }

    @Test
    void testOverwriteValue() {
        MyHashMap map = new MyHashMap();
        map.put("key", "old");
        map.put("key", "new");

        assertEquals(1, map.size());
        assertEquals("new", map.get("key"));
    }

    @Test
    void testRemove() {
        MyHashMap map = new MyHashMap();
        map.put("a", 1);
        map.put("b", 2);

        map.remove("a");

        assertNull(map.get("a"));
        assertEquals(1, map.size());
    }

    @Test
    void testClear() {
        MyHashMap map = new MyHashMap();
        map.put("a", 1);
        map.put("b", 2);

        map.clear();

        assertEquals(0, map.size());
        assertNull(map.get("a"));
    }

    @Test
    void testGetAbsentKey() {
        MyHashMap map = new MyHashMap();
        assertNull(map.get("nope"));
    }
}
