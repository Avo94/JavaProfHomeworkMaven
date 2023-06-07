package Algorithms.Prof1Homework__02_06_2023;

public class Node {

    private final int value;
    private Node left;
    private Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "{value=" + value + " left=" + left + " right=" + right + "}";
    }
}