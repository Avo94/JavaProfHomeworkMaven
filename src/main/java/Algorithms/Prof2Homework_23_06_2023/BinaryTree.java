package Algorithms.Prof2Homework_23_06_2023;

public class BinaryTree {

    Node root;

    public void add(int value) {
        if (root == null) root = new Node(value);
        else add(root, value);
    }

    private Node add(Node current, int value) {
        if (current == null) return new Node(value);
        if (value < current.getValue()) current.setLeft(add(current.getLeft(), value));
        if (value > current.getValue()) current.setRight(add(current.getRight(), value));
        return current;
    }

    public boolean isSymmetrical() {
        if (root == null) return true;
        int[] leftBranch = isSymmetrical(root.getLeft(), new int[]{0, 1});
        int[] rightBranch = isSymmetrical(root.getRight(), new int[]{0, 1});
        // leftBranch[0] == rightBranch[0] * (-1) - проверка на зеркальность (* (-1)) симметри левых и правых нод
        // leftBranch[1] == rightBranch[1] - проверка на одинаковое количество нод в левой и правой подветке
        return leftBranch[0] == rightBranch[0] * (-1) && leftBranch[1] == rightBranch[1];
    }

    private int[] isSymmetrical(Node current, int[] nodesCounter) {
        if (current == null) {
            nodesCounter[0] = 0;
            nodesCounter[1] = 0;
            return nodesCounter;
        }
        // Первый параметр - шаг в лево: каждая левая нода = -1
        // Второй параметр - каждая не null нода в левой подветке
        int[] leftNode = isSymmetrical(current.getLeft(), new int[]{-1, 1});
        // Первый параметр - шаг в вправо: каждая правая нода = +1
        // Второй параметр - каждая не null нода в правой подветке
        int[] rightNode = isSymmetrical(current.getRight(), new int[]{1, 1});
        // Складывание левых и правых нод (+1) и (-1) для запоминания симметрии найденных нод
        nodesCounter[0] += leftNode[0] + rightNode[0];
        // Складывание всех найденных нод в результирующее значение
        nodesCounter[1] += leftNode[1] + rightNode[1];
        return nodesCounter;
    }

    @Override
    public String toString() {
        return String.valueOf(root);
    }
}