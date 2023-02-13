package com.company;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements ILinkedList<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        var node = getNode(index);
        addBetween(element, node.getPrev(), node);
    }

    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }

    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).getData();
    }

    public E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getNext().getData();
    }

    public E getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getPrev().getData();
    }

    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    public int indexOf(E e) {
        var c = head.getNext();
        for (int i = 0; i < size; i++) {
            if (c.getData().equals(e)) {
                return i;
            }
            c = c.getNext();
        }
        return -1;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return remove(getNode(index));
    }

    public boolean remove(E e) {
        var index = indexOf(e);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return remove(0);
    }

    public E removeLast() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return remove(size-1);
    }

    public E set(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var node = getNode(index);
        var data =node.getData();
        node.setData(e);
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void addBetween(E e, Node<E> p,  Node<E> q){
        Node<E> node = new Node<>(e, p, q);
        p.setNext(node);
        q.setPrev(node);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> p = node.getPrev();
        Node<E> q = node.getNext();
        p.setNext(q);
        q.setPrev(p);
        size--;
        return node.getData();
    }

    private Node<E> getNode(int index){
        Node c = head.getNext();
        for (int i = 0; i < index; i++) {
            c = c.getNext();
        }
        return c;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, Node<E> prev, Node<E> next) {
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
