package bst;

public class BST_Test {
    public static void main(String[] args) {

        BinarySearchTree<Integer> int_bst = new BinarySearchTree<Integer>();

        Integer[] int_nodes = {31, 27, 57, 29};

        //tests for integer values
        for(Integer node: int_nodes) {
            System.out.println("\n******************************\n");
            int_bst.insert(node);

            System.out.println("\nResult after insertion:");
            int_bst.inOrderTraversal();
        }

        int_bst.preOrderTraversal();
        int_bst.postOrderTraversal();

        System.out.println("\n------------------------------\n");

        System.out.println("BST before insertion:");
        int_bst.inOrderTraversal();

        Integer node = 20;
        System.out.println("\nNode to be inserted:" + node);
        int_bst.insert(node);

        System.out.println("\nBST after insertion:");
        int_bst.inOrderTraversal();

        System.out.println("\n------------------------------");

        System.out.println("\nBST before deletion:");
        int_bst.inOrderTraversal();

        Integer node_2 = 29;
        System.out.println("\nNode to be deleted:" + node_2);
        int_bst.delete(node_2);

        System.out.println("\nBST after deletion:");
        int_bst.inOrderTraversal();
    }
}