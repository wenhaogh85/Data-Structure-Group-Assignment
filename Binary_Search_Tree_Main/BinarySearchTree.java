package bst;

public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    //prints node in order traversal
    public void inOrderTraversal() {
        System.out.print("BST in-order: ");
        printInOrder(root);
        System.out.println();
    }

    //prints node in order recursively
    private void printInOrder(Node<T> current_node) {

        if (current_node == null) {
            return;
        }

        //prints left subtree
        printInOrder(current_node.left);

        //prints value of the current node
        current_node.printNodeInfo();

        //prints right subtree
        printInOrder(current_node.right);
    }

    public void preOrderTraversal() {
        System.out.print("BST pre-order: ");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node<T> current_node) {

        if (current_node == null) {
            return;   
        }

        //prints value of the current node
        current_node.printNodeInfo();

        //prints left subtree
        printPreOrder(current_node.left);

        //prints right subtree
        printPreOrder(current_node.right);
    }

    public void postOrderTraversal() {
        System.out.print("BST post-order: ");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node<T> current_node) {

        if (current_node == null) {
            return;   
        }

        //prints left subtree
        printPostOrder(current_node.left);

        //prints right subtree
        printPostOrder(current_node.right); 

        //prints value of the current node
        current_node.printNodeInfo();
    }

    //searches for a node
    public void search(T value) {
        Node temp_node = searchRecursive(root, value);

        boolean isFound = false;

        if (temp_node != null) {
            isFound = true;
        }

        System.out.println("Node found: " + isFound);
    }

    //searches for a node recursively
    private Node<T> searchRecursive(Node<T> current_node, T value) {

        if (current_node == null || current_node.value == value) {
            return current_node;
        }

        if (value.compareTo(root.value) < 0) {
            return searchRecursive(current_node.left, value);
        } else {
            return searchRecursive(current_node.right, value);
        }
    }

    //inserts a new node
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    //inserts a new node recursively
    private Node<T> insertRecursive(Node<T> current_node, T value) {

        if (current_node == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(current_node.value) < 0) {
            current_node.left = insertRecursive(current_node.left, value);
            return current_node;
        }

        else if (value.compareTo(current_node.value) > 0) {
            current_node.right = insertRecursive(current_node.right, value);
            return current_node;
        }

        //the node already exists
        else {
        	current_node.count++;
            return current_node;
        }
    }

    //deletes a node
    public void delete(T value) {
        deleteRecursive(root, value);
    }

    //deletes a node recursively
    private Node<T> deleteRecursive(Node<T> current_node, T value) {

        if (current_node == null) {
            return null;
        }

        if (value.compareTo(current_node.value) < 0) {
            current_node.left = deleteRecursive(current_node.left, value);
        }

        else if (value.compareTo(current_node.value) > 0) {
            current_node.right = deleteRecursive(current_node.right, value);
        }

        else {
            //node with no children
            if (current_node.left == null && current_node.right == null) {
                return null;
            }

            //node with only left child only (left subtree)
            else if (current_node.right == null) {
                return current_node.left;
            }

            //node with only right child only (right subtree)
            else if (current_node.left == null) {
                return current_node.right;
            }

            else {
                /*
                node with left and right child
                finds minimum number in right subtree
                */
                T minimum = min(current_node.right);
                current_node.setValue(minimum);
                current_node.right = deleteRecursive(current_node.right, minimum);
            }
        }

        return current_node;
    }

    /*
    finds the node with the minimum value in the
    left subtree recursively
    */
    private T min(Node<T> current_node) {

        if (current_node.left != null) {
            return min(current_node.left);
        }

        return current_node.value;
    }
}