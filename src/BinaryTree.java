import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable {

    //Fields
    public Node<E> root;

    BinaryTree() {
        root = null;
    }

    BinaryTree(E dataValue) {
        root = new Node<>(dataValue);
    }

    BinaryTree(Node<E> rootValue) {
        root = rootValue;
    }

    BinaryTree(E dataValue, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(dataValue);
        if (leftTree == null)
            root.left = null;
        else
            root.left = leftTree.root;
        if (rightTree == null)
            root.right = null;
        else
            root.right = rightTree.root;
    }

    public static BinaryTree<String> readBinaryTree(Scanner scanner) {
        String data = scanner.nextLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scanner);
            BinaryTree<String> rightTree = readBinaryTree(scanner);
            return new BinaryTree<>(data, leftTree, rightTree);
        }
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null)
            return new BinaryTree<>(root.left);
        return null;
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null)
            return new BinaryTree<>(root.right);
        return null;
    }

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public E getData() {
        return root.data;
    }

    //TODO: HERE
    public String toString() {

        return "";
    }

    //Inner Class
    public static class Node<E> implements Serializable {
        public E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E dataValue) {
            data = dataValue;
            left = right = null;
        }

        public E getData() {
            return data;
        }

        public String toString() {
            return data.toString();
        }
    }
}

