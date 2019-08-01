package com.trn.googling.datastructure.trees.problems;

import com.trn.googling.datastructure.trees.ConstructTree;
import com.trn.googling.datastructure.trees.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeHeight {

    private static Logger LOG = LoggerFactory.getLogger(TreeHeight.class);

    private Integer getTreeHeight(Tree<Integer> tree){
        if(tree == null){
            return 0;
        }

        return 1 + Math.max(getTreeHeight(tree.getLeft()), getTreeHeight(tree.getLeft()));
    }

    public static void main(String[] args) {
        Tree tree =ConstructTree.constructArbitraryTree();

        TreeHeight treeHeight = new TreeHeight();

        Integer result = treeHeight.getTreeHeight(tree);

        LOG.info("The result is => "+ result);

    }


}
