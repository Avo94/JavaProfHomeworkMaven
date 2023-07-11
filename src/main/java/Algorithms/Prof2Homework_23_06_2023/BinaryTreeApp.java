package Algorithms.Prof2Homework_23_06_2023;

public class BinaryTreeApp {

    public static void main(String[] args) {
        // Не симметричное
        BinaryTree firstTree = new BinaryTree();
        int[] intsOne = {6, 4, 8, 2, 3, 5, 7, 9, 1};
        for (int ints : intsOne) firstTree.add(ints);

        // Симметричное
        BinaryTree secondTree = new BinaryTree();
        int[] intsTwo = {5, 7, 3, 8, 9, 4, 6, 2, 1};
        for (int ints : intsTwo) secondTree.add(ints);

        System.out.println("Is first tree symmetrical: " + firstTree.isSymmetrical());
        System.out.println("Is second tree symmetrical: " + secondTree.isSymmetrical());
    }
}