package com.amazon.binarytree;

/**
 * Created by gnowakow on 6/22/16.
 */
public class BinNode<T> {
    public BinNode left;
    public BinNode right;
    public T value;

    public BinNode(T value) {
        this.value = value;
    }
}
