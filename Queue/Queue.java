package com.company;

public class Queue<E> implements IQueue<E> {

    private E[] items;
    private int front;
    private int rear;
    private int length;

    public Queue(int size) {
        items = (E[])new Object[size];
        front = rear = -1;
    }

    public void add(E item) throws QueueOverflowException {
        if (isFull()){
            throw new QueueOverflowException();
        }
        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == items.length-1) {
            rear = 0;
        } else
            rear++;
        length++;
        items[rear] = item;
    }

    private boolean isFull(){
        return (front == 0 && rear == items.length-1) || rear + 1 == front;
    }


    public E delete() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        var item = items[front];
        if (front == rear) {
            front = rear = -1;
        } else if (front == items.length-1) {
            front = 0;
        } else
            front++;
        length--;
        return item;
    }

    public E front() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return items[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int length() {
        return length;
    }
}
