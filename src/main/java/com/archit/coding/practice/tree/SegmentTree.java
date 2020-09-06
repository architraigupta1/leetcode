package com.archit.coding.practice.tree;

import com.archit.coding.utils.MathUtil;

import java.util.Arrays;

public class SegmentTree {
  public static void main(String[] args) {
    int input[] = {0,3,4,2,1,6,-1};
    int n = input.length;
    SegmentTree segmentTreeObj = new SegmentTree();
    int[] segmentTree = segmentTreeObj.create(input);
    assert  0 == segmentTreeObj.rangeMinimumQuery(segmentTree, 0, 3, n);
    assert 1 == segmentTreeObj.rangeMinimumQuery(segmentTree, 1, 5, n);
    assert -10 == segmentTreeObj.rangeMinimumQuery(segmentTree, 1, 6, n);
  }

  private int rangeMinimumQuery(int[] segmentTree, int qLow, int qHigh, int inputLength) {
    return this.rangeMinimumQuery(segmentTree, 0, inputLength - 1, qLow, qHigh, 0);
  }

  private int rangeMinimumQuery(int[] segmentTree, int low, int high, int qLow, int qHigh, int index) {
    //if total overlap then we have already computed the answer, no need to check
    // in left and right subtree. Return the value of current node
    if(qLow <= low && qHigh >= high) {
      return segmentTree[index];
    }

    //if no overlap, then return a MAX_VALUE as this range has no contribution to our query
    if(qLow > high || qHigh < low) {
      return Integer.MAX_VALUE;
    }

    //if partial overlap, then we need to check in both left and right subtree
    //and return the minimum of the two values.
    int mid = low + (high - low) / 2;
    return Math.min(
        rangeMinimumQuery(segmentTree, low, mid, qLow, qHigh, 2 * index + 1),
        rangeMinimumQuery(segmentTree, mid + 1, high, qLow, qHigh, 2 * index + 2)
    );
  }

  private int[] create(int[] input) {
    int n = input.length;
    //calculate the length of segment tree
    int nextPowerOfTwo = MathUtil.getNextPowerOfTwo(n);
    int segmentTreeLength = 2 * nextPowerOfTwo - 1;

    //init an array to store the segment tree
    int[] segmentTree = new int[segmentTreeLength];

    //fill all the nodes of tree with MAX_VALUE
    Arrays.fill(segmentTree, Integer.MAX_VALUE);

    this.constructMinSegmentTree(input, segmentTree, 0, n-1, 0);
    return segmentTree;
  }

  private void constructMinSegmentTree(int[] input, int[] segmentTree, int low, int high, int index) {
    //populate the leaf node and return. Leaf nodes contain the actual array element
    if (low == high) {
      segmentTree[index] = input[low];
      return;
    }

    //divide the array into tow halves one will become left subtree and other will be right subtree
    int mid = low + (high - low) / 2;
    //construct left subtree
    constructMinSegmentTree(input, segmentTree, low, mid, 2 * index + 1);
    //construct right subtree
    constructMinSegmentTree(input, segmentTree, mid + 1, high, 2 * index + 2);
    //fill the current root node based on the query logic (min/max/sum etc)
    //Here, root value will be the minimum of left and right child which are already populated
    segmentTree[index] = Math.min(segmentTree[2 * index + 1], segmentTree[2 * index + 2]);
  }
}
