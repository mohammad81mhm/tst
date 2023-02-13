package com.company;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public void insert(E data){
        Node node = new Node (data);
        if (root == null){
            root = node;
            return;
        }
        Node<E> current = root;
        while (true){
            if (current.getData().compareTo(data) >= 0){
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    return;
                }
                current = current.getLeft();
            }
            else {
                if (current.getRight() == null){
                    current.setRight(node);
                    return;
                }
            }
            current = current.getRight();
        }
    }
    public void insertRec(E data){
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> root, E data){
        if (root == null){
            root = new Node(data);
        }
        else if (root.getData().compareTo(data) >= 0) {
            root.setLeft(insertRec(root.getLeft(), data));
        }
        else {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    public E max(){
        if (root == null) {
            return null;
        }
        var current = root;
        while (current.getRight() != null){
            if (root.getRight() != null) {
                current = root.getRight();
            }
        }
        return current.getData();
    }


    public E min(){
        if (root == null) {
            return null;
        }
        return min(root);
    }

    private E min(Node<E> root){
        if (root.getLeft() == null) {
            return root.getData();
        }
        return min(root.getLeft());
    }

    public boolean contains(E data){
        return contains(root, data);
    }

    private boolean contains(Node<E> root, E data){
        if (root == null) {
            return false;
        }
        if (root.getData().compareTo(data) == 0) return true;
        if (root.getData().compareTo(data) > 0){
            return contains(root.getLeft(), data);
        }
        return contains(root.getRight(), data);
    }

    public void remove(E data){
        root = remove(root, data);
    }

    private Node<E> remove(Node<E> root,E data){
        if (root == null) return null;
        int cmp = root.getData().compareTo(data);
        if (cmp > 0){
            root.setLeft(remove(root.getLeft(), data));
        } else if (cmp < 0) {
            root.setRight(remove(root.getRight(), data));
        }
        else {
            if (root.has2Children()) {
                E successor = min(root.getRight());
                root.setData(successor);
                root.setRight(remove(root.getRight(), data));
            }
            else {
                return root.getLeft() != null ?root.getLeft() : root.getRight();
            }
        }
        return root;
    }

}
