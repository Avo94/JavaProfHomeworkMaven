package Algorithms.Prof2Homework_23_06_2023;

public class BinaryTreeApp {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(2);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.add(1);

        System.out.println(tree);
        System.out.println(tree.isSymmetrical());
    }
}