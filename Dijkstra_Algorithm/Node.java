package test;

import java.util.*;

public class Node<T> {

    private static final int INFINITY = Integer.MAX_VALUE;

    private T name;
    private LinkedList<Edge<T>> adjacencyList;
    private int costFromSource = INFINITY;
    private boolean visited;

    public Node(T name) {
        this.name = name;
        adjacencyList = new LinkedList<Edge<T>>();
    }

    public T getName() {
        return name;
    }

    public LinkedList<Edge<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public int getCostFromSource() {
    	return costFromSource;
    }

    public void setCostFromSource(int a) {
    	this.costFromSource = a;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}