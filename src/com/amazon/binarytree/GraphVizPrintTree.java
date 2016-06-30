package com.amazon.binarytree;

/**
 * Created by gnowakow on 6/22/16.
 *
 * To view graphs, go to: http://www.webgraphviz.com/ and paste in DOT commands.
 */
public class GraphVizPrintTree {
    private int nullCounter = 0;

    private void buildDOT(BinNode root, StringBuilder sb) {
        if( sb == null ) {
            throw new RuntimeException("Need to provide buildDOT with a StringBuilder instance");
        }

        if( root.left != null ) {
            sb.append(root.value).append("->").append(root.left.value).append(";\n");
            buildDOT(root.left, sb);
        } else {
            buildDOTNull(root.value.toString(), sb);
        }
        if( root.right != null ) {
            sb.append(root.value).append("->").append(root.right.value).append(";\n");
            buildDOT(root.right, sb);
        } else {
            buildDOTNull(root.value.toString(), sb);
        }
    }

    private void buildDOTNull(String left, StringBuilder sb) {
        String nullStr = "null"+nullCounter++;
        sb.append(nullStr).append(" [shape=point];\n");
        sb.append(left).append("->").append(nullStr).append(";\n");
    }

    public String buildTreeDot(BinNode<Integer> root) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph BST {\n");
        buildDOT(root, sb);
        sb.append("}\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        GraphVizPrintTree pt = new GraphVizPrintTree();

        BinNode<Integer> root = new BinNode<>(15);
        root.left = new BinNode<>(6);
        root.right = new BinNode<>(18);

        root.right.left = new BinNode<>(17);

        System.out.println(pt.buildTreeDot(root));

    }

}
