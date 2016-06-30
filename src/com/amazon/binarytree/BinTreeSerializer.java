package com.amazon.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnowakow on 6/22/16.
 */
public class BinTreeSerializer {

    public BinNode<Integer> fromString(List<Integer> values) {
        List<BinNode<Integer>> nodes = new ArrayList<>(values.size());

        BinNode<Integer> root = null;

        // Using the formula: LeftNode = 2(i)+1, RightNode = 2(i)+2
        for(int ctr = 0; ctr < values.size(); ctr++ ) {
            BinNode<Integer> workNode = null;
            if( root == null ) {
                root = new BinNode<>(values.get(0));
                workNode = root;
            } else {
                workNode = nodes.get(ctr);
            }

            if( workNode != null ) {
                int leftIdx = 2 * ctr + 1;
                int rightIdx = leftIdx + 1;

                if (values.size() >= leftIdx && values.get(leftIdx) != null) {
                    workNode.left = new BinNode<>(values.get(leftIdx));
                    nodes.add(leftIdx, root.left);
                }

                if (values.size() >= rightIdx && values.get(rightIdx) != null) {
                    workNode.right = new BinNode<>(values.get(rightIdx));
                    nodes.add(rightIdx, root.right);
                }
            }
        }

        return root;
    }
}
