package solutions.graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class DirectedGraphNode {
    int data;
    public boolean isVisited;

    ArrayList<DirectedGraphNode> destinations;

    public DirectedGraphNode(int v) {
        data = v;
    }

    // So each invocation of this method has it's own local 
    // flags for visited. That way, you don't need to make a
    // copy of the graph for many invocations of this method.
    public boolean canIGetThere(DirectedGraphNode dest) {
        return canIGetThere(dest, new HashSet<DirectedGraphNode>());
    }
    boolean canIGetThere(DirectedGraphNode dest, HashSet<DirectedGraphNode> visited) {
        visited.add(this);
        if (dest == this) return true;
        for(DirectedGraphNode d : destinations) {
            if (visited.contains(d)) continue;
            if (d.canIGetThere(dest, visited)) return true;
        }
        return false;
    }

    public boolean canIGetThereLocal(DirectedGraphNode dest) {
        if (dest == this) return true; // base case

        if (!isVisited) {
            isVisited = true;
            for(DirectedGraphNode d : destinations) {
                if (d.canIGetThereLocal(dest)) {
                    isVisited = false;
                    return true;
                }
            }
        }

        isVisited = false;
        return false;
    }
}