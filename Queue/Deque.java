package com.company;

public class Deque<T> implements IDeque<T> {
    private T[] items;
    private int front;
    private int back;
    private int length;

    public Deque(int size){
        items = (T[]) new Object[size];
        front = back = -1;
    }

    public void addToFront(T newEntry) throws QueueOverflowException{
        if (isFull()){
            throw new QueueOverflowException();
        }
        if (isEmpty()) {
            front = back = 0;
        } else if (front == 0) {
            front = items.length-1;
        } else
            front--;
        length++;
        items[front] = newEntry;
    }

    public void addToBack(T newEntry) throws QueueOverflowException{
        if (isFull()){
            throw new QueueOverflowException();
        }
        if (isEmpty()) {
            front = back = 0;
        } else if (back == items.length-1) {
            back = 0;
        } else
            back++;
        length++;
        items[back] = newEntry;
    }

    private boolean isFull(){
        return (front == 0 && back == items.length-1) || back + 1 == front;
    }

    public T removeFront() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        var item = items[front];
        if (front == back) {
            front = back = -1;
        } else if (front == items.length-1) {
            front = 0;
        } else
            front++;
        length--;
        return item;
    }

    public T removeBack() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        var item = items[back];
        if (front == back) {
            front = back = -1;
        } else if (back == 0) {
            back = items.length-1;
        } else
            back--;
        length--;
        return item;
    }

    public T getFront() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return items[front];
    }

    public T getBack() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return items[back];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void clear() {
        front = back = -1;
    }

    public int length(){
        return length;
    }
}
