package model;

import java.util.ArrayList;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void addNode(ArrayList<String> names) {
        root = getMiddleNode(names, 0, names.size()-1);
    }

    /**
     * MALDITA SEA JAVA PORQUE CARAJOS ME DABAS ERROR POR DEJAR UN IMPORT INNECESARIO
     * 
     * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
     */
    private Node getMiddleNode(ArrayList<String> names, int lower, int higher) {
        int middle = (higher + lower) / 2;
        
        if (lower <= higher) {
            Node newNode = new Node(names.get(middle));
            newNode.setLeft(getMiddleNode(names, lower, middle - 1));
            newNode.setRight(getMiddleNode(names, ++middle, higher));
            return newNode;
        }
        
        return null;
    }

    public int deepnest() {
        int min = minimum(root, 1);
        int max = maximum(root, 1);

        if (min > max) {
            return min;
        }

        return max;
    }

    private int minimum(Node pointer, int acu) {
        if (pointer.getLeft() == null) {
            return acu;
        }

        return minimum(pointer.getLeft(), ++acu);
    }

    private int maximum(Node pointer, int acu) {
        if (pointer.getRight() == null) {
            return acu;
        }

        return maximum(pointer.getRight(), ++acu);
    }

    public String printGraf() {
        return printGraf(root);
    }

    private String printGraf(Node pointer) {
        if (pointer == null) {
            return "";
        }

        return printGraf(pointer.getRight()) + " " + pointer.getValue() + " " + printGraf(pointer.getLeft());
    }

    public Node getRoot() {
        return root;
    }
}
