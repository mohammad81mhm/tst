import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    Heap<Integer> h;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        h = new Heap<>(10);
    }

    @org.junit.jupiter.api.Test
    void insert() {
        h.insert(2);
        h.insert(4);
        h.insert(6);
        h.insert(8);
        h.insert(10);
    }


    @org.junit.jupiter.api.Test
    void remove() {

    }
}