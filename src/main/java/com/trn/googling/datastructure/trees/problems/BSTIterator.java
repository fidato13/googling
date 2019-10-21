//package com.trn.googling.datastructure.trees.problems;
//
//import com.trn.googling.datastructure.trees.ConstructTree;
//import com.trn.googling.datastructure.trees.Tree;
//
//public class BSTIterator {
//
//    private Tree<Integer> root;
//
//    public BSTIterator(Tree root) {
//        this.root = root;
//    }
//
//    private Tree getNextInNode(Tree root2){
//        while(root2.left != null){
//            root2 = root2.left;
//        }
//        if(root2.right != null) {
//            getNextInNode(root2.right);
//        }
//
//        return root2;
//
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        Tree<Integer> root1 = root;
//        //check if left subtree has something
//        if(root.left == null){
//            int result = root.data;
//            root = root.right;
//            return result;
//        } else {
//            System.out.println("The root1 before=> "+root1.data);
//            root1 = getNextInNode(root1.left);
//            System.out.println("The root1 after=> "+root1.data);
//            int result = root1.data;
//            root1 = null;
//            return result;
//        }
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        if(root == null){
//            return false;
//        }
//
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Tree tree = ConstructTree.constructAnotherArbitraryTree();
//
//    }
//}
//
