package Algorithms.Prof1Homework_02_06_2023;

public class BinaryTree {

    Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            add(root, value);
        }
    }

    private Node add(Node current, int value) {
        if (current == null) return new Node(value);
        if (value < current.getValue())
            current.setLeft(add(current.getLeft(), value));
        else if (value > current.getValue())
            current.setRight(add(current.getRight(), value));
        return current;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node current, int value) {
        if (current == null) return false;
        if (value < current.getValue())
            return contains(current.getLeft(), value);
        else if (value > current.getValue())
            return contains(current.getRight(), value);
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(root);
    }
}