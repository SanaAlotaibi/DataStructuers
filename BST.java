package com.mycompany.rojectcsc212;
public class BST<T> {
    private BSTNode<T> root;

    public BST() {
        root = null;
    }

    public void insert(String key, T d) {
        root = insertRec(root, key, d);
    }

    private BSTNode insertRec(BSTNode node, String key, T d) {
        if (node == null) 
            return new BSTNode(key, d);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) 
            node.left = insertRec(node.left, key, d);
        else if (cmp > 0) 
            node.right = insertRec(node.right, key, d);
        else 
            node.data = d; 
        return node;
    }

    public T find(String key) {
        BSTNode node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) 
                node = node.left;
            else if (cmp > 0) 
                node = node.right;
            else 
                return (T) node.data;
        }
        return null;
    }

    public void remove(String key) {
        root = removeRec(root, key);
    }

    private BSTNode removeRec(BSTNode node, String key) {
        if (node == null) 
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) 
            node.left = removeRec(node.left, key);
        else if (cmp > 0) 
            node.right = removeRec(node.right, key);
        else {
            if (node.left == null) 
                return node.right;
            if (node.right == null) 
                return node.left;
            BSTNode min = minNode(node.right);
            node.key = min.key;
            node.data = min.data;
            node.right = removeRec(node.right, min.key);
        }
        return node;
    }

    private BSTNode minNode(BSTNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}





