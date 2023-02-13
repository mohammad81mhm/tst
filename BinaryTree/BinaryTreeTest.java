package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree<String> b;

    @BeforeEach
    void constructorTest(){
        String[] s = new String[]{"a","e",null,null,"b","c",null,null,"d",null,null};
        b = new BinaryTree<>(Arrays.asList(s));
    }

    @Test
    void inOrder(){
        var list = b.inOrder();
        System.out.print(list);
    }

}