package com.company;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class StackTest {
    IStack<String> s;
    @BeforeEach
    void setUp() {
        s = new Stack<>(5);
    }

    @Test
    void stackIsEmptyOnCreation(){
        assertTrue(s.isEmpty());
    }

    @Test
    void push() {
        s.push("A");
        assertEquals("A",s.peek());
        assertFalse(s.isEmpty());
        s.push("B");
        assertEquals(2,s.length());
        s.push("C");
        assertEquals(3,s.length());
        assertEquals("C",s.peek());
        s.push("D");
        s.push("E");
        assertThrows(StackOverflowError.class,()->s.push("F"));
    }

    @Test
    void pop() {
        assertThrows(NoSuchElementException.class,()->s.pop());
        s.push("A");
        assertEquals("A",s.pop());
        assertTrue(s.isEmpty());
        assertEquals(0,s.length());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void peek() {
    }

    @Test
    void clear() {
    }
}