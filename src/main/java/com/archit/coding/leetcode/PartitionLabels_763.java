package com.archit.coding.leetcode;

import com.archit.coding.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels_763 {
  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> result = s.partitionLabels("ababcbacadefegdehijhklij");
    ArrayUtil.printIntegerList(result);
  }

  static class Solution {
    public List<Integer> partitionLabels(String s) {
      if (s == null || s.isEmpty()) {
        return new ArrayList<>();
      }

      List<Integer> result = new ArrayList<>();

      Node[] nodes = new Node[26];
      for (int i = 0; i < s.length(); i++) {
        int index = s.charAt(i) - 'a';
        if (nodes[index] == null) {
          nodes[index] = new Node(i, i);
        } else {
          nodes[index].end = i;
        }
      }

      List<Node> nodeList = new ArrayList<>();
      for (int i = 0; i < 26; i++) {
        if (nodes[i] != null) {
          nodeList.add(nodes[i]);
        }
      }

      Collections.sort(nodeList,
          (a, b) -> a.start < b.start ? -1 : a.start == b.start ? 0 : 1);
      List<Node> merged = new ArrayList<>();
      Node prev = nodeList.get(0);
      for (int i = 1; i < nodeList.size(); i++) {


        Node cur = nodeList.get(i);
        if (prev.end > cur.start && prev.start < cur.end) {
          prev.end = Math.max(prev.end, cur.end);
        } else {
          merged.add(prev);
          prev = cur;
        }
      }

      merged.add(prev);

      for (int i = 0; i < merged.size(); i++) {
        Node node = merged.get(i);
        Integer range = node.end - node.start + 1;
        result.add(range);
      }

      return result;
    }
  }

  static class Node {
    int start;
    int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

/*
lowercase
*/
}
