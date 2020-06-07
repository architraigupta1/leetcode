package com.archit.coding.practice.tree;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;

public class MaxPathSumBetweenTwoLeaves {
  static int maxSum = Integer.MIN_VALUE;
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<Integer> root = binaryTree.createDummyBinaryTree();
    maxSum(root);
    System.out.println(maxSum);
    maxSum = Integer.MIN_VALUE;
    TreeNode<Integer> root1 = binaryTree.createDummyBinaryTreeWithNegativeNodes();
    maxSum(root1);
    System.out.println(maxSum);
  }

  private static int maxSum(TreeNode<Integer> root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int leftSum = maxSum(root.left);
    int rightSum = maxSum(root.right);

    maxSum = Math.max(maxSum, leftSum + rightSum + root.data);
    int maxChildSum = Math.max(leftSum, rightSum);
    if (maxChildSum == Integer.MIN_VALUE) {
      return root.data;
    }
    return maxChildSum + root.data;
  }
}
