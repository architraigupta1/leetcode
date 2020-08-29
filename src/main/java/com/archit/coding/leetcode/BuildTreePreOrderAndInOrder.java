package com.archit.coding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreOrderAndInOrder {
  public static void main(String[] args) {
    int[] pre = {-1};
    int[] in = {-1};
    Solution s = new Solution();
    TreeNode root = s.buildTree(pre, in);
    System.out.println();
  }
  // Definition for a binary tree node.
  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  static class Solution {
    static int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
        return null;
      }

      int n = preorder.length;
      int left = 0;
      int right = n-1;

      Map<Integer, Integer> inMap = new HashMap<>();
      for (int i = 0; i < n; i++) {
        inMap.put(inorder[i], i);
      }
      return makeTree(preorder, inMap, n, left, right);
    }

    private TreeNode makeTree(int[] preorder, Map<Integer, Integer> inMap,
                              int length, int left, int right) {
      if (preIndex > length) {
        return null;
      }

      TreeNode root = new TreeNode(preorder[preIndex]);
      int rootIndex = inMap.get(preorder[preIndex]);


      if (left <= rootIndex - 1) {
        preIndex++;
        root.left = makeTree(preorder, inMap, length, left, rootIndex - 1);
      }

      if (rootIndex + 1 <= right) {
        preIndex++;
        root.right = makeTree(preorder, inMap, length, rootIndex + 1, right);
      }

      return root;

    }
  }

/*
    1. Leftmost node is always root in preorder
    2. Make a node with leftmost index value in preorder
    3. Search for this node in the inorder array. Let it be at ith index
    4. Leftsubtree(0..i-1) and right subtree (i+1..n)
*/
}
