package com.company;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements ILinkedList<E> {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addLast(E e) {
        if (isEmpty()) {
            head = new Node(e, null);
        } else {
            var c = head;
            while (c.getNext() != null) {
                c = c.getNext();
            }
            c.setNext(new Node<>(e, null));
        }
        size++;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }else if (isEmpty()) {
            head = new Node<>(element, null);
        } else {
            var c = head;
            for (int i = 0; i < index-1; i++) {
                c = c.getNext();
            }
            c.setNext(new Node<>(element, c.getNext()));
        }
        size++;
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        size++;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            var c = head;
            for (int i = 0; i < index; i++) {
                c = c.getNext();
            }
            return (E) c.getData();
        }
    }

    public E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) head.getData();
    }

    public E getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }else {
            var c = head;
            while (c.getNext() != null){
                c = c.getNext();
            }
            return (E) c.getData();
        }
    }

    public boolean contains(E e) {
        var c = head;
        while (c != null){
            if (c.getData().equals(e)) {
                return true;
            }
            c = c.getNext();
        }
        return false;
    }

    public int indexOf(E e) {
        var c = head;
        for (int i = 0; c != null ; i++) {
            if (c.getData().equals(e)) {
                return i;
            }
            c = c.getNext();
        }
        return -1;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index > size-1) {
            throw new IndexOutOfBoundsException();
        }else if(index == 0){
            E temp = (E) head.getData();
            head = head.getNext();
            size--;
            return temp;
        } else {
            var c = head;
            for (int i = 0; i < index-1; i++) {
                c = c.getNext();
            }
            E temp = (E) c.getNext().getData();
            c.setNext(c.getNext().getNext());
            size--;
            return temp;
        }
    }

    public boolean remove(E e) {
        var c = head;
        for (int i = 0; c != null ; i++) {
            if(size == 1) {
                if (head.getData().equals(e)) {
                    head = null;
                    size--;
                    return true;
                }
            }
            if (c.getNext().getData().equals(e)) {
                c.setNext(c.getNext().getNext());
                size--;
                return true;
            }
            c = c.getNext();
        }
        return false;
    }

    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    public E removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(size-1);
    }

    public E set(int index, E e) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            var c = head;
            for (int i = 0; i < index; i++) {
                c = c.getNext();
            }
            var data = c.getData();
            c.setData(e);
            return (E) data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E>{
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;

        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
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
    }
}
