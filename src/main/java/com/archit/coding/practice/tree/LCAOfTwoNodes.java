package com.archit.coding.practice.tree;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;

public class LCAOfTwoNodes {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    TreeNode<Integer> root = bt.createDummyBinaryTree();
    System.out.println(findLCA(root, 5, 3).data);
    System.out.println(findLCA(root, 5, 4).data);
  }

  private static TreeNode findLCA(TreeNode<Integer> root, int a, int b) {
    if (root == null) {
      return null;
    }
    if (root.data == a || root.data == b) {
      return root;
    }
    TreeNode left = findLCA(root.left, a, b);
    TreeNode right = findLCA(root.right, a, b);

    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else {
      return right;
    }


  }
}
