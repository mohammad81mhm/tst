package com.company;

/** An interface for the ADT deque. */
public interface IDeque<T>
{
    /** Adds a new entry to the front/back of this deque.
     @param newEntry  An object to be added. */
    public void addToFront(T newEntry) throws QueueOverflowException;
    public void addToBack(T newEntry) throws QueueOverflowException;

    /** Removes and returns the front/back entry of this deque.
     @return  The object at the front/back of the deque.
     @throws  QueueUnderflowException if the deque is empty before the
     operation. */
    public T removeFront() throws QueueUnderflowException;
    public T removeBack() throws QueueUnderflowException;

    /** Retrieves the front/back entry of this deque.
     @return  The object at the front/back of the deque.
     @throws  QueueUnderflowException if the deque is empty. */
    public T getFront() throws QueueUnderflowException;
    public T getBack() throws QueueUnderflowException;

    /** Detects whether this deque is empty.
     @return  True if the deque is empty, or false otherwise. */
    public boolean isEmpty();

    /*  Removes all entries from this deque. */
    public void clear();

    /**
     * returns the number of elements in the deque.
     * @return number of elements
     */
    public int length();
} // end IDeque
