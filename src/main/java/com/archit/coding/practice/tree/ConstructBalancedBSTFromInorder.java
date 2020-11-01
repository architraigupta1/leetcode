package com.archit.coding.practice.tree;

public class ConstructBalancedBSTFromInorder {
  public static void main(String[] args) {
    int[] a = {1,2,3,4,5};
    Solution s = new Solution();
    System.out.println(s.construcBalancedBST(a));
  }

  static class Solution {
    public Node construcBalancedBST(int[] a) {
      if (a == null || a.length == 0) {
        return null;
      }

      int n = a.length;

      return buildTree(a, 0, n-1);
    }

    private Node buildTree(int[] a, int left, int right) {
      if (right < left) {
        return null;
      }

      int mid = left + (right - left) / 2;
      Node root = new Node(a[mid]);
      root.left = buildTree(a, left, mid - 1);
      root.right = buildTree(a, mid + 1, right);

      return root;
    }

  }

  static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }


  }
}
