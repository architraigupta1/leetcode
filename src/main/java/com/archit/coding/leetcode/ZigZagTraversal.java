package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode leftleft = new TreeNode(4);
    TreeNode leftright = new TreeNode(5);
    TreeNode rightleft = new TreeNode(6);
    TreeNode rightright = new TreeNode(7);
    root.left = left;
    root.right =right;
    root.left.left = leftleft;
    root.left.right = leftright;
    root.right.left = rightleft;
    root.right.right = rightright;
    List<List<Integer>> result = s.zigzagLevelOrder(root);
    System.out.println();
  }

   // Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
   }

  static class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      List<Integer> level = new ArrayList<>();
      boolean leftToRight = true;

      Stack<TreeNode> cur = new Stack<>(); //store nodes of current level
      Stack<TreeNode> next = new Stack<>(); //store nodes of next level

      cur.push(root);

      while(!cur.isEmpty()) {
        TreeNode node = cur.pop();

        //Add the node to level output
        level.add(node.val);

        if (leftToRight) {
          if (node.left != null) {
            next.add(node.left);
          }
          if (node.right != null) {
            next.add(node.right);
          }
        } else {
          if (node.right != null) {
            next.add(node.right);
          }
          if (node.left != null) {
            next.add(node.left);
          }
        }

        if (cur.isEmpty()) {
          //add the nodes of current level to result and reset level
          result.add(level);
          level = new ArrayList<>();

          //switch the processing for next level
          leftToRight = true ^ leftToRight;

          //swap stacks
          Stack<TreeNode> temp = cur;
          cur = next;
          next = temp;
        }

      }

      return result;
    }
  }
}
