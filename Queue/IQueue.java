package com.company;

public interface IQueue<T> {
    /**
     * یک عنصر به انتهای صف اضافه می‌کند
     * @param item عنصری که باید اضافه شود
     * @throws QueueOverflowException اگر صف پر باشد
     */
    public void add(T item) throws QueueOverflowException;
    public T delete() throws QueueUnderflowException;
    public T front() throws QueueUnderflowException;
    public boolean isEmpty();
    public int length();
}
