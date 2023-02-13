import java.util.*;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();
    private boolean isDirected;
    private int edgeCount;

    public Graph(boolean isDirected){
        this.isDirected = isDirected;
        edgeCount = 0;
    }

    public void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to){
        if (from.equals(to)) {
            throw new IllegalArgumentException("Self-loop is not allowed");
        }
        Node fromNode  = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("From node not found");
        }
        Node toNode = nodes.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("To node not found");
        }
        if (fromNode.adjList.contains(toNode)) {
            return;
        }
        fromNode.adjList.add(toNode);
        edgeCount++;
        if (!isDirected) {
            toNode.adjList.add(fromNode);
        }
    }

    public List<String> dfs(String label){
        for (var node: nodes.values())
            node.visited = false;
        List<String> dfs = new ArrayList<>();
        Node node = nodes.get(label);
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            var n = stack.pop();
            if (!n.visited) {
                n.visited = true;
                dfs.add(n.label);
                for (Node adj : n.adjList){
                    if (!adj.visited) {
                        stack.push(adj);
                    }
                }
            }
        }
        return dfs;
    }

    public List<String> bfs(String label){
        for (var node: nodes.values())
            node.visited = false;
        List<String> dfs = new ArrayList<>();
        Node node = nodes.get(label);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            var n = queue.remove();
            if (!n.visited) {
                n.visited = true;
                dfs.add(n.label);
                for (Node adj : n.adjList){
                    if (!adj.visited) {
                        queue.add(adj);
                    }
                }
            }
        }
        return dfs;
    }


    private class Node{
        private boolean visited;
        private String label;
        private List<Node> adjList;

        public Node(String label){
            this.label = label;
            this.visited = false;
            adjList = new ArrayList<>();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}
