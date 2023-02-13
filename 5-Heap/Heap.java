public class Heap<E extends Comparable<? super E>> implements IHeap {
    private E[] items;
    private int count;

    public Heap(int size) {
        items = (E[]) new Object[size];
        count = 0;
    }

    public void insert(Comparable value) {
        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }
        int index = count;
        count++;
        items[index] = (E) value;
        bubbleUp(index);
    }

    private void bubbleUp(int index) {
        while (index > 0 && items[index].compareTo(items[parentIndex(index)]) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private static int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        E temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        E result = items[0];
        items[0] = items[--count];
        bubbleDown();
        return result;
    }

    private void bubbleDown() {
        int index = 0;
        int largest = getLargerIndex(index);
        while (largest != index) {
            swap(index, largest);
            index = largest;
            largest = getLargerIndex(index);
        }
    }
    
    private void bubbleDownRec(int index){
        int largest = getLargerIndex(index);
        if (largest != index) {
            swap(index, largest);
            bubbleDownRec(largest);
        }

    }

    private int getLargerIndex(int index) {
        int largest = index;
        if (leftChildIndex(index) < count && items[leftChildIndex(index)].compareTo(items[largest]) > 0) {
            largest = leftChildIndex(index);
        }
        if (rightChildIndex(index) < count && items[rightChildIndex(index)].compareTo(items[largest]) > 0) {
            largest = rightChildIndex(index);
        }
        return largest;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count==0;
    }
}
