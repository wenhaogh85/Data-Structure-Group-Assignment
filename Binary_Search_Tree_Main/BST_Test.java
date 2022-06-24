package bst;

public class BST_Test {
    public static void main(String[] args) {
        

        BinarySearchTree<Integer> int_bst = new BinarySearchTree<Integer>();
        BinarySearchTree<String> str_bst = new BinarySearchTree<String>();
        BinarySearchTree<Character> char_bst = new BinarySearchTree<Character>();
        BinarySearchTree<Double> double_bst = new BinarySearchTree<Double>();

        Integer[] int_nodes = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        String[] str_nodes = {"Katara", "Aang", "Appa", "Zuko", "Toph", "Momo", "Sokka"};
        Character[] char_nodes = {'K', 'E', 'D', 'A', 'Z', 'T', 'U', '+', '*'};
        Double[] double_nodes = {8.2, 3.1, 2.5, 7.1, 4.8, 4.7, 5.5};

        //tests for integer values
        System.out.println("Test for integer values:");
        for(Integer node: int_nodes) {
            int_bst.insert(node);
        }

        int_bst.preOrderTraversal();
        int_bst.inOrderTraversal();
        int_bst.postOrderTraversal();

        //tests for string values
        System.out.println("\nTest for string values:");
        for(String node: str_nodes) {
            str_bst.insert(node);
        }

        str_bst.preOrderTraversal();
        str_bst.inOrderTraversal();
        str_bst.postOrderTraversal();

        //tests for character values
        System.out.println("\nTest for character values:");
        for(Character node: char_nodes) {
            char_bst.insert(node);
        }

        char_bst.preOrderTraversal();
        char_bst.inOrderTraversal();
        char_bst.postOrderTraversal();

        //tests for double values
        System.out.println("\nTest for double values:");
        for(Double node: double_nodes) {
            double_bst.insert(node);
        }

        double_bst.preOrderTraversal();
        double_bst.inOrderTraversal();
        double_bst.postOrderTraversal();
    }
}