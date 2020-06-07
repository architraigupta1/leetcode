package com.archit.coding.practice.tree;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;

public class DiameterOfTree {
  static int diameter = Integer.MIN_VALUE;
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<Integer> root = binaryTree.createDummyBinaryTree();
    printDiameter(root);
    System.out.println(diameter);
  }

  private static int printDiameter(TreeNode<Integer> root) {
    if (root == null) {
      return 0;
    }

    int left = printDiameter(root.left);
    int right = printDiameter(root.right);
    int cur = right + left + 1;
    diameter = Math.max(diameter, cur);

    int value = Math.max(left, right) + 1;
    return value;

  }
}
