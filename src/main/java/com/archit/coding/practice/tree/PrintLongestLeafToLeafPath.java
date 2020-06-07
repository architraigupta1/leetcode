package com.archit.coding.practice.tree;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;

public class PrintLongestLeafToLeafPath {
  static int diameter = Integer.MIN_VALUE;
  static int index = 0;
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<Integer> root = binaryTree.createDummyBinaryTreeWithNegativeNodes();
    int[] a = new int[20];
    printLongestPath(root, a);
    for (int i = 0; i < index; i++) {
      System.out.print(a[i] + " ");
    }
  }

  private static int printLongestPath(TreeNode<Integer> root, int[] a) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    int left = printLongestPath(root.left, a);
    int right = printLongestPath(root.right, a);

    if (left > right) {
      a[index] = root.left.data;
    } else {
      a[index] = root.right.data;
    }
    index++;
    int value = Math.max(left, right) + 1;

    if (diameter < right + left + 1) {
      a[index] = root.data;
      index++;
    }
    diameter = Math.max(diameter, right + left + 1);
    return value;

  }
}
