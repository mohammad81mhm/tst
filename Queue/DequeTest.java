package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    private final static int MAX_PROBLEM_SIZE = 5;
    private Deque<String> mDequeue;

    @BeforeEach
    public void setUp() {
        mDequeue = new Deque<>(MAX_PROBLEM_SIZE);
    }

    @AfterEach
    public void tearDown() {
        mDequeue = null;
    }

    @Test
    public void testDeque() {
        assertNotNull(mDequeue);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(mDequeue.isEmpty(), "Initialized queue should be empty");
    }

    @Test
    public void testIsEmptyAfterAddRemoveFirst() throws QueueUnderflowException {
        mDequeue.addToFront("Something");
        assertFalse(mDequeue.isEmpty());
        mDequeue.removeFront();
        assertTrue(mDequeue.isEmpty(), "Should be empty after adding then removing");
    }

    @Test
    public void testIsEmptyAfterAddRemoveLast() throws QueueUnderflowException {
        mDequeue.addToBack("Something");
        assertFalse(mDequeue.isEmpty());
        mDequeue.removeBack();
    }

    @Test
    public void testIsEmptyAfterAddFirstRemoveLast() throws QueueUnderflowException {
        mDequeue.addToFront("Something");
        assertFalse(mDequeue.isEmpty());
        mDequeue.removeBack();
    }

    @Test
    public void testIsEmptyAfterAddLastRemoveFirst() throws QueueUnderflowException {
        mDequeue.addToBack("Something");
        assertFalse(mDequeue.isEmpty());
        mDequeue.removeFront();
        assertTrue(mDequeue.isEmpty(), "Should be empty after adding then removing");
    }

    @Test
    public void testIsEmptyAfterMultipleAddRemove() throws QueueUnderflowException {
        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToFront("Something");
            assertFalse(mDequeue.isEmpty(), "Should not be empty after " + i + " item added");
        }

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            assertFalse(mDequeue.isEmpty(), "Should not be empty after " + i + " item removed");
            mDequeue.removeBack();
        }

        assertTrue(mDequeue.isEmpty(), "Should be empty after adding and removing "
                + MAX_PROBLEM_SIZE + " elements.");
    }

    @Test
    public void testMultipleFillAndEmpty() throws QueueUnderflowException {
        for (int tries = 0; tries < 50; tries++) {
            for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
                mDequeue.addToFront(String.valueOf(i));
            }

            assertFalse(mDequeue.isEmpty());
            int i = 0;
            while (!mDequeue.isEmpty()) {
                assertEquals(String.valueOf(i), mDequeue.removeBack());
                i++;
            }

            assertTrue(mDequeue.isEmpty());

            for (int j = 0; j < MAX_PROBLEM_SIZE; j++) {
                mDequeue.addToBack(String.valueOf(j));
            }

            assertFalse(mDequeue.isEmpty());

            i = 0;
            while (!mDequeue.isEmpty()) {
                assertEquals(String.valueOf(i), mDequeue.removeFront());
                i++;
            }

            assertTrue(mDequeue.isEmpty());
        }
    }

    @Test
    public void testSize() throws QueueUnderflowException {
        assertEquals(0, mDequeue.length());
        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToFront("Something");
            assertEquals(i + 1, mDequeue.length());
        }

        for (int i = MAX_PROBLEM_SIZE; i > 0; i--) {
            assertEquals(i, mDequeue.length());
            mDequeue.removeBack();
        }

        assertEquals(0, mDequeue.length());
    }

    @Test
    public void testAddFirst() throws QueueUnderflowException {
        String[] aBunchOfString = {
                "One",
                "Two",
                "Three",
                "Four"
        };

        for (String aString : aBunchOfString) {
            mDequeue.addToFront(aString);
        }

        for (int i = aBunchOfString.length - 1; i >= 0; i--) {
            assertEquals(aBunchOfString[i], mDequeue.removeFront());
        }
    }

    @Test
    public void testAddLast() throws QueueUnderflowException {
        String[] aBunchOfString = {
                "One",
                "Two",
                "Three",
                "Four"
        };

        for (String aString : aBunchOfString) {
            mDequeue.addToBack(aString);
        }

        for (int i = aBunchOfString.length - 1; i >= 0; i--) {
            assertEquals(aBunchOfString[i], mDequeue.removeBack());
        }
    }

    @Test
    public void testAddNull() {
        assertThrows(NullPointerException.class, () -> mDequeue.addToFront(null));
        assertThrows(NullPointerException.class, () -> mDequeue.addToBack(null));
    }

    @Test
    public void testRemoveFirst() throws QueueUnderflowException {
        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToFront(String.valueOf(i));
            assertEquals(String.valueOf(i), mDequeue.removeFront());
        }

        mDequeue = new Deque<>(MAX_PROBLEM_SIZE);

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToBack(String.valueOf(i));
            assertEquals(String.valueOf(i), mDequeue.removeFront());
        }

        mDequeue = new Deque<>(MAX_PROBLEM_SIZE);

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToBack(String.valueOf(i));
        }

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            assertEquals(String.valueOf(i), mDequeue.removeFront());
        }

    }

    @Test
    public void testRemoveLast() throws QueueUnderflowException {
        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToFront(String.valueOf(i));
            assertEquals(String.valueOf(i), mDequeue.removeBack());
        }

        mDequeue = new Deque<>(MAX_PROBLEM_SIZE);

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToBack(String.valueOf(i));
            assertEquals(String.valueOf(i), mDequeue.removeBack());
        }

        mDequeue = new Deque<>(MAX_PROBLEM_SIZE);

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToFront(String.valueOf(i));
        }

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            assertEquals(String.valueOf(i), mDequeue.removeBack());
        }
    }

    @Test
    public void testRemoveEmpty() throws QueueUnderflowException {
        assertTrue(mDequeue.isEmpty());
        assertThrows(QueueUnderflowException.class, () -> mDequeue.removeFront());
        assertThrows(QueueUnderflowException.class, () -> mDequeue.removeBack());
        assertTrue(mDequeue.isEmpty());

        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.addToBack(String.valueOf(i));
        }
        for (int i = 0; i < MAX_PROBLEM_SIZE; i++) {
            mDequeue.removeBack();
        }
        assertThrows(QueueUnderflowException.class, () -> mDequeue.removeBack());
    }
}
