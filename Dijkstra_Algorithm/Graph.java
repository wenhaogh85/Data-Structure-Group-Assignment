package test;

import java.util.*;

public class Graph<T> {

    private int totalNodes;
    private ArrayList<Node<T>> nodes;

    public Graph(int totalNodes) {
        nodes = new ArrayList<Node<T>>(totalNodes);
        this.totalNodes = totalNodes;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public ArrayList<Node<T>> getNodes(){
        return nodes;
    }

    public void addNode(Node<T> node) {
        nodes.add(node);
    }

    public void addEdge(Node<T> node, Node<T> adjacentNode, int cost) {

        Edge<T> edge = new Edge<T>(node, adjacentNode, cost);
        node.getAdjacencyList().addFirst(edge);
    }

    public void printEdges() {

        System.out.println("All edges:");

        for (Node<T> node: nodes) {
            System.out.println("\n-----------------------");
            System.out.println("Number of edges: " + node.getAdjacencyList().size() + "\n");
            for(Edge<T> edge: node.getAdjacencyList()) {
                edge.printInfo();
            }
        }
    }
}
