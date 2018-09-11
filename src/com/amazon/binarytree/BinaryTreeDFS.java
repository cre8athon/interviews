package com.amazon.binarytree;

public class BinaryTreeDFS {

    public void dfsInOrder(Node root) {
        if (root == null) {
            return;
        }

        dfsInOrder(root.left);
        System.out.println(root.data);
        dfsInOrder(root.right);
    }
}
