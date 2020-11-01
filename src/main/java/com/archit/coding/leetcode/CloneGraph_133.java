package com.archit.coding.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph_133 {
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    one.neighbors.add(two);
    two.neighbors.add(one);

    Solution s = new Solution();
    Node cloneOne = s.cloneGraph(one);
    System.out.println();

  }


  static class Solution {
    public Node cloneGraph(Node node) {
      if (node == null) {
        return null;
      }

      //clone the root node
      Node cloneNode = new Node(node.val);
      if (node.neighbors == null || node.neighbors.isEmpty()) {
        return cloneNode;
      }

      //map stores node.val -> Node
      Map<Integer, Node> map = new HashMap<>();
      map.put(cloneNode.val, cloneNode);
      cloneNode(node, cloneNode, map);
      return cloneNode;

    }

    private void cloneNode(Node originalNode,
                           Node cloneNode, Map<Integer, Node> map) {
      if (cloneNode.neighbors.size() == originalNode.neighbors.size()) {
        return;
      }

      List<Node> clonedNei = cloneNode.neighbors;
      for (Node nei : originalNode.neighbors) {
        Node neiClone = map.getOrDefault(nei.val, new Node(nei.val));
        clonedNei.add(neiClone);
        map.put(neiClone.val, neiClone);
        cloneNode(nei, neiClone, map);
      }
    }
  }

  // Definition for a Node.
  static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}


