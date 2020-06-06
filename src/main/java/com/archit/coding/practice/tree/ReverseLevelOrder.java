package com.archit.coding.practice.tree;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<Integer> root = binaryTree.createDummyBinaryTree();
    printReverseLevelOrder(root);
  }

  private static void printReverseLevelOrder(TreeNode<Integer> root) {
    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      while (levelSize != 0) {
        TreeNode cur = queue.poll();
        stack.add(cur);
        if (cur.right != null) {
          queue.add(cur.right);
        }
        if (cur.left != null) {
          queue.add(cur.left);
        }
        levelSize--;
      }
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop().data + " ");
    }
  }
}
