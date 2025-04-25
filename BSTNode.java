package com.mycompany.rojectcsc212;

public class BSTNode<T> {
    String key;
    T data;
    BSTNode<T> left, right;

    BSTNode(String k, T v) {
        key = k;
        data = v;
        left = right = null;
    }
}

