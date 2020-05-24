package com.archit.coding.practice;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;

public class BinaryTreeTraversals {
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<Integer> root = binaryTree.createDummyBinaryTree();
    binaryTree.preOrder(root);
    System.out.println();
    binaryTree.postOrderIterative(root);
  }
}
