package com.amazon.binarytree;

import java.util.List;

/**
 * Created by gnowakow on 6/22/16.
 */
public class BuildBST {

    public BinNode<Integer> buildBSTTree(List<Integer> valueList) {
        BinNode<Integer> root = null;

        for( Integer val : valueList ) {
            if( root == null ) {
                root = new BinNode<>(val);
            } else {
                addNode(root, val);
            }
        }
        return root;
    }

    public void addNode(BinNode<Integer> root, Integer value) {
        if( root.value < value ) {
            if( root.left == null ) {
                root.left = new BinNode<>(value);
                return;
            } else {
                addNode(root.left, value);
            }
        } else {
            if( root.right == null ) {
                root.right = new BinNode<>(value);
                return;
            } else {
                addNode(root.right, value);
            }
        }
    }
}
