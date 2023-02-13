import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph g;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        g = new Graph(true);
    }

    @org.junit.jupiter.api.Test
    void addNode() {
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addNode("E");
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "E");
        g.addEdge("C", "D");
        g.addEdge("D", "E");
        var dfs = g.dfs("B");
        var bfs = g.bfs("A");
    }
}