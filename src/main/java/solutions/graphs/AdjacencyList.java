package solutions.graphs;

import java.util.ArrayList;

public class AdjacencyList {
    public GraphNode[] nodes;
    public ArrayList<ArrayList<Edge>> edges;

    public AdjacencyList(GraphNode[] nodes) {
        this.nodes = nodes;
        edges = new ArrayList<ArrayList<Edge>>();
    }
    


}