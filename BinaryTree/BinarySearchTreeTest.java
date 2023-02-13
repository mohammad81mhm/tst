package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    BinarySearchTree<Integer> bst;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @org.junit.jupiter.api.Test
    void insert() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(7);
        var x = bst.size();
    }

    @org.junit.jupiter.api.Test
    void contains() {
        bst.insert(10);
        bst.insert(7);
        bst.insert(5);
        bst.insert(15);
        bst.insert(11);
        assertTrue(bst.contains(11));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(15));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(7));
        assertTrue(bst.contains(1));
        assertTrue(bst.contains(14));
    }
}