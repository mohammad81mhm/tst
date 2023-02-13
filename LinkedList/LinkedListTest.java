package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private static Stream<Arguments> lists() {
        return Stream.of(Arguments.of(new SinglyLinkedList<String>()),
                Arguments.of(new DoublyLinkedList<String>()),
                Arguments.of(new CircularDoublyLinkedList<String>()));
    }

    @ParameterizedTest
    @MethodSource("lists")
    void addFirst(ILinkedList l) {
        l.addFirst("A");
        assertEquals(1, l.size());
        assertFalse(l.isEmpty());
        assertEquals("A", l.getFirst());
        l.addFirst("B");
        assertEquals(2, l.size());
        assertEquals("B", l.getFirst());
        assertEquals("A", l.getLast());
        l.addFirst("C");
        assertEquals(3, l.size());
        assertEquals("C", l.getFirst());
        assertEquals("A", l.getLast());
    }

    @ParameterizedTest
    @MethodSource("lists")
    void addLast(ILinkedList l) {
        l.addLast("A");
        assertEquals(1, l.size());
        assertFalse(l.isEmpty());
        assertEquals("A", l.getFirst());
        assertEquals("A", l.getLast());
        l.addLast("B");
        assertEquals(2, l.size());
        assertEquals("A", l.getFirst());
        assertEquals("B", l.getLast());
        l.addLast("C");
        assertEquals(3, l.size());
        assertEquals("A", l.getFirst());
        assertEquals("C", l.getLast());
    }

    @ParameterizedTest
    @MethodSource("lists")
    void add(ILinkedList l) {
        assertThrows(IndexOutOfBoundsException.class, () -> l.add(1, "A"));
        l.add(0, "A");
        l.add(1, "B");
        l.add(2, "D");
        l.add(2, "C");
        assertEquals(4, l.size());
        assertEquals("A", l.getFirst());
        assertEquals("D", l.getLast());
        assertEquals("A", l.get(0));
        assertEquals("B", l.get(1));
        assertEquals("C", l.get(2));
        assertEquals("D", l.get(3));
        assertTrue(l.contains("A"));
        assertTrue(l.contains("B"));
        assertTrue(l.contains("C"));
        assertTrue(l.contains("D"));
        assertFalse(l.contains("a"));

        assertEquals(0, l.indexOf("A"));
        assertEquals(1, l.indexOf("B"));
        assertEquals(2, l.indexOf("C"));
        assertEquals(3, l.indexOf("D"));
        assertEquals(-1, l.indexOf("Z"));
    }

    @ParameterizedTest
    @MethodSource("lists")
    void removeFirst(ILinkedList l) {
        l.addLast("A");
        assertEquals("A", l.removeFirst());
        assertEquals(0, l.size());
        l.addLast("A");
        l.addLast("B");
        l.addLast("C");
        l.addLast("D");
        assertEquals("A", l.removeFirst());
        assertEquals(3, l.size());
        assertEquals("B", l.getFirst());
    }

    @ParameterizedTest
    @MethodSource("lists")
    void removeLast(ILinkedList l) {
        l.addLast("A");
        assertEquals("A", l.removeLast());
        assertEquals(0, l.size());
        l.addLast("A");
        l.addLast("B");
        l.addLast("C");
        l.addLast("D");
        assertEquals("D", l.removeLast());
        assertEquals(3, l.size());
        assertEquals("C", l.getLast());
    }

    @ParameterizedTest
    @MethodSource("lists")
    void removeIndex(ILinkedList l) {
        l.addLast("A");
        l.addLast("B");
        l.addLast("C");
        assertEquals("B", l.remove(1));
        assertEquals(2, l.size());
        assertEquals("A", l.getFirst());
        assertEquals("C", l.getLast());
    }

    @ParameterizedTest
    @MethodSource("lists")
    void remove(ILinkedList l) {
        l.addLast("A");
        l.addLast("B");
        l.addLast("C");
        assertEquals(true, l.remove("B"));
        assertEquals(2, l.size());
        assertEquals("A", l.getFirst());
        assertEquals("C", l.getLast());
    }

    @ParameterizedTest
    @MethodSource("lists")
    void get(ILinkedList l) {
        l.addLast("A");
        l.addLast("B");
        l.addLast("C");
        //assertEquals(true,l.remove("B"));
        l.set(0, "D");
        //assertEquals(2,l.size());
        assertEquals("D", l.getFirst());
        l.set(1, "E");
        l.set(2, "F");
        assertEquals("E", l.get(1));
        assertEquals("F", l.get(2));
    }
}