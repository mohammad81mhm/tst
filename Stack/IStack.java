package com.company;

public interface IStack <E>{
    public void push(E item);
    public E pop();
    public boolean isEmpty();
    public E peek();
    public void clear();
    public int length();
}
