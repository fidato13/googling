package com.trn.googling.datastructure.trees;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TODO :
 *  Implement `findNodeExistsIterativeWithoutBST`,  `findNodeExistsRecursiveWithBST` & `findNodeExistsIterativeWithBST`
 */

/**
 *  This class contains useful methods related to trees like: finding a node in tree
 */
public class TreeMethods {

    private static Logger LOG = LoggerFactory.getLogger(TreeMethods.class);
    /**
     * Let's create a tree from the static method on another class `ConstructTree`
     * This follows the left node being smaller in value and right node being bigger in value notion
     */
    private Tree<Integer> treeStatic = ConstructTree.constructArbitraryTree();


    private Boolean findNodeExistsRecursiveWithBST(Tree<Integer> tree, Integer value){
        if(tree == null){
            return false;
        }

        if(tree.getData() == value){
            return true;
        }

        return (tree.getData() < value) ? findNodeExistsRecursiveWithBST(tree.getRight(), value) : findNodeExistsRecursiveWithBST(tree.getLeft(), value);
    }

    /**
     * This method finds the passed value in the above tree - Recursively
     * This method doesn't make use of the BST property
     * Complexity : O(n) ,since it traverses all nodes in the worst case
     * @param value
     */
    private Boolean findNodeExistsRecursiveWithoutBST(Tree<Integer> tree, Integer value){

        if(tree == null) {
            return false;
        }

        if(tree.getData() == value){
            //LOG.info("Node found with value : "+ value + " , it's left child is : " +tree.getLeft().getData() + " , it's right child is : "+ tree.getRight().getData());
            return true;
        }

        return findNodeExistsRecursiveWithoutBST(tree.getLeft(), value) ||
                findNodeExistsRecursiveWithoutBST(tree.getRight(), value);

    }

    /**
     * This method finds the passed value in the above tree - Iteratively
     * This doesn't eliminate half of the nodes at a given choice as we need to visit every node to see; because we are not given a BST but a binary tree
     * This uses a stack/DFS approach
     * @param value
     */
    private Boolean findNodeExistsIterativeWithoutBSTDFS(Tree<Integer> tree, Integer value){

        Stack<Tree<Integer>> stack = new Stack<>();

        // use a stack i.e. DFS ?
        if(tree == null){
            return false;
        }

        if(tree.getData() == value){
            return true;
        }

        if(tree.getRight() != null){
            stack.push(tree.getRight());
        }

        if(tree.getLeft() != null){
            stack.push(tree.getLeft());
        }

        while(!stack.isEmpty()){

            tree = stack.pop();

            if(tree.getData() == value){
                return true;
            }

            if(tree.getRight() != null){
                stack.push(tree.getRight());
            }

            if(tree.getLeft() != null){
                stack.push(tree.getLeft());
            }


        }

        return false;
    }

    /**
     * This method finds the passed value in the above tree - Iteratively
     * This doesn't eliminate half of the nodes at a given choice as we need to visit every node to see; because we are not given a BST but a binary tree
     * This uses a queue/BFS approach
     * @param value
     */
    private Boolean findNodeExistsIterativeWithoutBSTBFS(Tree<Integer> tree, Integer value){

        // use a queue i.e. BFS ?
        if(tree == null){
            return false;
        }

        if(tree.getData() == value){
            return true;
        }

        Queue<Tree<Integer>> queue = new LinkedList<>();

        if(tree.getLeft() != null){
            queue.offer(tree.getLeft());
        }

        if(tree.getRight() != null){
            queue.offer(tree.getRight());
        }

        while(!queue.isEmpty()){
            tree = queue.poll();

            if(tree.getData() == value){
                return true;
            }

            if(tree.getLeft() != null){
                queue.offer(tree.getLeft());
            }

            if(tree.getRight() != null){
                queue.offer(tree.getRight());
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeMethods treeMethods = new TreeMethods();

        //Boolean result = treeMethods.findNodeExistsRecursiveWithoutBST(treeMethods.treeStatic, 8);

        //Boolean result = treeMethods.findNodeExistsIterativeWithoutBSTDFS(treeMethods.treeStatic, 10);

        //Boolean result = treeMethods.findNodeExistsIterativeWithoutBSTBFS(treeMethods.treeStatic, 5);

        Boolean result = treeMethods.findNodeExistsRecursiveWithBST(treeMethods.treeStatic, 1);

        LOG.info("The tree was found - "+ result);
    }
}
