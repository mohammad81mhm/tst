public interface IHeap<E extends Comparable<? super E>> {
    public void insert(E value);
    public E remove();
    public boolean isFull();
    public int size();
    public boolean isEmpty();
}

