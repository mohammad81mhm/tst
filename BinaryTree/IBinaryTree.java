package com.company;

import java.util.List;

public interface IBinaryTree<E> {
    List<E> inOrder();
    List<E> preOrder();
    List<E> postOrder();
    List<E> levelOrder();
    int size();
    int height();
    int weight();
    boolean contains(E data);
}
