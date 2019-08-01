package com.trn.googling.datastructure.trees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeTraversals {

    private static Logger LOG = LoggerFactory.getLogger(TreeTraversals.class);

    private static Tree<Integer> staticTree = ConstructTree.constructArbitraryTree();

    private void preorderTraversal(Tree<Integer> tree){
        if(tree == null)
            return;

        int data = tree.getData();
        LOG.info("PreOrder Traversal Node's value is => "+ data);

        preorderTraversal(tree.getLeft());
        preorderTraversal(tree.getRight());
    }

    private void inorderTraversal(Tree<Integer> tree){
        if(tree == null)
            return;

        inorderTraversal(tree.getLeft());

        int data = tree.getData();
        LOG.info("InOrder Traversal Node's value is => "+ data);

        inorderTraversal(tree.getRight());
    }

    private void postorderTraversal(Tree<Integer> tree){
        if(tree == null)
            return;

        postorderTraversal(tree.getLeft());
        postorderTraversal(tree.getRight());

        int data = tree.getData();
        LOG.info("PostOrder Traversal Node's value is => "+ data);
    }

    public static void main(String[] args) {

        TreeTraversals treeTraversals = new TreeTraversals();

        LOG.info("===============================================================\n");

        treeTraversals.preorderTraversal(staticTree);

        LOG.info("===============================================================\n");

        treeTraversals.inorderTraversal(staticTree);

        LOG.info("===============================================================\n");

        treeTraversals.postorderTraversal(staticTree);
    }
}
