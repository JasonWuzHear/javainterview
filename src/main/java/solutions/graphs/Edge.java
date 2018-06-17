package solutions.graphs;

public class Edge implements Comparable<Edge> {
    public Integer weight;
    public Integer index;

    public int compareTo(Edge edge) {
        return weight - edge.weight;
    }
}