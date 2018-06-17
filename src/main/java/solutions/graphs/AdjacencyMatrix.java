package solutions.graphs;

public class AdjacencyMatrix {
    public int[][] edges;
    public GraphNode[] nodes;

    public AdjacencyMatrix(GraphNode[] nodes) {
        int n = nodes.length;
        edges = new int[n][n];
        this.nodes = nodes;
    }
}