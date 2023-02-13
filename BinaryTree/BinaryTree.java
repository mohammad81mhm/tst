package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BinaryTree<E> implements IBinaryTree<E> {
    protected Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(E data) {
        root = new Node<>(data);
    }

    public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        root = new Node(data);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    public BinaryTree(List<E> list) {
        this.root = buildTree(list.listIterator());
    }

    private Node<E> buildTree(ListIterator<E> list) {
        E data = list.next();
        if (data == null) return null;
        Node<E> node = new Node<>(data);
        node.setLeft(buildTree(list));
        node.setRight(buildTree(list));
        return node;
    }

    protected static class Node<E> {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean has2Children(){
            return getLeft()!= null && getRight()!=null;
        }
    }

    public List<E> inOrder() {
        List<E> list = new LinkedList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node<E> root, List<E> list) {
        if (root == null) return;
        inOrder(root.getLeft(), list);
        list.add(root.getData());
        inOrder(root.getRight(), list);
    }

    public List<E> preOrder() {
        List<E> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node<E> root, List<E> list) {
        if (root == null) return;
        list.add(root.getData());
        preOrder(root.getLeft(), list);
        preOrder(root.getRight(), list);
    }

    public List<E> postOrder() {
        List<E> list = new LinkedList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node<E> root, List<E> list) {
        if (root == null) return;
        postOrder(root.getLeft(), list);
        postOrder(root.getRight(), list);
        list.add(root.getData());
    }

    public List<E> levelOrder() {
        return null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<E> root) {
        if (root == null) return 0;
        int leftTreeSize = size(root.getLeft());
        int rightTreeSize = size(root.getRight());
        return 1 + leftTreeSize + rightTreeSize;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public int weight() {
        return weight(root);
    }

    private int weight(Node<E> root) {
        if (root == null) return 0;
        if (root.isLeaf()) return 1;
        return weight(root.getLeft()) + weight(root.getRight());
    }

    public boolean contains(E data) {
        return contains(data, root);
    }

    private boolean contains(E data, Node<E> root) {
        if (root == null) return false;
        return root.getData().equals(data)
                || contains(data, root.getLeft())
                || contains(data, root.getRight());
    }
}
