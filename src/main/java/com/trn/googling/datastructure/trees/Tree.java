package com.trn.googling.datastructure.trees;


/**
 * This class is a wrapper for actual Tree class. This has a member as Tree
 */
public class Tree<T> {

    private T data;
    private Tree<T> left;
    private Tree<T> right;

    public Tree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }
}