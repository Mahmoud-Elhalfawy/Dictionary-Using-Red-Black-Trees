package com.company;

public class Node {
    public Node(String value, Node node) {
        this.value=value;
        this.right=node;
        this.left=node;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    private String color="black";
    private String value;
    private Node right;
    private Node left;
    private Node parent;

public Node(String value){
    this.value=value;
}

}
