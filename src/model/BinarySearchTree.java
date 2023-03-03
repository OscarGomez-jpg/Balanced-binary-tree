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
