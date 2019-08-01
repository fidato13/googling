package com.trn.googling.datastructure.trees;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class creates a tree based on the definition provided in `Tree.java` with some Integer values
 */
public class ConstructTree {

    private static Logger LOG = LoggerFactory.getLogger(ConstructTree.class);

    public static Tree<Integer> constructArbitraryTree(){
        Tree<Integer> tree1 = new Tree<>(1);
        Tree<Integer> tree2 = new Tree<>(2);
        Tree<Integer> tree3 = new Tree<>(3);
        Tree<Integer> tree4 = new Tree<>(4);
        Tree<Integer> tree5 = new Tree<>(5);
        Tree<Integer> tree6 = new Tree<>(6);
        Tree<Integer> tree7 = new Tree<>(7);
        Tree<Integer> tree8 = new Tree<>(8);
        Tree<Integer> tree9 = new Tree<>(9);

        tree5.setLeft(tree3);
        tree5.setRight(tree7);

        tree3.setLeft(tree2);
        tree3.setRight(tree4);

        tree2.setLeft(tree1);

        tree7.setLeft(tree6);
        tree7.setRight(tree8);

        tree8.setRight(tree9);


        return tree5;
    }

    public static void main(String[] args) {

        LOG.info("Let's construct a tree with 1 - 9 Trees, 5 being the root Tree.");

        Tree<Integer> tree = constructArbitraryTree();

        LOG.info("Got tree => "+ tree);

    }
}
