package test;

import java.util.*;

public class Dijkstra<T> {

    private static final int INFINITY = Integer.MAX_VALUE;
    private Graph<T> graph;
    private int start_node_index;

    public Dijkstra (Graph<T> graph) {
        this.graph = graph;
    }

    public Node<T> getMinCostNode() {

        System.out.println("\n---------------------------------");
        System.out.println("Calling getMinCostNode...");

        ArrayList<Node<T>> nodes = graph.getNodes();
        Node<T> storedNode = nodes.get(start_node_index);

        int storedCost = INFINITY;

        for (int index = 0; index < graph.getTotalNodes(); index++) {

            System.out.println("\n~~~~~~~~~~~~~~~~~~~");
            System.out.println("iteration: " + index);

            int currentNodeCost = nodes.get(index).getCostFromSource();
            
            System.out.println("\nCurrentNode: " + nodes.get(index).getName());
            System.out.print("CurrentNodeCost: ");
            printCost(currentNodeCost);

            if (nodes.get(index).isVisited() != true && currentNodeCost < storedCost) {

                storedCost = currentNodeCost;
                storedNode = nodes.get(index);

                System.out.print("StoredCost: ");
                printCost(storedCost);

                System.out.println("StoredNode: " + storedNode.getName());
            }
        }

        return storedNode;
    }

    public Graph<T> dijkstraAlgorithm(Node<T> start_node) {

        System.out.println("\n*********************************");
        System.out.println("Calling dijkstraAlgorithm...");

        ArrayList<Node<T>> nodes = graph.getNodes();

        //node 0 as source
        start_node_index = findNode(nodes, start_node);

        nodes.get(start_node_index).setCostFromSource(0);

        System.out.println(
            "\nNode cost from source: " +
            nodes.get(start_node_index).getCostFromSource()
        );

        Node<T> nextNode = nodes.get(start_node_index);

        System.out.println("nextNode: " + nextNode.getName());

        for (int index = 0; index < graph.getTotalNodes(); index++) {

            System.out.println("\n####################");
            System.out.println("iteration: " + index);

            LinkedList<Edge<T>> currentNodeEdges = nextNode.getAdjacencyList();
            
            if (currentNodeEdges.size() != 0) {
	            System.out.println("\ncurrentNodeEdges:");
	            printEdges(currentNodeEdges);
            }
            else {
            	System.out.println("\nCurrent node " + nextNode.getName() + " doesn't have directed edge");
            }

            for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
                
                System.out.println("\n....................");
                System.out.println("sub iteration: " + joinedEdge);

                Node<T> neighbourNode = currentNodeEdges.get(joinedEdge).getAdjacentNode();
                
                System.out.println("\ncurrentNodeEdges: " + currentNodeEdges.size());
                System.out.println("neighbourNode   : " + neighbourNode.getName());

                if (neighbourNode.isVisited() != true) {

                    int temp1 = nextNode.getCostFromSource();
                    int temp2 = currentNodeEdges.get(joinedEdge).getCost();

                    int totalCost = temp1 + temp2;

                    System.out.println("total cost: " + totalCost);

                    if (totalCost < neighbourNode.getCostFromSource()) {
                        neighbourNode.setCostFromSource(totalCost);
                        System.out.println("updated neighbour node cost: " + totalCost);
                    }
                }
            }

            nextNode.setVisited(true);

            System.out.println(
                "\n" + nextNode.getName() +
                " has been visited"
            );
                        
            //To check if the current node has edge linked to other node
            if (currentNodeEdges.size() != 0) {
            	nextNode = getMinCostNode();
            	System.out.println("\nnextNode: " + nextNode.getName());
            }
            else {
            	System.out.println("\nAll the nodes have been visited!");
            }
        }

        return graph;
    }

    public int findNode(ArrayList<Node<T>> nodes, Node<T> node) {

        int node_index = -1;
        for (int index = 0; index < graph.getTotalNodes(); index++) {

            if (nodes.get(index).getName().equals(node.getName())) {
                node_index = index;
                break;
            }
        }

        return node_index;
    }

    public void printEdges(LinkedList<Edge<T>> currentNodeEdges) {

        for (Edge<T> edge: currentNodeEdges) {
            edge.printInfo();
        }
        System.out.println();
    }

    public void printResult() {

        ArrayList<Node<T>> nodes = graph.getNodes();
        
        System.out.println("\n===================");
        System.out.print("Result:");
        for (int index = 0; index < graph.getTotalNodes(); index++) {

            String cost = "";
            if (nodes.get(index).getCostFromSource() == INFINITY) {
                cost = "infinity";
            } else {
                cost = Integer.toString(nodes.get(index).getCostFromSource());
            }

            System.out.printf(
                "\nMinimum cost from node %s to node %s is %s",
                nodes.get(start_node_index).getName(),
                nodes.get(index).getName(),
                cost
            );
        }
    }

    public void printCost(int cost) {

        if (cost == INFINITY) {
            System.out.println("Infinity");
        } else {
            System.out.println(cost);
        }
    }
}
