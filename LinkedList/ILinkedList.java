package com.company;

import java.util.NoSuchElementException;

public interface ILinkedList<E> {
    //It is used to append the specified element to the end of a list.
    void addLast(E e);

    //It is used to insert the specified element at the specified position index in a list.
    //throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size());
    void add(int index, E element) throws IndexOutOfBoundsException;

    //	It is used to insert the given element at the beginning of a list.
    void addFirst(E e);

    //It is used to remove all the elements from a list.
    void clear();

    //It is used to return the element at the specified position in a list.
    //throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size());
    E get(int index) throws IndexOutOfBoundsException;

    //It is used to return the first element in a list.
    E getFirst() throws NoSuchElementException;

    //It is used to return the last element in a list.
    E getLast() throws NoSuchElementException;

    //It is used to return true if a list contains a specified element.
    boolean contains(E e);

    //It is used to return the index in a list of the first occurrence of the specified element,
    //or -1 if the list does not contain any element.
    int indexOf(E e);

    //It is used to remove the element at the specified position in a list.
    E remove(int index) throws IndexOutOfBoundsException;

    //	It is used to remove the first occurrence of the specified element in a list,
    //	if it is present.
    boolean remove(E e);

    //It removes and returns the first element from a list.
    E removeFirst() throws NoSuchElementException;

    //It removes and returns the last element from a list.
    E removeLast() throws NoSuchElementException;

    //It replaces the element at the specified position in a list with the specified element.
    E set(int index, E e) throws IndexOutOfBoundsException;

    //	It is used to return the number of elements in a list.
    int size();

    // If the list is empty returns true otherwise returns false
    boolean isEmpty();

}
