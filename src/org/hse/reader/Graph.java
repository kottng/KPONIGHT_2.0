package org.hse.reader;

import java.util.ArrayList;

import static sun.swing.MenuItemLayoutHelper.max;

public class Graph {

    private ArrayList<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void addEdge(Node from, Node to) {
        from.addNeighbor(to);
    }
    public boolean hasCycle() {
        for (Node node : nodes) {
            if (!node.getVisited() && hasCycle(node)) {
                return true;
            }
        }
        return false;
    }
    public int dfs(Node node) {
        node.setVisited(true);
        int depth = 1;
        for (var r : node.getAdjacencyList()) {
            if (!r.getVisited()) {
                depth = max(depth, dfs(r) + 1);
            }
        }
        node.setLevel(depth);
        return depth;
    }
    public boolean hasCycle(Node sourceNode) {
        sourceNode.setBeingVisited(true);

        for (Node neighbor : sourceNode.getAdjacencyList()) {
            if (neighbor.getbeingVisited()) {
                // backward edge exists
                return true;
            } else if (!neighbor.getVisited() && hasCycle(neighbor)) {
                return true;
            }
        }
        sourceNode.setBeingVisited(false);
        sourceNode.setVisited(true);
        return false;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }
    // ...
}