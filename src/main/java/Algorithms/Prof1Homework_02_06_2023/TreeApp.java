package Algorithms.Prof1Homework_02_06_2023;

public class TreeApp {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);


        System.out.println(tree);
        System.out.println(tree.contains(7));
    }
}
