package bst;

public class Node<T> {

    T value;
    int count = 1;
    Node<T> left;
    Node<T> right;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void printNodeInfo() {
        System.out.print(
            value +
            "(" + count + ")  "
        );
    }

    public void printNodeInfo(int number) {
        System.out.print(
            value
        );
    }
}