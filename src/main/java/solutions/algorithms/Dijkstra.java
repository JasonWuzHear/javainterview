package solutions.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

import solutions.graphs.AdjacencyList;
import solutions.graphs.Edge;

public class Dijkstra {

    AdjacencyList graph;
    Edge[][] paths;

    HashSet<Integer> visited;
    PriorityQueue<Edge> unvisited;

    public Dijkstra(AdjacencyList graph) {
        this.graph = graph;
        int n = graph.nodes.length;
        paths = new Edge[n][n];
    }

    public void createPaths(int sta) {
        // initialize 
        paths[sta][sta].weight = 0;
        visited = new HashSet<Integer>();
        unvisited = new PriorityQueue<Edge>();
        unvisited.add(paths[sta][sta]);
        while(!unvisited.isEmpty()) {
            createPaths(sta, unvisited.remove().index);
        }
    }

    void createPaths(int sta, int cur) {
        if(visited.contains(cur))
            return;
        visited.add(cur);

        ArrayList<Edge> dests = graph.edges.get(cur);
        int curDistance = paths[sta][cur].weight;

        for(Edge dest : dests) {
            Edge total = paths[sta][dest.index]; // from the start to this new destination
            int dist = dest.weight + curDistance;
            if (total.weight == null) {
                total.weight = dist;
                total.index = cur;
            }
            else if (dist < total.weight) {
                total.weight = dist;
                total.index = cur;
            }
            unvisited.add(total);
        }
    }
}