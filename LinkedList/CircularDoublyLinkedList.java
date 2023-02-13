package com.company;

import java.util.NoSuchElementException;

public class CircularDoublyLinkedList<E> implements ILinkedList<E> {
    private Node<E> head;
    private int size;

    public CircularDoublyLinkedList(){
        size = 0;
        head = new Node<E>(null,null,null);
        head.setNext(head);
        head.setPrev(head);
    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {

    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        return null;
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

}
