package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class QueueTest {
    Queue<String> q;

    @BeforeEach
    void setUp() {
        q = new Queue<>(5);
    }

    @Test
    void addOneItemTest() throws QueueOverflowException, QueueUnderflowException {
        q.add("A");
        assertEquals("A",q.front());
        assertEquals(1,q.length());
    }

    @Test
    void addMultipleItemTest() throws QueueOverflowException, QueueUnderflowException {
        q.add("A");
        q.add("B");
        q.add("C");
        assertEquals("A",q.front());
        assertEquals(3,q.length());
    }

    @Test
    void addOverflowTest() throws QueueOverflowException, QueueUnderflowException {
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("D");
        q.add("E");
        assertEquals("A",q.front());
        assertEquals(5,q.length());
        assertThrows(QueueOverflowException.class,()->q.add("F"));
    }

    @Test
    void deleteFromEmptyQueueTest() {
        assertThrows(QueueUnderflowException.class,()->q.delete());
    }

    @Test
    void deleteFromSingleItemQueue() throws QueueUnderflowException {
        q.add("A");
        assertEquals("A",q.delete());
        assertEquals(0,q.length());
    }

    @Test
    void deleteFromMultipleItemsQueue() throws QueueUnderflowException {
        q.add("A");
        q.add("B");
        q.add("C");
        assertEquals("A",q.delete());
        assertEquals("B",q.front());
        assertEquals(2,q.length());
        assertEquals("B",q.delete());
        assertEquals("C",q.front());
        assertEquals(1,q.length());
        assertEquals("C",q.delete());
        assertEquals(0,q.length());
    }

    @Test
    void frontFromEmptyQueue() {
        assertThrows(QueueUnderflowException.class,()->q.front());
    }

    @Test
    void isEmptyForEmptyQueue() {
        assertTrue(q.isEmpty());
    }

    @Test
    void isEmptyAfterDelete() throws QueueUnderflowException {
        q.add("A");
        q.delete();
        assertTrue(q.isEmpty());
    }

}