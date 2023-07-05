package Algorithms.Prof2Homework_23_06_2023;

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

    public boolean isSymmetrical() {
        return isSymmetrical(root);
    }

    private boolean isSymmetrical(Node current) {
        if (current == null) return false;
        if (current.getLeft() == null && current.getRight() == null) return true;
        return isSymmetrical(current.getLeft()) && isSymmetrical(current.getRight());
    }

    @Override
    public String toString() {
        return String.valueOf(root);
    }
}
