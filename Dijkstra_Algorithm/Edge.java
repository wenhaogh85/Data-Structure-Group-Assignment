package test;

public class Edge<T> {

    private Node<T> node;
    private Node<T> adjacentNode;
    private int cost;

    public Edge(Node<T> node, Node<T> adjacentNode, int cost) {
        this.node = node;
        this.adjacentNode = adjacentNode;
        this.cost = cost;
    }

    public Node<T> getNode() {
        return node;
    }

    public Node<T> getAdjacentNode() {
        return adjacentNode;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void printInfo() {

        System.out.printf("\n      %d    ", cost);
        System.out.printf(
            "\n%s --------> %s",
            node.getName(),
            adjacentNode.getName()
        );
        System.out.println();
    }
}
