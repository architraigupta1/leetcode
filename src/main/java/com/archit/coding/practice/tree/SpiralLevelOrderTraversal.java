package com.archit.coding.practice.tree;

import com.archit.coding.utils.BinaryTree;
import com.archit.coding.utils.TreeNode;
import java.util.Stack;

public class SpiralLevelOrderTraversal {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<Integer> root = binaryTree.createDummyBinaryTree();
    Stack<TreeNode> cur = new Stack();
    Stack<TreeNode> next = new Stack();
    cur.push(root);
    int leftToRight = 0;
    while (!cur.isEmpty()) {
      TreeNode<Integer> node = cur.pop();
      System.out.print(node.data + " ");
      if (leftToRight == 1) {
        if (node.left != null) {
          next.push(node.left);
        }
        if (node.right != null) {
          next.push(node.right);
        }
      } else {
        if (node.right != null) {
          next.push(node.right);
        }
        if (node.left != null) {
          next.push(node.left);
        }
      }
      if (cur.isEmpty()) {
        Stack temp = cur;
        cur = next;
        next = temp;
        leftToRight = 1 - leftToRight;
      }
    }
  }
}
