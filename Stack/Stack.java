package com.company;

import java.util.NoSuchElementException;

public class Stack<E> implements IStack<E>{

    private E[] items;
    private int top;
    private int size;

    public Stack(int size) {
        items = (E[]) new  Object[size];
        top = -1;
    }

    @Override
    public void push(E item) throws StackOverflowError{
        if (isFull()) throw new StackOverflowError();
        items[++top] = item;
    }

    private boolean isFull(){
        return top == items.length -1;
    }

    @Override
    public E pop() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        return items[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E peek() throws NoSuchElementException{
        if (isEmpty()) return null;
        return items[top];
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public int length() {
        return top+1;
    }
}
