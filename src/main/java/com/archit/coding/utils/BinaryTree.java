package com.archit.coding.utils;

import java.util.Stack;

public class BinaryTree {

  public TreeNode createDummyBinaryTree() {
    TreeNode<Integer> root = new TreeNode<>(1);

    TreeNode<Integer> leftChild = new TreeNode<>(2);
    root.left = leftChild;
    TreeNode<Integer> leftLeftChild = new TreeNode<>(4);
    leftChild.left = leftLeftChild;
    TreeNode<Integer> leftRightChild = new TreeNode<>(5);
    leftChild.right = leftRightChild;

    TreeNode<Integer> rightChild = new TreeNode<>(3);
    root.right = rightChild;
    TreeNode<Integer> rightLeftChild = new TreeNode<>(6);
    rightChild.left = rightLeftChild;
    TreeNode<Integer> rightRightChild = new TreeNode<>(7);
    rightChild.right = rightRightChild;

    return root;
  }

  public TreeNode createDummyBinaryTreeWithNegativeNodes() {
    TreeNode<Integer> root = new TreeNode<>(-15);
    root.left = new TreeNode(5);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(-8);
    root.left.right = new TreeNode(1);
    root.left.left.left = new TreeNode(2);
    root.left.left.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(9);
    root.right.right.right = new TreeNode(0);
    root.right.right.right.left = new TreeNode(4);
    root.right.right.right.right = new TreeNode(-1);
    root.right.right.right.right.left = new TreeNode(10);
    return root;
  }

  public void preOrder(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public void postOrderIterative(TreeNode<Integer> root) {
    Stack<TreeNode> stack = new Stack<>();

    while(true) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }

        if (stack.peek().right == null) {
          root = stack.pop();
          System.out.print(root.data + " ");
          while (!stack.isEmpty() && (root == stack.peek().right)) {
            root = stack.pop();
            System.out.print(root.data + " ");
          }
        }

        if (!stack.isEmpty()) {
          root = stack.peek().right;
        } else {
          root = null;
        }
      }
    }
  }

  public void printAllPathsFromRootToLeaf(TreeNode<Integer> root, int[] path, int pathlen) {
    if (root == null) {
      return;
    }
    path[pathlen] = root.data;
    pathlen++;

    if (root.left == null && root.right == null) {
      printPath(path, pathlen);
    } else {
      printAllPathsFromRootToLeaf(root.left, path, pathlen);
      printAllPathsFromRootToLeaf(root.right, path, pathlen);
    }
  }

  private void printPath(int[] path, int pathlen) {
    for (int i = 0; i < pathlen; i++) {
      System.out.print(path[i] + " ");
    }
    System.out.println();
  }
}
