package test;

public class PathTest {
    public static void main(String[] args) {

        Node<String> A = new Node<String>("A");
        Node<String> B = new Node<String>("B");
        Node<String> C = new Node<String>("C");
        Node<String> D = new Node<String>("D");
        Node<String> E = new Node<String>("E");
        Node<String> F = new Node<String>("F");

        int totalNodes = 6;
        Graph<String> graph = new Graph<String>(totalNodes);

        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);
        graph.addNode(F);

        graph.addEdge(A, B, 10);
        graph.addEdge(A, C, 15);

        graph.addEdge(B, D, 12);
        graph.addEdge(B, F, 15);
        graph.addEdge(C, E, 10);
        graph.addEdge(D, E, 2);
        graph.addEdge(D, F, 1);
        graph.addEdge(F, E, 5);

        /*
        graph.printEdges();

        System.out.println("List of all the nodes in the graph:");
        for (Node node: graph.getNodes()) {
            System.out.print(node.getName() + "  ");
        }
        */

        Dijkstra<String> dijkstra = new Dijkstra<String>(graph);

        dijkstra.dijkstraAlgorithm(A);    
        dijkstra.printResult();
    }
}